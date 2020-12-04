package aoc2020.assignments

import aoc2020.Helper

import scala.util.Try

case class Password(range: Range, char: Char, password: String) {
  def isValid: Boolean = {
    range.inclusive.contains(
      password.count(_ == char)
    )
  }

  def firstChar: Option[Char] = Try(password.charAt(range.start - 1)).toOption
  def secondChar: Option[Char] = Try(password.charAt(range.end - 1)).toOption

  def isValidPart2: Boolean = {
    (firstChar.contains(char) || secondChar.contains(char)) && (firstChar != secondChar)
  }
}

object Assignment2 extends BaseAssignment [List[Password], Int]{
  override def prepareInput(filePath: String) = {
    val passwordRegex = """(\d+)-(\d+) (\w): (\w*)""".r
    Helper.readLinesFromFile(filePath)
      .map {
        case passwordRegex(min, max, char, password) => Password(Range(min.toInt, max.toInt), char.charAt(0), password)
      }
      .toList
  }

  override def processPart1(input: List[Password]) = {
    input.count(_.isValid)
  }

  override def processPart2(input: List[Password]) =
    input.count(_.isValidPart2)
}
