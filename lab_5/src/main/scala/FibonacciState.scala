case class FibonacciState(a: Int, b: Int) extends IterState[Int, Unit] {
  override def hasNext: Boolean = true

  override def next: (Option[Int], FibonacciState) = {
    val nextValue = a + b
    (Some(a), FibonacciState(b, nextValue))
  }
}

object FibonacciIterator {
  def apply(): FibonacciState = FibonacciState(0, 1)
}