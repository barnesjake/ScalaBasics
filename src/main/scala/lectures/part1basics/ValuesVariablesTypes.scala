package lectures.part1basics

/**
  * Created by Jake Barnes on 10/09/2018
  */
object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // VALS = IMMUTABLE
  // VARS = MUTABLE

  // Compiler can infer types

  val aString: String = "Hello"
  val anotherString: String = "Goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort : Short = 4616 // 2 bytes, compiler will complain if the number is too big for an int
  val aLong: Long = 1234567890123456789L // 8 bytes, compiler will complain if the number is too big for an int, add 'L'
  val aFloat: Float = 2.0F // have to have 'F' otherwise compiler thinks it's a double
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // vars have side effects


}
