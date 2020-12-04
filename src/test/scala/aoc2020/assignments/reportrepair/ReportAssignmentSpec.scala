package aoc2020.assignments.reportrepair

import org.scalatest.flatspec._
import org.scalatest.matchers._

class ReportAssignmentSpec extends AnyFlatSpec with should.Matchers {

  val testInput = "assign_1_test.txt"
  val actualInput = "assign_1.txt"
  "part 1" should "return 514579" in {
    ReportAssignment.executePart1(testInput) should be(514579)
  }

  "part 1" should "return 876459" in {
    ReportAssignment.executePart1(actualInput) should be(876459)
  }

  "part 2" should "return 241861950" in {
    ReportAssignment.executePart2(testInput) should be(241861950)
  }

  "part 2" should "return 116168640" in {
    ReportAssignment.executePart2(actualInput) should be(116168640)
  }
}
