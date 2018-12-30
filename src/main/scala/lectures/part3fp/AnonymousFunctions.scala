package lectures.part3fp

/**
  * Created by Jake Barnes on 30/12/2018
  */
object AnonymousFunctions extends App {

  // Anonymous function (LAMBDA)
  val doubler: Int => Int = (x: Int) => x * 2
  //  val doubler = (x: Int) => x * 2
  //  val doubler: Int => Int = x => x * 2

  // multiple parameters in a lambda
  val adder = (a: Int, b: Int) => a + b
  //  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no parameters
  val justDoSomething = () => 5
  //  val justDoSomething: () => Int = () => 5

  // careful
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
      1. MyList: replace all FunctionX calls with lambdas
      2. Rewrite the "special" adder from previous tutorial as an anonymous function
   */

  val anonymousAdder = (x: Int) => (y: Int) => x + y
  println(anonymousAdder(3)(5))
}
