package aoc2020.assignments.passportprocessing

case class PassportField(fieldType: PassportFieldType, value: String) {
  def isValid: Boolean = fieldType.validate(value)
}

object PassportField {
  def apply(fieldType: PassportFieldType, value: String): PassportField = new PassportField(fieldType, value)
  def apply(typeString: String, value: String): Option[PassportField] = {
    PassportFieldTypes.passportFieldTypeForName(typeString)
      .map(PassportField(_, value))
  }
}

