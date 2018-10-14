package exercises


/**
  * Created by Jake Barnes on 06/10/2018
  */
abstract class GenericMyList[+A] {
  def head: A
  def tail: GenericMyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericMyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): GenericMyList[B]
  def filter(predicate: MyPredicate[A]): GenericMyList[A]
//  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B]
}

case object Empty extends GenericMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericMyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): GenericMyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): GenericMyList[Nothing] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing, GenericMyList[B]]): GenericMyList[B] = Empty
}

case class Cons[+A](h: A, t: GenericMyList[A]) extends GenericMyList[A] {
  def head: A = h
  def tail: GenericMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): GenericMyList[B] = new Cons(element, this)

  def printElements: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: MyTransformer[A, B]): GenericMyList[B] =
    new Cons(transformer.convert(h), t.map(transformer))

  def filter(predicate: MyPredicate[A]): GenericMyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
//  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B]
}
trait MyPredicate[-T] {
  def test(input: T): Boolean
}
trait MyTransformer[-A, B] {
  def convert(input: A): B
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(input: Int): Boolean = {
    if (input % 2 == 0) true
    else false
  }
}
class StringToIntTransformer extends MyTransformer[String, Int] {
  override def convert(input: String): Int = ???
}

object ListTest extends App {
  val listOfIntegers: GenericMyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: GenericMyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: GenericMyList[String] = new Cons("Hello", new Cons("World!", Empty))
  println(listOfIntegers).toString
  println(listOfStrings).toString


  /*
   1. Generic trait MyPredicate[-T] with a method test(T) => Boolean
   2. Generic trait MyTransformer[-A, B], method to convert A to B
   3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]


     class EvenPredicate extends MyPredicate[Int]
     class StringToIntTransformer extends MyTransformer[String, Int]

     [1, 2, 3].map(n * 2) = [2, 4, 6]
     [1, 2, 3, 4].filter(n % 2) = [2, 4]
     [1, 2, 3].flatMap(n => [n + 1]) => [1,2,2,3,3,4]
   */

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def convert(input: Int): Int = input * 2
  }).toString)

  println(cloneListOfIntegers == listOfIntegers)

}
