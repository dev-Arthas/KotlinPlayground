package kotlinStudy

fun main(){
    var a: Int =1234888
    var b: Long = a.toLong()

    var intArr = arrayOf(1,2,3,4,5)
    var intArr2 = arrayOfNulls<Int>(2)
    var arr = arrayOf("z","sd")

    println(intArr[0] + intArr[2])

    println(arr[1])

    if (intArr[1]==2){
        print("true")
    }

}