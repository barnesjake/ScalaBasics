package lectures.part2oop

/**
  * Created by Jake Barnes on 24/09/2018
  */
object OOBasics extends App {

  val person = new Person("Bob Ross", 42)
  println(person.x)
  person.greet("Barack")
  person.greet()

  //CLASS PARAMETERS ARE NOT FIELDS
  // constructor
  class Person(name: String, val age: Int = 0) {
    //body
    val x = 22
    println(1 + 1)

    def greet(name: String): Unit = println(s"${this.name} says: Hello $name")

    //overloading
    def greet(): Unit = println(s"Hello $name")

    //multiple constructors
    def this(name: String) = this(name, 0)

    def this() = this("John Doe")

  }

}
