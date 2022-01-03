package kotlinStudy

/*
1. #-----------------------------#
       * O.. M.. G *
       용돈기입장

       // function
       0. init
          - money
          - name

       1. in(수입)
          - content
          - money

       2. out (지출)
          - content
          - money

       3. read
          -content  - out/in money   - extra money
          -content  - out/in money   - extra money
          -content  - out/in money   - extra money
          -content  - out/in money   - extra money  */


var extraMoney: Int = 0
var extraMoneyHistory = mutableListOf<Int>(extraMoney)
var cashInHistory = mutableMapOf("내용" to "입출금액")
var countHistory: Int = 0
fun main() {


    while (info() != 4) {
        if (info() == 1) {

            print("얼마를 넣을까요? : ")
            var putMoney = readLine()!!.toInt()
            cashIn(putMoney)
            extraMoneyHistory.add(putMoney)
            print("내용은 무엇인가요? : ")
            var writeHistory = readLine().toString()
            cashInHistory.put("${writeHistory}", "${putMoney}원 수입")

        } else if (info() == 2) {
            print("얼마를 뺄까요? : ")
            var outMoney = readLine()!!.toInt()
            cashOut(outMoney)
            extraMoneyHistory.add(outMoney)
            print("내용은 무엇인가요? : ")
            var writeHistory = readLine().toString()
            cashInHistory.put("${writeHistory}", "${outMoney}원 지출")

        } else if (info() == 3){
            println("기록을 확인합니다")
            for (enrty in cashInHistory){ println("${enrty.key}. ${enrty.value}. 잔액 = ${extraMoneyHistory[countHistory++]}")
            }
        }
    }



}
fun info(): Int {
    println("\n용돈 기입장\n현재 잔고는 ${extraMoney}원 입니다")
    println("1 = 수입을 기록한다\n2 = 지출을 기록한다\n3 = 기록을 확인한다\n4 = 종료 한다")
    print("어떤 활동을 할까요? : ")
    var inPut = readLine()!!.toInt()

    return inPut
}

fun cashIn(a: Int): Int{
    extraMoney += a
    return extraMoney
}
fun cashOut(a: Int): Int{
    extraMoney -= a
    return extraMoney
}

