package kotlinStudy

fun main(){
    var a = "Kim Jeong Woo"

    println(a.length)
    println(a.toLowerCase()) //전체 소문자
    println(a.toUpperCase()) //전체 대문자

    var a2 = a.split("") // 띄어쓰기를 기준으로 a를 배열에 담음
    println(a2)

    /*println(a2.joinToString()) // 문자열을 합쳐줌
    println(a2.joinToString(" "))

    println(a.substring(2..7))*/

}