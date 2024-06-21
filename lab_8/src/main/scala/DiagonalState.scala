case class DiagonalState(iters: List[IterState[Any, Unit]], aux_iter: IterState[Int, Unit]) {
   def hasNext: Boolean = iters.nonEmpty

   def next: (Option[Any], DiagonalState, Int) = {
    val (ind, next_aux_iter) = aux_iter.next
    val current_ind = ind.get

    val (elem, next_current_iter) = iters(current_ind).next
    var new_iters = iters
    new_iters = iters.patch(current_ind, Seq(next_current_iter), 1)

    if (next_aux_iter.hasNext && current_ind + 1 < new_iters.length) {
      if (next_current_iter.hasNext) {
        (elem, DiagonalState(new_iters, next_aux_iter), 0)
      } else {
        new_iters = new_iters.patch(current_ind, Nil, 1)
        (elem, DiagonalState(new_iters, AuxIterator(new_iters.length, current_ind)), 1)
      }
    } else {
      if (next_current_iter.hasNext) {
        (elem, DiagonalState(new_iters, AuxIterator(new_iters.length + 1)), 1)
      } else {
        new_iters = new_iters.patch(current_ind, Nil, 1)
        (elem, DiagonalState(new_iters, AuxIterator(new_iters.length + 1)), 2)
      }
    }
  }

  def add_iter(new_iter: IterState[Any, Unit]): (DiagonalState) = {
    val new_iters = iters :+ new_iter
    (DiagonalState(new_iters, aux_iter))
  }
}

object DiagonalIterator {
  def apply(iterators: IterState[Any, Unit]*): DiagonalState = DiagonalState(iterators.toList, AuxIterator())
}