package kotlinStudy

fun main(){
    var a: Int =1234888
    var b: Long = a.toLong()

    var intArr = arrayOf(1,2,3,4,5)
    var intArr2 = arrayOfNulls<Int>(2)

    println(intArr[0])

    intArr[0] = 7
    println(intArr[0])

    println(intArr2[1])
}