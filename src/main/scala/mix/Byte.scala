package mix

trait Byte {

  val value: Int

  override def equals(obj: Any): Boolean = obj.asInstanceOf[Byte].value == value

}

object Byte {

  def apply(contents: Int): Byte = {

    if(contents < 0 || contents > 63) {
      throw new IllegalArgumentException()
    } else new Byte {

      override val value: Int = contents
    }
  }

  val empty: Byte = Byte(0)
}
