package aoc2020.assignments.passportprocessing

import aoc2020.assignments.BaseAssignment

object PassportProcessingAssignment extends  BaseAssignment[List[Passport], Int] {
  override def prepareLinesForInput(lines: List[String]) = {
    val passportRegex = """(\w+):(\w+)""".r
    lines.filter(_.isBlank)
      .map((line) => {
            val fields =
              line
                .split(' ')
                .map {
                  case passportRegex(typeString, value) => PassportField(typeString, value)
                }
                  .toList

        Passport(fields)
      })
  }

  override def processPart1(input: Passport): Int= ???

  override def processPart2(input: Passport): Int = ???
}
