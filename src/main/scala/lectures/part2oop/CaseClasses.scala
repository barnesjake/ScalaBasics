package lectures.part2oop

/**
  * Created by Jake Barnes on 14/10/2018
  */
object CaseClasses extends App {

  /*
      equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 25)
  println(jim.name)

  // 2. sensible toString -- useful for debugging
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 25)
  val jim3 = new Person("Jim", 34)

  println(jim == jim2)
  println(jim == jim3)

  // 4. case classes have handy copy methods
  val jim4 = jim.copy()
  println(jim4)
  val jim5 = jim.copy(age = 45)
  println(jim5)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 24)
  println(thePerson)
  println(mary)

  // 6. case classes are serializable
  // Akka

  // 7. case classes have extractor patterns => case classes can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and RI"
  }

}
