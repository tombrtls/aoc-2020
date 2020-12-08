package aoc2020.assignments.passwordphilosophy

import org.scalatest.funspec._
import org.scalatest.matchers._


class PasswordAssignmentSpec extends AnyFunSpec with should.Matchers {
  var testInput = "assign_2_test.txt"
  var actualInput = "assign_2.txt"

  describe("Password") {
    describe("isValid") {
      it("returns false") {
        Password(Range(2, 4), 'a', "a").isValid should be(false)
        Password(Range(2, 4), 'a', "aaaaa").isValid should be(false)
      }

      it("returns true") {
        Password(Range(1, 3), 'a', "a").isValid should be(true)
        Password(Range(1, 3), 'a', "aa").isValid should be(true)
        Password(Range(1, 3), 'a', "aaa").isValid should be(true)
      }
    }

    describe("isValidPart2") {
      it("returns false") {
        Password(Range(1, 3), 'a', "aaa").isValidPart2 should be(false)
        Password(Range(1, 3), 'a', "bbb").isValidPart2 should be(false)
        Password(Range(1, 3), 'a', "aba").isValidPart2 should be(false)
      }

      it("returns true") {
        Password(Range(1, 3), 'a', "aab").isValidPart2 should be(true)
        Password(Range(1, 3), 'a', "baa").isValidPart2 should be(true)
        Password(Range(1, 3), 'a', "a").isValidPart2 should be(true)
      }
    }

  }

  describe("PasswordAssignment") {
    describe("part 1") {
      describe("test input") {
        it("returns 2") {
          PasswordAssignment.executePart1(testInput) should be(2)
        }
      }

      describe("actual input") {
        it("returns 660") {
          PasswordAssignment.executePart1(actualInput) should be(660)
        }
      }
    }
    describe("part 2") {
      describe("test input") {
        it("returns 1") {
          PasswordAssignment.executePart2(testInput) should be(1)
        }
      }

      describe("actual input") {
        it("returns 660") {
          PasswordAssignment.executePart2(actualInput) should be(530)
        }
      }
    }
  }
}
