case class OptionIterState[E](opt: Option[E]) extends IterState[E, Option[E]] {
  override def hasNext: Boolean = opt.isDefined

  override def next: (Option[E], IterState[E, Option[E]]) = opt match {
    case Some(value) => (Some(value), OptionIterState(None))
    case None => (None, this)
  }
}