package lectures.part3fp

/**
  * Created by Jake Barnes on 27/12/2018
  */
object WhatsAFunction extends App {
  // DREAM: use functions as first class elements
  // problem: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(3))

  // Function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("7") + 3)


  //NOTE syntactic sugar: Function2[Int, Int, Int] == (Int, Int) => Int)
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //Function types = Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
      1. a function which takes two strings and concatenates them
      2. transform the MyTransformer and MyPredicate into function types
      3. define a function which takes an int and returns another function which takes an int and returns an int
         - whats the type of this function
         - how to implement this function
   */

  val stringConcatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(stringConcatenator("Hello", "World"))

  val someFunction: (Int) => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val someAdder = someFunction(3)
  println(someAdder(7))
  println(someFunction(3)(4)) // curried function

}


trait MyFunction[A, B] {
  def apply(element: A): B
}
