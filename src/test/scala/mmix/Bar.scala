package mmix

import org.scalatest.{FlatSpec, Matchers}

class Bar extends FlatSpec with Matchers {

  "test" should "pass" in {

    1 should be (1)
  }

}
