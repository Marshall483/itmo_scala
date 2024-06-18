object test extends App {
  val evenIter = EvenIterator()
  val fibIter = FibonacciIterator()
  val combinedIter = CombinedIterator(evenIter, fibIter)

  var currentIter = combinedIter

  for (_ <- 1 to 50) {
    if (currentIter.hasNext) {
      val (pair, nextIter) = currentIter.next
      pair.foreach(print)
      print(", ")
      currentIter = nextIter
    }
  }
}