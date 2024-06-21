object test extends App {

  var iterators = (0 until 4).map(RealNumberIterator(_))
  var current_new_iter = 0
  val diagIter = DiagonalIterator(EvenIterator())
  var currentIter = diagIter

  for (_ <- 1 to 50) {
    if (currentIter.hasNext) {
      val (elem, nextIter, number_new_iter) = currentIter.next
      currentIter = nextIter
      var ind = 0
      while (ind < number_new_iter) {
        ind += 1
        if (current_new_iter < iterators.length) currentIter = currentIter.add_iter(iterators(current_new_iter))
        current_new_iter += 1
      }
      print(elem.get + ", ")
    }
  }
}
