package com.example.range

case class InfRange(lower: Option[Int], upper: Option[Int]) {
  def apply(value: Int): Boolean = {
    val lowerBoundCheck = lower.forall(value >= _)
    val upperBoundCheck = upper.forall(value < _)
    lowerBoundCheck && upperBoundCheck
  }

  def iterator: Iterator[Int] = new InfRangeIterator(this)
}

object InfRange {
  // Здесь можно поместить дополнительные методы или объекты, если нужно
}