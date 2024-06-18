object test extends App{
  val initial1 = BigInt(0)
  val initial2 = BigInt(1)
  val coeff1 = BigInt(0)
  val coeff2 = BigInt(0)

  val fibState = GeneralFibonacciIterator(initial1, initial2, coeff1, coeff2)

  // Печатаем первые 10 чисел обобщенной последовательности Фибоначчи
  var currentState = fibState
  for (_ <- 1 to 10) {
    val (value, nextState) = currentState.next
    println(value.get)
    currentState = nextState
  }
}
