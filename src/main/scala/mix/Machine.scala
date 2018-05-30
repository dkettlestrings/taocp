package mix

case class Machine(
  A: FiveByteRegister,
  X: FiveByteRegister,
  I1: TwoByteRegister,
  I2: TwoByteRegister,
  I3: TwoByteRegister,
  I4: TwoByteRegister,
  I5: TwoByteRegister,
  I6: TwoByteRegister,
  overflowToggle: Boolean,
  memory: Vector[Byte],
  comparisonIndicator: ComparisonIndicator
) {
  def execute(instruction: Word): Machine = ???
}

object Machine {

  def empty(): Machine = Machine (

    A = FiveByteRegister.empty,

    X = FiveByteRegister.empty,

    I1 = TwoByteRegister.empty,

    I2 = TwoByteRegister.empty,

    I3 = TwoByteRegister.empty,

    I4 = TwoByteRegister.empty,

    I5 = TwoByteRegister.empty,

    I6 = TwoByteRegister.empty,

    overflowToggle = false,

    memory = Vector.fill(4000)(Byte.empty),

    comparisonIndicator = EQUAL
  )
}
