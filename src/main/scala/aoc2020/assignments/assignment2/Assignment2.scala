package aoc2020.assignments.assignment2

import aoc2020.assignments.BaseAssignment

object Assignment2 extends BaseAssignment [List[Password], Int]{
  override def prepareLinesForInput(lines: List[String]): List[Password] = {
    val passwordRegex = """(\d+)-(\d+) (\w): (\w*)""".r
    lines.map {
      case passwordRegex(min, max, char, password) => Password(Range(min.toInt, max.toInt), char.charAt(0), password)
    }
  }

  override def processPart1(input: List[Password]) = {
    input.count(_.isValid)
  }

  override def processPart2(input: List[Password]) =
    input.count(_.isValidPart2)
}
