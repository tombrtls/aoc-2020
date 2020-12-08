package aoc2020.assignments.passportprocessing

import aoc2020.assignments.passportprocessing.PassportFieldTypes.PasswordFieldType

case class PassportField(fieldType: PassportFieldTypes.Value, value: String)

object PassportField {
  def apply(fieldType: PasswordFieldType, value: String): PassportField = new PassportField(fieldType, value)
  def apply(typeString: String, value: String): PassportField = {
    val fieldType = PassportFieldTypes.withName(typeString)
    new PassportField(fieldType, value)
  }
}

