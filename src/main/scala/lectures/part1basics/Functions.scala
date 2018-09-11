package lectures.part1basics

/**
  * Created by Jake Barnes on 11/09/2018
  */
object Functions extends App {

  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("hello world", 1))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 5))

  // WHEN YOU NEED LOOPS, USE RECURSION!!!!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1)
  }

  /*
     1.  A greeting function (name, age) => "Hi my name is $name and i am $age years old"
     2.  Factorial function 1 * 2 * 3 * ... * n
     3.  Fibonacci function
         f(1) = 1
         f(2) = 1
         f(n) = f(n - 1) + f(n - 1)
     4.  Function to test if a number is prime
   */

  def greeterFunction(name: String, age: Int): String = {
    s"Hi my name is $name and i am $age years old"
  }

  println(greeterFunction("SomeName", 42))

  def factorialFunction(n: Int): Int = {
    if (n <= 0) n * factorialFunction(n - 1)
    else n
  }

  println(factorialFunction(6))

  def fibonacciFunction(n: Int): Int = {
    if (n <= 0) 1
    else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)
  }

  println(fibonacciFunction(3))

  def primeFunction(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(primeFunction(37))
  println(primeFunction(2003))
  println(primeFunction(42 * 2))

}
