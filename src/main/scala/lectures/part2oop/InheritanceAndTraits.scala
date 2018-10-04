package lectures.part2oop

/**
  * Created by Jake Barnes on 04/10/2018
  */
object InheritanceAndTraits extends App {

  // single class inheritance - only extend one class at a time
  class Animal {
    def eat = println("nomnomnom")
    val creatureType = "Wild"
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
//  cat.eat
  cat.crunch()

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class OAP(name: String, age: Int, busPass: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
//    override val creatureType: String = "Pet" // uncomment to override the creatureType value
  }
//  class Dog(dogType: String) extends Animal {
//    override val creatureType: String = dogType
//    override def eat: Unit = println("crunch, crunch, crunch")
//  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad sense: polymorphism
  val unknownAnimal: Animal = new Dog("k9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - final on entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files

}
