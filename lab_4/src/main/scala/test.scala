object test extends App{
  def printFirstNElements(iterator: Iterator[(Int, Int)], n: Int): Unit = {
    for (_ <- 1 to n) {
      print(iterator.next() + ", ")
    }
    print("...")
  }

  println("Testing FirstIterator: ")
  printFirstNElements(FirstIterator, 10)

  println("\nTesting TwoIterator:")
  printFirstNElements(TwoIterator, 10)

  println("\nTesting ThreeIterator:")
  printFirstNElements(ThreeIterator, 10)
}
