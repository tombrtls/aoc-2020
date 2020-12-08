package aoc2020.assignments.passportprocessing

import aoc2020.assignments.BaseAssignment
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PassportProcessingAssignmentTest extends AnyFlatSpec with should.Matchers  {

  val inputPath = "assign_4.txt"
  val testInputPath = "assign_4_test.txt"
  val part2TestInputPath = "assign_4_part_2_test.txt"

  def expectedOutputTestPart1: Int = 2
  def expectedOutputPart1: Int = 237

  def expectedOutputTestPart2: Int = 4
  def expectedOutputPart2: Int = 172

  val assignmentName = "PassportProcessing"
  val assignment: PassportProcessingAssignment.type = PassportProcessingAssignment

  assignmentName should s"part 1 returns ${expectedOutputPart1} for the test input" in {
    assignment.executePart1(testInputPath) should be(expectedOutputTestPart1)
  }

  assignmentName should s"part 1 returns ${expectedOutputPart1}" in {
    assignment.executePart1(inputPath) should be(expectedOutputPart1)
  }

  assignmentName should s"part 2 returns ${expectedOutputPart2} for the test input" in {
    assignment.executePart2(part2TestInputPath) should be(expectedOutputTestPart2)
  }

  assignmentName should s"part 2 returns ${expectedOutputPart2}" in {
    assignment.executePart2(inputPath) should be(expectedOutputPart2)
  }
}
