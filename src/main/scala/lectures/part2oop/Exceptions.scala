package lectures.part2oop

import javax.swing.plaf.metal.MetalIconFactory.PaletteCloseIcon

/**
  * Created by Jake Barnes on 04/11/2018
  */
object Exceptions extends App {

  val x: String = null
  //  println(x)
  //  This ^^ will crash with a null pointer exception

  // 1. throwing exceptions

  //  val aWeirdValue = throw new NullPointerException
  // throwable classes extend the Throwable class.
  // Exception and error are the major Throwable subtypes

  // 2. catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    //    case e: RuntimeException => println("Caught a runtime exception")
    case e: RuntimeException => 43
    //    case e: NullPointerException => println("Caught a runtime exception")
  } finally {
    // code that gets executed no matter what
    // optional
    // does not influence the return type of the expression
    // use finally only for side effects
    println("Finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //  throw exception

  // Exercises

  // OOM
  //  val bigArray = Array.ofDim(Int.MaxValue)

  // SO
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  //  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.divide(2, 0))

}
