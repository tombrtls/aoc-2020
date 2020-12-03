package aoc2020.assignments

abstract class BaseAssignment[Input, Output] {
  def prepareInput(filePath: String): Input

  def processPart1(input: Input): Output

  def processPart2(input: Input): Output

  def executePart1(filePath: String): Output = {
    val input = prepareInput(filePath)
    processPart1(input)
  }

  def executePart2(filePath: String): Output = {
    val input = prepareInput(filePath)
    processPart2(input)
  }
}
