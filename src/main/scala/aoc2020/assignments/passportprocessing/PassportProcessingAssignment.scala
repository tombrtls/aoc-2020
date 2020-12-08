package aoc2020.assignments.passportprocessing

import aoc2020.assignments.BaseAssignment

import scala.collection.mutable

object PassportProcessingAssignment extends  BaseAssignment[List[Passport], Int] {
  override def prepareLinesForInput(lines: List[String]) = {
    val passportRegex = """(.+):(.+)""".r
    val groupedLines = mutable.ListBuffer.empty[String]
    var index = 0
    for (line <- lines) {
      if (line.isBlank) {
        index = groupedLines.size
      } else {
        val currentString = groupedLines.lift(index).getOrElse("")
        if (index < groupedLines.size) groupedLines.remove(index)
        groupedLines.addOne(currentString.appended(' ').appendedAll(line))
      }
    }

    groupedLines.toList
      .map(line => {
            val fields = line
                .split(' ')
                .filter(!_.isBlank)
                .map(_.trim)
                .flatMap {
                  case passportRegex(typeString, value) => PassportField(typeString, value)
                }
                .toList

        Passport(fields)
      })
  }

  override def processPart1(input: List[Passport]): Int = {
    input.count(_.isValid)
  }

  override def processPart2(input: List[Passport]): Int = {
    input.count(passport => passport.isValid && passport.allFieldsAreValid)
  }
}
