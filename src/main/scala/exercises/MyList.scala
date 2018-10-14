//package exercises
//
///**
//  * Created by Jake Barnes on 06/10/2018
//  */
//abstract class MyList {
//
//  /*
//      head = first element of the list
//      tail = remainder of the list
//      isEmpty = is this empty (Boolean)
//      add(int) => new list with this element added
//      toString => a string representation of the list
//   */
//
//  def head: Int
//
//  def tail: MyList
//
//  def isEmpty: Boolean
//
//  def add(int: Int): MyList
//
//  def printElements: String
//  // polymorphic call
//  override def toString: String = "[" + printElements + "]"
//
//
//}
//
//object Empty extends MyList {
//  def head: Int = throw new NoSuchElementException
//
//  def tail: MyList = throw new NoSuchElementException
//
//  def isEmpty: Boolean = true
//
//  def add(int: Int): MyList = new Cons(int, Empty)
//
//  def printElements: String = ""
//}
//
//class Cons(h: Int, t: MyList) extends MyList {
//  def head: Int = h
//
//  def tail: MyList = t
//
//  def isEmpty: Boolean = false
//
//  def add(int: Int): MyList = new Cons(int, this)
//
//  def printElements: String =
//    if (tail.isEmpty) "" + h
//    else h + " " + t.printElements
//}
//
//object ListTest extends App {
//  val list = new Cons(1, Empty)
//  println(list.head)
//  println(list.tail)
//  println(list.isEmpty)
//  val anotherList = new Cons(2, new Cons(2, new Cons(3, Empty)))
//  println(anotherList.head)
//  println(anotherList.tail)
//  println(anotherList.isEmpty)
//
//  println(list.add(4).head)
//
//  println(list.toString)
//  println(anotherList.toString)
//}