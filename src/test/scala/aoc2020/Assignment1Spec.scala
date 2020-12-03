package aoc2020.assignments

import org.scalatest._;
import flatspec._;
import matchers._;

class Assignment1Spec extends AnyFlatSpec with should.Matchers {

  val testInput = "assign_1_test.txt"
  val actualInput = "assign_1.txt"
  "part 1" should "return 514579" in {
    Assignment1.executePart1(testInput) should be(514579)
  }

  "part 1" should "return 876459" in {
    Assignment1.executePart1(actualInput) should be(876459)
  }

  "part 2" should "return 241861950" in {
    Assignment1.executePart2(testInput) should be(241861950)
  }

  "part 2" should "return 116168640" in {
    Assignment1.executePart2(actualInput) should be(116168640)
  }
}
