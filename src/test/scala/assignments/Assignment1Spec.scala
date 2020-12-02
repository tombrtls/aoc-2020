package assignments

import org.scalatest._;
import flatspec._;
import matchers._;

class Assignment1Spec extends AnyFlatSpec with should.Matchers {
  "Assignment 1" should "return true" in {
    Assignment1.isNewFile should be(true)
  }
}
