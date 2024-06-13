class ListIterState[E](list: List[E]) extends IterState[E, List[E]] {
  private var index = 0

  def hasNext: Boolean = index < list.length

  def next: (Option[E], IterState[E, List[E]]) = {
    val element = if (hasNext) Some(list(index)) else None
    val nextState = new ListIterState(list)
    nextState.index = index + 1
    (element, nextState)
  }
}