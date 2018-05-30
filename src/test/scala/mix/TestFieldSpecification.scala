package mix

import org.scalatest.{FlatSpec, Matchers}

class TestFieldSpecification extends FlatSpec with Matchers {

  val word = Word(Positive, Byte(1), Byte(2), Byte(3), Byte(4), Byte(5))

  "FieldSpecification" should "blow up if left is < 0" in {

    intercept[IllegalArgumentException]{FieldSpecification(-1, 2)(word)}

  }

  "FieldSpecification" should "blow up if left is > right" in {

    intercept[IllegalArgumentException]{FieldSpecification(3, 2)(word)}

  }

  "FieldSpecification" should "blow up if right is > 5" in {

    intercept[IllegalArgumentException]{FieldSpecification(0, 6)(word)}

  }

  "FieldSpecification" should "work" in {

    FieldSpecification(0, 0)(word) shouldBe FieldSpecification(Some(Positive), List.empty)
    FieldSpecification(0, 1)(word) shouldBe FieldSpecification(Some(Positive), List(Byte(1)))
    FieldSpecification(0, 2)(word) shouldBe FieldSpecification(Some(Positive), List(Byte(1), Byte(2)))
    FieldSpecification(0, 3)(word) shouldBe FieldSpecification(Some(Positive), List(Byte(1), Byte(2), Byte(3)))
    FieldSpecification(0, 4)(word) shouldBe FieldSpecification(Some(Positive), List(Byte(1), Byte(2), Byte(3), Byte(4)))
    FieldSpecification(0, 5)(word) shouldBe FieldSpecification(Some(Positive), List(Byte(1), Byte(2), Byte(3), Byte(4), Byte(5)))

    FieldSpecification(1, 1)(word) shouldBe FieldSpecification(None, List(Byte(1)))
    FieldSpecification(1, 2)(word) shouldBe FieldSpecification(None, List(Byte(1), Byte(2)))
    FieldSpecification(1, 3)(word) shouldBe FieldSpecification(None, List(Byte(1), Byte(2), Byte(3)))
    FieldSpecification(1, 4)(word) shouldBe FieldSpecification(None, List(Byte(1), Byte(2), Byte(3), Byte(4)))
    FieldSpecification(1, 5)(word) shouldBe FieldSpecification(None, List(Byte(1), Byte(2), Byte(3), Byte(4), Byte(5)))

    FieldSpecification(2, 2)(word) shouldBe FieldSpecification(None, List(Byte(2)))
    FieldSpecification(2, 3)(word) shouldBe FieldSpecification(None, List(Byte(2), Byte(3)))
    FieldSpecification(2, 4)(word) shouldBe FieldSpecification(None, List(Byte(2), Byte(3), Byte(4)))
    FieldSpecification(2, 5)(word) shouldBe FieldSpecification(None, List(Byte(2), Byte(3), Byte(4), Byte(5)))

    FieldSpecification(3, 3)(word) shouldBe FieldSpecification(None, List(Byte(3)))
    FieldSpecification(3, 4)(word) shouldBe FieldSpecification(None, List(Byte(3), Byte(4)))
    FieldSpecification(3, 5)(word) shouldBe FieldSpecification(None, List(Byte(3), Byte(4), Byte(5)))

    FieldSpecification(4, 4)(word) shouldBe FieldSpecification(None, List(Byte(4)))
    FieldSpecification(4, 5)(word) shouldBe FieldSpecification(None, List(Byte(4), Byte(5)))

    FieldSpecification(5, 5)(word) shouldBe FieldSpecification(None, List(Byte(5)))

  }
}
