package kotlinStudy

fun main() {
    val jungWoo = User(name = "Jung Woo", money = 0)

    val ui = UI()
    val accountBook = AccountBook()

    while(true){
        val selectedMenu = ui.showMainScreen()

        when(selectedMenu) {
            "1" -> {
                val record = ui.showIncomeScreen()
                accountBook.recordIncome(jungWoo, record)
            }
            "2" -> {
                val record = ui.showExpandScreen()
                if(record != null) {
                    val isSuccess = accountBook.recordExpand(jungWoo, record)

                    if(!isSuccess) {
                        println("돈이 충분하지 않습니다.")
                        ui.showExpandScreen()
                    }
                }
            }

            "3" -> {
                val records = accountBook.getUserRecords()
                ui.showRecords(records)
            }

            "4" -> {
                println("종료합니다.")
                break
            }
        }
    }
}

class AccountBook() {

    private val records: MutableList<Record> = mutableListOf()
    private val mapRecords: MutableMap<User, List<Record>> = mutableMapOf()

    fun recordIncome(user: User, record: Record) {
        user.money += record.money
        record.extraMoney = user.money
        records.add(record)
    }

    fun recordExpand(user: User, record: Record): Boolean {
        if(isMoneyEnough(user, record.money)) {
            user.money -= record.money
            record.extraMoney = user.money
            records.add(record)

            return true
        } else {
            return false
        }
    }

    fun getUserRecords(): List<Record> {
        return records.toList()
    }

    private fun isMoneyEnough(user: User, expandMoney: Int): Boolean {
        return user.money >= expandMoney
    }
}

typealias SelectedMenu = String
class UI() {
    fun showMainScreen(): SelectedMenu {
        println("\n용돈 기입장")
        println("1 = 수입을 기록한다\n2 = 지출을 기록한다\n3 = 기록을 확인한다\n4 = 종료 한다")
        print("어떤 활동을 할까요? : ")
        return readLine().toString()
    }

    fun showIncomeScreen(): Record {
        print("얼마를 넣을까요? : ")
        val money = readLine()?.toInt() ?: 0

        print("내용은 무엇인가요? : ")
        val incomeHistory = readLine()?.toString() ?: ""

        return Record(MethodType.INCOME, money, incomeHistory)
    }

    fun showExpandScreen(): Record? {
        println("[나가기 - press 0]")
        print("얼마를 뺄까요? : ")
        val money = readLine()?.toInt() ?: 0

        if(money == 0) return null

        print("내용은 무엇인가요? : ")
        val expandHistory = readLine()?.toString() ?: ""

        return Record(MethodType.EXPAND, money, expandHistory)
    }

    fun showRecords(records: List<Record>) {
        println("-------- * [수입/지출] 기록 * --------")
        for(record in records) {
            println("[${record.type.body}] - [${record.money}] - [${record.history}] - 현재잔액은 ${record.extraMoney}")
        }

        println("-----------------------------")
    }
}

enum class MethodType(val body: String){
    INCOME("수입"), EXPAND("지출")
}

class Record(
    val type: MethodType,
    val money: Int,
    val history: String
) {
    var extraMoney = 0
}

class User(
    val name: String,
    var money: Int
)