package aoc2020.assignments.passportprocessing

case class Passport(fields: List[PassportField]) {
  val requiredFields: Seq[PassportFieldType] = PassportFieldTypes.AllValues.filter(_ != PassportFieldTypes.CountryId)
  val fieldTypes: Seq[PassportFieldType] = fields.map(_.fieldType)
  def isValid: Boolean =
    fields.size >= requiredFields.size &&
    requiredFields.forall(fieldTypes.contains(_))

  def allFieldsAreValid: Boolean = fields.forall(_.isValid)

}
