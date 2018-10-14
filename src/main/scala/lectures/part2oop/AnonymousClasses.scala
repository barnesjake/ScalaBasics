package lectures.part2oop

/**
  * Created by Jake Barnes on 09/10/2018
  */
object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("lololololololol")
  }

  println(funnyAnimal.getClass)

  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("lololololololol")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi my name is Jim, how can I be of service?")
  }
}
