package aoc2020.assignments.passwordphilosophy

import org.scalatest.flatspec._
import org.scalatest.matchers._

class PasswordAssignmentSpec extends AnyFlatSpec with should.Matchers {
  var testInput = "assign_2_test.txt"
  var actualInput = "assign_2.txt"

  "Password.isValid" should "return false" in {
    Password(Range(2, 4), 'a', "a").isValid should be(false)
    Password(Range(2, 4), 'a', "aaaaa").isValid should be (false)
  }

  "Password.isValid" should "return true" in {
    Password(Range(1, 3), 'a', "a").isValid should be(true)
    Password(Range(1, 3), 'a', "aa").isValid should be(true)
    Password(Range(1, 3), 'a', "aaa").isValid should be (true)
  }

  "Password.isValidPart2" should "return true" in {
    Password(Range(1, 3), 'a', "aab").isValidPart2 should be(true)
    Password(Range(1, 3), 'a', "baa").isValidPart2 should be(true)
    Password(Range(1, 3), 'a', "a").isValidPart2 should be(true)
  }

  "Password.isValidPart2" should "return false" in {
    Password(Range(1, 3), 'a', "aaa").isValidPart2 should be(false)
    Password(Range(1, 3), 'a', "bbb").isValidPart2 should be(false)
    Password(Range(1, 3), 'a', "aba").isValidPart2 should be(false)
  }

  "part 1" should "return 2" in {
    PasswordAssignment.executePart1(testInput) should be(2)
  }
  "part 1" should "return 660" in {
    PasswordAssignment.executePart1(actualInput) should be(660)
  }

  "part 2" should "return 1" in {
    PasswordAssignment.executePart2(testInput) should be(1)
  }

  "part 2" should "return 530" in {
    PasswordAssignment.executePart2(actualInput) should be(530)
  }
}
