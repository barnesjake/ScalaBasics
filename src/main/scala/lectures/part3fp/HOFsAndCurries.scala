package lectures.part3fp

/**
  * Created by Jake Barnes on 30/12/2018
  */
object HOFsAndCurries extends App {

  val superFunction: (Int, (String, Int => Boolean) => Int) => (Int => Int) = null
  // higher order function (HOF)

  // map, flatMap, filter in MyList

  // function that applies a function n times over a value
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2 f(x)) = f(f(f(x)))
  // nTimes (f , n, x) = f(f(...(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // nTimesBetter(f, n) => f(f(f...(x)))
  // increment10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne...(x))
  // val y = increment10(i)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  val plus0 = nTimesBetter(plusOne, 0)

  println(plus10(1))
  println(plus10(0))
  println(plus0(0))
  println(plus0(5))

  // curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10)) // actual function called
  println(add3) // just the function itself

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))


}
