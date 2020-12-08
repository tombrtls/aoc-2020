package aoc2020.assignments.passportprocessing

import aoc2020.assignments.passportprocessing.PassportFieldTypes.{BirthYear, CountryId, ExpirationYear, EyeColor, HairColor, Height, IssueYear, PassportId}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should


class PassportFieldTypesTest extends AnyFunSpec with should.Matchers {
  describe("BirthYear") {
    val fieldType = BirthYear
    describe("name") {
      it("should be byr") {
        fieldType.name should be ("byr")
      }
    }

    describe("validator") {
      it("should be false if below 1920") {
        fieldType.validate("1919") should be (false)
      }

      it("should be false if above 2002") {
        fieldType.validate("2003") should be (false)
      }

      it("should be false if not an integer") {
        fieldType.validate("1asd") should be (false)
      }

      it("should be false if integer too short") {
        fieldType.validator("123") should be (false)
      }

      it("should be false if integer too long") {
        fieldType.validator("12345") should be (false)
      }

      it("should be true if 1920") {
        fieldType.validator("1920") should be (true)
      }

      it("should be true if 2002") {
        fieldType.validator("2002") should be (true)
      }
    }
  }

  describe("Issue Year") {
    val fieldType = IssueYear
    describe("name") {
      it("should be iyr") {
        fieldType.name should be ("iyr")
      }
    }

    describe("validator") {
      it("should be false if below 2010") {
        fieldType.validate("2009") should be (false)
      }

      it("should be false if above 2020") {
        fieldType.validate("2021") should be (false)
      }

      it("should be false if not an integer") {
        fieldType.validate("1asd") should be (false)
      }

      it("should be false if integer too short") {
        fieldType.validator("123") should be (false)
      }

      it("should be false if integer too long") {
        fieldType.validator("12345") should be (false)
      }

      it("should be true if 2010") {
        fieldType.validator("2010") should be (true)
      }

      it("should be true if 2020") {
        fieldType.validator("2020") should be (true)
      }
    }
  }

  describe("Expiration Year") {
    val fieldType = ExpirationYear
    describe("name") {
      it("should be eyr") {
        fieldType.name should be ("eyr")
      }
    }

    describe("validator") {
      it("should be false if below 2020") {
        fieldType.validate("2019") should be (false)
      }

      it("should be false if above 2030") {
        fieldType.validate("2031") should be (false)
      }

      it("should be false if not an integer") {
        fieldType.validate("1asd") should be (false)
      }

      it("should be false if integer too short") {
        fieldType.validator("123") should be (false)
      }

      it("should be false if integer too long") {
        fieldType.validator("12345") should be (false)
      }

      it("should be true if 2020") {
        fieldType.validator("2020") should be (true)
      }

      it("should be true if 2030") {
        fieldType.validator("2030") should be (true)
      }
    }
  }

  describe("Height") {
    val fieldType = Height
    describe("name") {
      it("should be hgt") {
        fieldType.name should be ("hgt")
      }
    }

    describe("validator") {
      describe("cm") {
        it("should be false if below 150") {
          fieldType.validator("149cm") should be (false)
        }

        it("should be false if below 193") {
          fieldType.validator("194cm") should be (false)
        }

        it("should be true if 150") {
          fieldType.validator("150cm") should be (true)
        }

        it("should be true if 193") {
          fieldType.validator("193cm") should be (true)
        }
      }

      describe("in") {
        it("should be false if below 59") {
          fieldType.validator("58in") should be (false)
        }

        it("should be false if below 76") {
          fieldType.validator("77in") should be (false)
        }

        it("should be true if 59") {
          fieldType.validator("59in") should be (true)
        }

        it("should be true if 76") {
          fieldType.validator("76in") should be (true)
        }
      }

      it("should be false if not inch or cm") {
        fieldType.validator("160mm") should be (false)
      }

    }
  }

  describe("Hair Color") {
    val fieldType = HairColor
    describe("name") {
      it("should be hcl") {
        fieldType.name should be ("hcl")
      }
    }

    describe("validator") {
      it("should be true if a valid color code") {
        fieldType.validator("#123123") should be (true)
        fieldType.validator("#12312f") should be (true)
        fieldType.validator("#f23123") should be (true)
        fieldType.validator("#aaaaaa") should be (true)
        fieldType.validator("#1aaaa9") should be (true)
      }

      it("should be invalid if pound sign is missing") {
        fieldType.validator("123456") should be(false)
      }

      it("should be invalid it does not contain 6 digits/letters") {
        fieldType.validator("#12345") should be(false)
      }

      it ("should be invalid if value contains invalid hex character") {
        fieldType.validator("#12345g") should be (false)
      }
    }
  }

  describe("Eye Color") {
    val fieldType = EyeColor
    describe("name") {
      it("should be ecl") {
        fieldType.name should be ("ecl")
      }
    }

    describe("validator") {
      Seq("amb", "blu", "brn", "gry", "grn", "hzl", "oth").foreach((color) => {
        it(s"should be true for $color") {
          fieldType.validator(color) should be (true)
        }
      })
      it("should be false for any other value") {
        fieldType.validator("asd") should be (false)
        fieldType.validator("fasd") should be (false)
        fieldType.validator("") should be (false)
        fieldType.validator("123") should be (false)
      }
    }
  }

  describe("Passport Id") {
    val fieldType = PassportId
    describe("name") {
      it("should be pid") {
        fieldType.name should be ("pid")
      }
    }

    describe("validator") {
      it("should be true for any number with 9 digits") {
        fieldType.validator("000000000") should be (true)
        fieldType.validator("012345678") should be (true)
      }

      it("should be false if input is too short") {
        fieldType.validator("00000000") should be (false)
      }

      it("should be false if input is too long") {
        fieldType.validator("0000000000") should be (false)
      }

      it("should be false if input is not a number") {
        fieldType.validator("a000000000") should be (false)
        fieldType.validator("000000000a") should be (false)
        fieldType.validator("00000a0000") should be (false)
      }
    }
  }

  describe("Country Id") {
    val fieldType = CountryId
    describe("name") {
      it("should be cid") {
        fieldType.name should be ("cid")
      }
    }

    describe("validator") {
      it("should always return true") {
        fieldType.validator("000000000") should be (true)
        fieldType.validator("012345678") should be (true)
        fieldType.validator("") should be (true)
        fieldType.validator("asdadasdasdadas") should be (true)
        fieldType.validator("!@#ASDASD!#)!$@#(*()P%!") should be (true)
      }
    }
  }
}
