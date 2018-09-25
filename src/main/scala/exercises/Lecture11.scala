package exercises

/**
  * Created by Jake Barnes on 24/09/2018
  */
object Lecture11 extends App {

  val author = new Writer("George", "Orwell", 1903)
  val novel = new Novel("1984", 1949, author)

  println(author.fullName)
  println(novel.authorAge())
  println(novel.releaseDate)
  println(novel.isWrittenBy(author))
  println(novel.copy(2018).releaseDate)
  println(novel.releaseDate)

  println("\n")

  val counter = new Counter
  counter.increment.increment.increment.increment.print()
  counter.increment(5).print()


  class Novel(name: String, val releaseDate: Int, author: Writer) {

    def authorAge(): Int = releaseDate - author.dob

    def isWrittenBy(author: Writer): Boolean = author == this.author

    def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

  }

  class Writer(firstName: String, surname: String, val dob: Int) {

    def fullName: String = s"$firstName $surname"

  }

  class Counter(val value: Int = 0) {

    def currentCount(): Int = value

    def increment: Counter = {
      println("Incrementing")
      new Counter(value + 1)
    }

    def increment(n: Int): Counter = {
      if (n <= 0) this
      else increment.increment(n - 1)
    }

    def decrement: Counter = {
      println("Decrementing")
      new Counter(value - 1)
    }

    def decrement(n: Int): Counter = {
      if (n <= 0) this
      else decrement.decrement(n - 1)
    }

    def print(): Unit = println(value)

  }

}