package aoc2020.assignments.passportprocessing

object PassportFieldTypes extends Enumeration {
  type PasswordFieldType = Val

  val BirthYear = Value("byr")
  val IssueYear = Value("iyr")
  val ExpirationYear = Value("eyr")
  val Height = Value("hgt")
  val HairColor = Value("hcl")
  val EyeColor = Value("ecl")
  val PassportId = Value("byr")
  val CountryId = Value("cid")
}
