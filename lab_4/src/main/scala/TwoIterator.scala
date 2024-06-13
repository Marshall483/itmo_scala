object TwoIterator extends Iterator[(Int, Int)] {
  private var outer = 0
  private var inner = 0

  def hasNext: Boolean = true // Итератор бесконечный, всегда есть следующий элемент

  def next(): (Int, Int) = {
    val result = (outer, inner)
    if (inner > 0) {
      inner -= 1
    } else {
      outer += 1
      inner = outer
    }
    result
  }
}