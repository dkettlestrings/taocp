package mix

trait Register

case class FiveByteRegister (
  sign: Sign,
  _1: Byte,
  _2: Byte,
  _3: Byte,
  _4: Byte,
  _5: Byte
) extends Register

case class TwoByteRegister (
  sign: Sign,
  _1: Byte,
  _2: Byte
) extends Register

case class TwoBytePositiveRegister (
  sign: Sign = Positive,
  _1: Byte,
  _2: Byte
) extends Register

object FiveByteRegister {

  val empty: FiveByteRegister =
    FiveByteRegister(Negative, Byte.empty, Byte.empty, Byte.empty, Byte.empty, Byte.empty)
}

object TwoByteRegister {

  val empty: TwoByteRegister = TwoByteRegister(Negative, Byte.empty, Byte.empty)
}

object TwoBytePositiveRegister {

  val empty: TwoBytePositiveRegister = TwoBytePositiveRegister(Positive, Byte.empty, Byte.empty)
}
