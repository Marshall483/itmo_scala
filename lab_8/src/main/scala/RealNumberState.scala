case class RealNumberState(current: Double, step: Double) extends IterState[Any, Unit] {
  override def hasNext: Boolean = current < 4.0

  override def next: (Option[Double], RealNumberState) = {
    val nextValue = current
    (Some(nextValue), RealNumberState(current + step, step))
  }
}

object RealNumberIterator {
  def apply(i: Int): RealNumberState = RealNumberState(0.0, 1.0 + i * 0.1)
}