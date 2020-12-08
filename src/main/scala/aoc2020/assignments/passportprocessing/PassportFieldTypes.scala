package aoc2020.assignments.passportprocessing

sealed case class PassportFieldType(name: String, validator: (String) => Boolean) {
  def validate(value: String): Boolean = validator(value)
}

object PassportFieldTypes {
  protected def isIntegerInRange(value: String, range: Range): Boolean =
    value.toIntOption.map(range.contains(_)).getOrElse(false)


  val BirthYear = PassportFieldType("byr", (value) => {
    value.length == 4 && isIntegerInRange(value, Range(1920, 2002).inclusive)
  })

  val IssueYear = PassportFieldType("iyr", (value) => {
    value.length == 4 && isIntegerInRange(value, Range(2010, 2020).inclusive)
  })

  val ExpirationYear = PassportFieldType("eyr", (value) => {
    value.length == 4 && isIntegerInRange(value, Range(2020, 2030).inclusive)
  })

  val Height = PassportFieldType("hgt", (value) => {
    val heightRegex = """(.+)(cm|in)""".r
    value match {
      case heightRegex(quantity, unit) => {
        if (unit == "cm") {
          isIntegerInRange(quantity, Range(150, 193).inclusive)
        } else if (unit == "in") {
          isIntegerInRange(quantity, Range(59, 76).inclusive)
        } else {
          false
        }
      }
      case _ => false
    }
  })

  val HairColor = PassportFieldType("hcl", (value) => {
    val hairColorRegex = """#([a-f0-9]{6})""".r
    value match {
      case hairColorRegex(_) => true
      case default => false
    }
  })

  val EyeColor = PassportFieldType("ecl", (value) => {
    Seq("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value)
  })

  val PassportId = PassportFieldType("pid", (value) => {
    val passportRegex = """([0-9]{9})""".r
    value match {
      case passportRegex(_) => true
      case default => false
    }
  })

  val CountryId = PassportFieldType("cid", (_) => {
    true
  })

  val AllValues = Seq(BirthYear, IssueYear, ExpirationYear, Height, HairColor, EyeColor, PassportId, CountryId)
  def passportFieldTypeForName(name: String): Option[PassportFieldType] =
    AllValues.find(_.name == name)
}
