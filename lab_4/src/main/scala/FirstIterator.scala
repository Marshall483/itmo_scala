object FirstIterator extends Iterator[(Int, Int)] {
  private var outer = 0
  private var inner = 0

  def hasNext: Boolean = true // Так как итератор бесконечный, всегда есть следующий элемент

  def next(): (Int, Int) = {
    val result = (outer, inner)
    if (inner < outer) {
      inner += 1
    } else {
      outer += 1
      inner = 0
    }
    result
  }
}