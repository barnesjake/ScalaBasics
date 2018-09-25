package lectures.part2oop

/**
  * Created by Jake Barnes on 25/09/2018
  */
object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // note the space, otherwise compiler thinks the ':' is part of the method name
    def unary_! : String = s"$name what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hello, my name is $name and I like $favouriteMovie"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  // infix notation = operator notation (syntactic sugar)
  // only works when there is one parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(tom + mary)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?


  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary operator only works with + - ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)
  // postfix notation is only available to methods without any parameters

  // apply
  println(tom.apply())
  println(tom()) // equivalent

}
