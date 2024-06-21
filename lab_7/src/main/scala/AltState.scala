case class AltState(is_alter: Boolean) extends IterState[Boolean, Unit] {
  override def hasNext: Boolean = true

  override def next: (Option[Boolean], AltState) = {
    val nextValue = !is_alter
    (Some(is_alter), AltState(nextValue))
  }
}

object AltIterator {
  def apply(): AltState = AltState(true)
}
