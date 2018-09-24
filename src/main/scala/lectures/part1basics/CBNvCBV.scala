package lectures.part1basics

/**
  * Created by Jake Barnes on 21/09/2018
  */
object CBNvCBV extends App {

  def callByValue(number: Long): Unit = {
    println("By value: " + number)
    println("By value: " + number)
  }

  def callByName(number: => Long): Unit = {
    println("By name:" + number)
    println("By name:" + number)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(n: Int, m: => Int ): Unit = println(n)

//  printFirst(infinite(), 34) -- will cause a stack overflow
  printFirst(34, infinite())

  /*
  Call by value:    def myFunction(x: Int): Int =
  -- value is computed before call
  -- same value is used everywhere

  Call by name:     def myFunction(x: => Int): Int =
  -- expression is passed as is
  -- expression is evaluated at every use within the function definition
   */


}
