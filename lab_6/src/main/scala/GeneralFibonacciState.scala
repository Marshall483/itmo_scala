// Класс для генерации обобщенной последовательности Фибоначчи
case class GeneralFibonacciState(
                                  current: BigInt,
                                  nextValue: BigInt,
                                  coeff1: BigInt,
                                  coeff2: BigInt
                                ) extends IterState[BigInt, GeneralFibonacciState] {

  // Определяем метод hasNext. Поскольку последовательность Фибоначчи бесконечна, всегда возвращаем true
  override def hasNext: Boolean = true

  // Метод next генерирует следующий элемент последовательности и новый экземпляр состояния
  override def next: (Option[BigInt], GeneralFibonacciState) = {
    val newNextValue = coeff1 * current + coeff2 * nextValue
    (Some(current), GeneralFibonacciState(nextValue, newNextValue, coeff1, coeff2))
  }
}

object GeneralFibonacciIterator {
  def apply(start1: BigInt, start2: BigInt, coeff1: BigInt, coeff2: BigInt): GeneralFibonacciState =
    GeneralFibonacciState(start1, start2, coeff1, coeff2)
}