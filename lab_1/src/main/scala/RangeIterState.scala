class RangeIterState(range: Range) extends IterState[Int, Range] {
  private var index = 0

  def hasNext: Boolean = index < range.length

  def next: (Option[Int], IterState[Int, Range]) = {
    val element = if (hasNext) Some(range(index)) else None
    val nextState = new RangeIterState(range)
    nextState.index = index + 1
    (element, nextState)
  }
}