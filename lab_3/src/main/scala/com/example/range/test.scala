package com.example.range

import com.example.range.Bound._
import com.example.range.Implicits._

object test extends App {
  val range1 = 5 :-> 10 // InfRange(Some(5), Some(10))
  val range2 = 10 :-> 5 // InfRange(Some(0), Some(0))
  val range3 = 10 :-> Infinity // InfRange(Some(10), None)
  val range4 = -Infinity :-> 7 // InfRange(None, Some(7))
  val range5 = -Infinity :-> Infinity // InfRange(None, None)

  // Пример использования итератора
  println(range1.iterator.take(10).toList) // List(5, 6, 7, 8, 9)
  println(range2.iterator.take(10).toList) // List()
  println(range3.iterator.take(10).toList) // List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
  println(range4.iterator.take(10).toList) // List(6, 5, 4, 3, 2, 1, 0, -1, -2, -3)
  println(range5.iterator.take(10).toList) // List(0, 1, -1, 2, -2, 3, -3, 4, -4, 5)
}