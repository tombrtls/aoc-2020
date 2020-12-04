package aoc2020.assignments.assignment2

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
