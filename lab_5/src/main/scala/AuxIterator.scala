case class AuxState(n: Int, lim: Int) extends IterState[Int, Unit] {
  override def hasNext: Boolean = n < lim

  override def next: (Option[Int], AuxState) = {
    val nextValue = n + 1
    (Some(n), AuxState(nextValue, lim))
  }
}

object AuxIterator {
  def apply(lim: Int = 0): AuxState = AuxState(0, lim)
}
