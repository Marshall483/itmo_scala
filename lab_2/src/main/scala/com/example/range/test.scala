package com.example.range

import com.example.range.Bound._
import com.example.range.Implicits._

object test extends App {
  val range1 = 5 :-> 10 // InfRange(Some(5), Some(10))
  val range2 = 10 :-> 5 // InfRange(Some(0), Some(0))
  val range3 = 10 :-> Infinity // InfRange(Some(10), None)
  val range4 = -Infinity :-> 7 // InfRange(None, Some(7))
  val range5 = -Infinity :-> Infinity // InfRange(None, None)

  // Пример проверки диапазона
  println(range1(7)) // true
  println(range1(10)) // false
  println(range3(100)) // true
  println(range2(0))
  println(range4(-10000))
  println(range5(100000))
}
