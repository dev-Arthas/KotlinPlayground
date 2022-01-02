package kotlinStudy

fun main(){
    var a = 12
    var b = 2L

    var c = 12.1
    var d = 12.3f

    var e = 0xAAA
    var f = 0b1001101

    var g = 'a'
    var h = "asdsdsds"

    var i = true
    var j = false
    println( add(a, a, a))
    println(add2(a,a,a))


}
fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun add2(a :Int, b: Int, c: Int) = a + b + c //단일 표현식