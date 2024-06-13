object ThreeIterator extends Iterator[(Int, Int)] {
  private var sum = 0
  private var x = 0

  def hasNext: Boolean = true // Итератор бесконечный, всегда есть следующий элемент

  def next(): (Int, Int) = {
    val result = (sum - x, x)
    if (x < sum) {
      x += 1
    } else {
      sum += 1
      x = 0
    }
    result
  }
}