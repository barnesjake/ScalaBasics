package lectures.part1basics

import scala.annotation.tailrec

/**
  * Created by Jake Barnes on 18/09/2018
  */
object Recursion extends App {

  def factorialFunction(n: Int): Int = {
    if (n <= 0) n * factorialFunction(n - 1)
    else {
      println(s"Computing the factorial of $n - I first need the factorial of ${n - 1}")
      val result = n * factorialFunction(n - 1)
      println(s"Computed the value of $n")
      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1) // TAIL RECURSION = use recursive call as LAST expression
  }

  //  println(anotherFactorial(5000))

  // When you need loops, user _TAIL_RECURSION.

  /*
    1. Concatenate a string n times.
    2. IsPrime function tail recursive.
    3. Fibonacci function tail recursive.
   */

  @tailrec
  def concatenateString(string: String, n: BigInt, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateString(string, n - 1, string + accumulator)
  }

  println(concatenateString("helloWorld", 5, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRecursion(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRecursion(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRecursion(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))


  def fibonacciFunctionTailRecursive(n: Int): Int = {
    def fibHelper(x: Int, last: Int, nextLast: Int): Int =
      if (x >= n) last
      else fibHelper(x + 1, last + nextLast, last)

    if (n <= 2) 1
    else fibHelper(2, 1, 1)
  }

  println(fibonacciFunctionTailRecursive(8))

  /*
  So general rule of thumb is however many recursive calls you have on the same code path.
  That's how many accumulators you need to have in the tail recursive function version of the function
   */

}
