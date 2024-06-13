package com.example.range

object Implicits {
  implicit class BoundOps(val start: Bound) extends AnyVal {
    def :->(end: Bound): InfRange = (start, end) match {
      case (MinusInfinity, Infinity) => InfRange(None, None)
      case (MinusInfinity, BoundVal(e)) => InfRange(None, Some(e))
      case (BoundVal(s), Infinity) => InfRange(Some(s), None)
      case (BoundVal(s), BoundVal(e)) if s <= e => InfRange(Some(s), Some(e))
      case _ => InfRange(Some(0), Some(0)) // Пустой диапазон
    }

    def :->(end: Int): InfRange = start match {
      case MinusInfinity => InfRange(None, Some(end))
      case BoundVal(s) if s <= end => InfRange(Some(s), Some(end))
      case _ => InfRange(Some(0), Some(0)) // Пустой диапазон
    }
  }

  implicit class IntOps(val start: Int) extends AnyVal {
    def :->(end: Bound): InfRange = end match {
      case Infinity => InfRange(Some(start), None)
      case BoundVal(e) if start <= e => InfRange(Some(start), Some(e))
      case _ => InfRange(Some(0), Some(0)) // Пустой диапазон
    }

    def :->(end: Int): InfRange =
      if (start <= end) InfRange(Some(start), Some(end))
      else InfRange(Some(0), Some(0)) // Пустой диапазон
  }
}