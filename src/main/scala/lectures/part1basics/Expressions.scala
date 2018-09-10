package lectures.part1basics

/**
  * Created by Jake Barnes on 10/09/2018
  */
object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x) // print false
  // == != > >= < <=

  println(!(1 == x))

  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /= ..... all side effects, only works with variables
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS

  // EVERYTHING in Scala is an Expression!!!!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  val aCodeBlock = {
    val y = 4
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" and println("hello world")?
  // 2.

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 678
    42
  }

  // 1.answer -> "hello world" is a val string, println("hello world") is unit with a side effect
  // 2.answer -> someValue is an expression of a value (Boolean true), someOtherValue is an expression of a value (Int 42)


}
