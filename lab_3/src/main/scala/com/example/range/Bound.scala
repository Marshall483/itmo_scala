package com.example.range

sealed trait Bound

case object Infinity extends Bound {
  def unary_- : Bound = MinusInfinity
}

private case object MinusInfinity extends Bound

private case class BoundVal(value: Int) extends Bound

object Bound {
  implicit def boundVal(value: Int): Bound = BoundVal(value)
}