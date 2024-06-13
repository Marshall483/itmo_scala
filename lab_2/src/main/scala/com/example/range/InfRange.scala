package com.example.range

case class InfRange(lower: Option[Int], upper: Option[Int]) {
  def apply(value: Int): Boolean = {
    val lowerBoundCheck = lower.forall(value >= _)
    val upperBoundCheck = upper.forall(value < _)
    lowerBoundCheck && upperBoundCheck
  }
}

object InfRange {
  // Здесь можно поместить дополнительные методы или объекты, если нужно
}