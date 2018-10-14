package lectures.part2oop

/**
  * Created by Jake Barnes on 06/10/2018
  */
object Generics extends App {

  class MyList[+A] {
    // use the type A in the class definition
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog = Animal
     */
  }

  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. YES List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // +A = covariant list
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add[new Dog]??? HARD QUESTION. => we return a list of Animals

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. HELL, NO! = CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // subtype
  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Cat) // results in compile error

  // expand MyList to be generic


}
