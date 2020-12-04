package aoc2020.assignments

import aoc2020.Helper

abstract class BaseAssignment[Input, Output] extends App {
  def prepareInput(filePath: String): Input = {
    val lines = Helper
      .readLinesFromFile(filePath)
      .toList

    prepareLinesForInput(lines)
  }

  def prepareLinesForInput(lines: List[String]): Input

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
