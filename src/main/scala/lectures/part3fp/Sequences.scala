package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Sequences
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val anotherRange: Seq[Int] = 1 until 10
  anotherRange.foreach(println)

  (1 to 10).foreach(x => println("hello"))

  val aList = List(1, 2, 3)

  val prepended = 42 :: aList
  println(prepended)
  val prepAndAppend = 42 +: aList :+ 77
  println(prepAndAppend)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(numbers)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntactic sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq)

  // vector
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(Vector)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield  {
      val currentTime = System.nanoTime()
      //operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes a long time
  println(getWriteTime(numbersList))
  // depth of the tree
  // needs to replace an entire 32 element chunk
  println(getWriteTime(numbersVector))

}
