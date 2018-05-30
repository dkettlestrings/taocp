package mix

trait FieldSpecification {

  val sign: Option[Sign]
  val bytes: List[Byte]
}

object FieldSpecification {

  def apply(left: Int, right: Int)(word: Word): FieldSpecification = {

    // validation
    if(left < 0) {
      throw new IllegalArgumentException()
    } else if(left > right) {
      throw new IllegalArgumentException()
    } else if(right > 5) {
      throw new IllegalArgumentException()
    }

    def inRange(i: Int): Boolean = left <= i && i <= right

    def getIfInRange(i: Int): Option[Byte] = {

      if(i < 1 || i > 5) {
        throw new IllegalArgumentException()
      }

      if(!inRange(i)) None
      else i match {
        case 1 => Some(word._1)
        case 2 => Some(word._2)
        case 3 => Some(word._3)
        case 4 => Some(word._4)
        case 5 => Some(word._5)
      }
    }

    new FieldSpecification {

      override val sign = if(inRange(0)) Some(word.sign) else None

      override val bytes: List[Byte] = Range(1, 6).toList.flatMap(getIfInRange(_))
    }
  }
}
