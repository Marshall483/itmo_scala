package com.example.range

class InfRangeIterator(range: InfRange) extends Iterator[Int] {
  private var current = range.lower.getOrElse(range.upper.getOrElse(0))
  private var step = -1

  override def hasNext: Boolean = range match {
    case InfRange(Some(lower), Some(upper)) => current < upper
    case InfRange(Some(lower), None) => true
    case InfRange(None, Some(upper)) => current > -upper
    case InfRange(None, None) => true
  }

  override def next(): Int = range match {
    case InfRange(Some(lower), Some(upper)) =>
      if (current < upper) {
        val result = current
        current += 1
        result
      } else {
        throw new NoSuchElementException("End of range")
      }

    case InfRange(Some(lower), None) =>
      val result = current
      current += 1
      result

    case InfRange(None, Some(upper)) =>
      val result = current - 1
      current -= 1
      result

    case InfRange(None, None) =>
      val result = current
      if (step > 0) {
        current = -current
      } else {
        current = -current + 1
      }
      step *= -1
      result
  }
}