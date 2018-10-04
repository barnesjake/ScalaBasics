package lectures.part2oop

/**
  * Created by Jake Barnes on 01/10/2018
  */
object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val n_eyes = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality

  }

  // COMPANIONS

  def main(args: Array[String]) {

    println(Person.n_eyes)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val john = Person
    println(mary == john)

    val mary1 = new Person("Mary")
    val john1 = new Person("John")
    println(mary1 == john1)

    val bobby = Person.apply(mary1, john1)
    println(bobby.name)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
  }
}
