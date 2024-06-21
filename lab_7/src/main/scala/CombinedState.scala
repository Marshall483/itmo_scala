case class CombinedState(iter1: IterState[Int, Unit], iter2: IterState[Int, Unit], alt_iter: AltState) extends IterState[(Int, Int), Unit] {

  override def hasNext: Boolean = iter1.hasNext || iter2.hasNext

  override def next: (Option[(Int, Int)], CombinedState) = {
    val (useFirst, next_alt_iter) = alt_iter.next
    val (next1Opt, nextIter1) = iter1.next
    val (next20pt, nextIter2) = iter2.next
    if (!iter1.hasNext && !iter2.hasNext) {
      (None, this)
    } else if (useFirst.get && iter1.hasNext) {
      (Some(next1Opt.get, next20pt.get), CombinedState(nextIter1, iter2, next_alt_iter))
    } else if (!useFirst.get && iter2.hasNext) {
      (Some(next1Opt.get, next20pt.get), CombinedState(iter1, nextIter2, next_alt_iter))
    } else if (iter1.hasNext) {
      (Some(next1Opt.get, next20pt.get), CombinedState(nextIter1, iter2, next_alt_iter))
    } else {
      (Some(next1Opt.get, next20pt.get), CombinedState(iter1, nextIter2, next_alt_iter))
    }

  }
}

object CombinedIterator {
  def apply(iter1: IterState[Int, Unit], iter2: IterState[Int, Unit]): CombinedState =
    CombinedState(iter1, iter2, AltIterator())
}