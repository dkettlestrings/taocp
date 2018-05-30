package mix

import org.scalatest.{FlatSpec, Matchers}

class TestByte extends FlatSpec with Matchers {

  "Byte" should "accept values from 0 to 63" in {

    Range(0, 64).map(n => Byte(n)) should be
  }

  "Byte" should "blow up on -1 and 64" in {

    intercept[IllegalArgumentException]{Byte(-1)}

    intercept[IllegalArgumentException]{Byte(64)}
  }

  "An empty Byte" should "have value 0" in {

    Byte.empty.value shouldBe 0
  }
}
