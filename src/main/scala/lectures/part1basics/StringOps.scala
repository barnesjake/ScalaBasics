package lectures.part1basics

/**
  * Created by Jake Barnes on 24/09/2018
  */
object StringOps extends App {

  val aString: String = "Hello this is a fairly long string."

  println(aString.charAt(2))
  println(aString.substring(6, 11)) //first index inclusive, second index exclusive
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  println(aString.replace(" ", "-"))
  println(aString.toLowerCase)
  println(aString.length)

  val aNumberString = "42"
  val aNumber = aNumberString.toInt
  println(s"Number string: $aNumberString, converted to an int: $aNumber")

  println('a' +: aNumberString) // prepend the character a to a string using +:
  println(aNumberString :+ 'z') // append a character using :+

  println(aString.reverse)
  println(aString.take(2))

  // Scala-specific: String interpolator
  val name = "Mark Corragon"
  val age = 40
  val greeting = s"Hello $name, you are $age years old"
  println(greeting)
  val anotherGreeting = s"Hello, $name, you will be ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolator
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
