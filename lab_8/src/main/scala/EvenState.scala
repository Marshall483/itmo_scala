case class EvenState(n: Int) extends IterState[Any, Unit] {
  override def hasNext: Boolean = true

  override def next: (Option[Int], EvenState) = {
    val nextValue = n + 2
    (Some(n), EvenState(nextValue))
  }
}

object EvenIterator {
  def apply(): EvenState = EvenState(2)
}