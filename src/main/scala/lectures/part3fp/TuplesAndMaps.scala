package lectures.part3fp

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
  val phoneBook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1)
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

}
