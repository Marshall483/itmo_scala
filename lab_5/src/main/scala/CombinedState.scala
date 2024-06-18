case class CombinedState(iter1: EvenState, iter2: FibonacciState, aux_iter: AuxState) extends IterState[(Int, Int), Unit] {

  override def hasNext: Boolean = iter1.hasNext

  override def next: (Option[(Int, Int)], CombinedState) = {
    val (elem1, nextIter1) = iter1.next
    val (elem2, nextIter2) = iter2.next

    if (aux_iter.hasNext) {
      val (elem_aux, nextAuxIter) = aux_iter.next
      (Some(elem1.get, elem2.get), CombinedState(iter1, nextIter2, nextAuxIter))

    } else {
      (Some(elem1.get, elem2.get), CombinedState(nextIter1, FibonacciIterator(), AuxIterator(elem1.get / 2)))
    }

  }
}

object CombinedIterator {
  def apply(iter1: EvenState, iter2: FibonacciState): CombinedState =
    CombinedState(iter1, iter2, AuxIterator())
}