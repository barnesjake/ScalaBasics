package lectures.part1basics

/**
  * Created by Jake Barnes on 24/09/2018
  */
object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)


  val fact10 = println(trFact(10))
  val fact9 = println(trFact(9, 2))


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture...")

  savePicture()
  savePicture(width = 800)

  /*
      1. pass in every leading argument
      2. name the arguments
   */

  savePicture(height = 1, width = 1, format = ".txt")
}
