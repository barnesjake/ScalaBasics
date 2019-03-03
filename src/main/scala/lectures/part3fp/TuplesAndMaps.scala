package lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  //  val aTuple = new Tuple2(2, "hello, scala") // Tuple2[Int, String] = (Int, String)
  //  val aTuple = Tuple2(2, "hello, scala") // Tuple2[Int, String] = (Int, String)
  val aTuple = (2, "hello, scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple.copy(_2 = "goodbye, Java"))
  println(aTuple.swap)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  //  val phoneBook = Map(("Jim", 555), ("Daniel", 789))
  val phoneBook = Map("Jim" -> 555, "Daniel" -> 789, "JIM" -> 900).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary")) // will cause NoSuchElementException without .withDefaultValue()

  // add a pairing
  val newPairing = "Mary" -> 876
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functionals on maps
  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(_.startsWith("J")))

  // mapValues
  println(phoneBook.mapValues(number => number * 10))
  println(phoneBook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Jake", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
      1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900?
          !!! Careful when mapping keys !!!

      2. Overly simplified social network based on maps
          Person = String
          - add a person to the network
          - remove a person
          - friend (mutual)
          - unfriend

          - number of friends of a person
          - person with most friends
          - how many people have no friends
          - if there is a social connection between two people (direct or not)
  */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))

  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val emptyNet: Map[String, Set[String]] = Map()
  val network = add(add(emptyNet, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //Jim, Bob, Mary
  val people = add(add(add(emptyNet, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNetwork = friend(jimBob, "Bob", "Mary")

  println(people)
  println(jimBob)
  println(testNetwork)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNetwork, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNetwork))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
  //    network.count(pair => pair._2.isEmpty)
    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNetwork))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoverablePeople: Set[String]): Boolean = {
      if (discoverablePeople.isEmpty) false
      else {
        val person = discoverablePeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoverablePeople.tail)
        else bfs(target, consideredPeople + person, discoverablePeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNetwork, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

}
