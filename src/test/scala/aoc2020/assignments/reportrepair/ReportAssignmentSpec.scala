package aoc2020.assignments.reportrepair

import org.scalatest.matchers._
import org.scalatest.funspec.AnyFunSpec

class ReportAssignmentSpec extends AnyFunSpec with should.Matchers {

  val testInput = "assign_1_test.txt"
  val actualInput = "assign_1.txt"

  describe("ReportAssignment") {
    describe("part 1") {
      describe("with test input") {
        it("should return 514579") {
          ReportAssignment.executePart1(testInput) should be(514579)
        }
      }
      describe("with input") {
        it("should return 514579") {
          ReportAssignment.executePart1(actualInput) should be(876459)
        }
      }
    }


    describe("part 2") {
      describe("with test input") {
        it("should return 514579") {
          ReportAssignment.executePart2(testInput) should be(241861950)
        }
      }
      describe("with input") {
        it("should return 514579") {
          ReportAssignment.executePart2(actualInput) should be(116168640)
        }
      }
    }
  }
}
