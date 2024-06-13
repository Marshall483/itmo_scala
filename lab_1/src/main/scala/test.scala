object test extends App{
  def testListIterator(): Unit = {
    val list = List(1, 2, 3, 4, 5)
    var iterState: IterState[Int, List[Int]] = new ListIterState(list)

    while(iterState.hasNext) {
      val (element, nextState) = iterState.next
      println(s"List element: $element")
      iterState = nextState
    }
  }

  def testOptionIterator(): Unit = {
    val optionIter = OptionIterState(Some(54))

    var currentOptionIter: IterState[Int, Option[Int]] = optionIter
    while (currentOptionIter.hasNext) {
      val (value, nextIter) = currentOptionIter.next
      println(value)
      currentOptionIter = nextIter
    }
  }

  def testRangeIterator(): Unit = {
    val range = 1 to 5
    var iterState: IterState[Int, Range] = new RangeIterState(range)

    while(iterState.hasNext) {
      val (element, nextState) = iterState.next
      println(s"Range element: $element")
      iterState = nextState
    }
  }
  testListIterator()
  testOptionIterator()
  testRangeIterator()
}
