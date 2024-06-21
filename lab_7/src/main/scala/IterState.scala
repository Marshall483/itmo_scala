trait IterState[E, T] {
  def hasNext: Boolean
  def next: (Option[E], IterState[E, T])
}