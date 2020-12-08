package aoc2020.assignments.passportprocessing

import aoc2020.assignments.BaseAssignment
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PassportProcessingAssignmentTest extends AnyFlatSpec with should.Matchers  {

  val inputPath = "assign_4.txt"
  val testInputPath = "assign_4_test.txt"

  def expectedOutputTestPart1: Int = 2
  def expectedOutputPart1: Int = ???

  def expectedOutputTestPart2: Int = ???
  def expectedOutputPart2: Int = ???

  val assignmentName = "PassportProcessing"
  val assignment: PassportProcessingAssignment.type = PassportProcessingAssignment

  assignmentName should s"return ${expectedOutputPart1} for the test input" in {
    assignment.executePart1(testInputPath) should be(expectedOutputTestPart1)
  }

  assignmentName should s"return ${expectedOutputPart1}" in {
    assignment.executePart1(inputPath) should be(expectedOutputPart1)
  }

  assignmentName should s"return ${expectedOutputPart2} for the test input" in {
    assignment.executePart2(testInputPath) should be(expectedOutputTestPart2)
  }

  assignmentName should s"return ${expectedOutputPart2}" in {
    assignment.executePart2(inputPath) should be(expectedOutputPart2)
  }
}
