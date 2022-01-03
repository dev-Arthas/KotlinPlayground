package kotlinStudy

fun main(){

    var Dog = Animal("Doki", 5)
    var Human = Person("Park", 24)
    var Human2 = Person("Kim",51)
    var Human3 = Person("Kyeong",26)

    println(Dog.name)
    println(Dog.age)

    Dog.ID()
    Human.ID()


}
class Animal(var name: String, var age: Int){
    fun ID(){
        println("I`m a Dog ${name} and ${age} years old")
    }
}

class Person(var name: String, var age: Int, var sex: String){
    constructor(name:String, age: Int) :this(name, age, "male")
    fun ID(){
        println("I`m a Person ${name} and ${age} years old")
    }
    init {
        println("init function")
        println("${this.name} and ${this.age} and I`m ${this.sex}")
    }
}

