package aoc2020.assignments.assignment3

import aoc2020.assignments.assignment3
import org.scalatest.flatspec._
import org.scalatest.matchers._

class Assignment3Spec extends AnyFlatSpec with should.Matchers {
  var testInput = "assign_3_test.txt"
  var actualInput = "assign_3.txt"

  "Vector" should "multiply" in {
    (assignment3.Vector(1,1) * 2) should be(assignment3.Vector(2, 2))
    (assignment3.Vector(1,1) * 3) should be(assignment3.Vector(3, 3))
    (assignment3.Vector(1,3) * 3) should be(assignment3.Vector(3, 9))
    (assignment3.Vector(3,1) * 3) should be(assignment3.Vector(9, 3))
  }

  "GeoMap" should "wrap it's locations around horizontally" in {
    val map = GeoMap(List(List(Tree, Empty)))
    map.isTreeAtLocation(assignment3.Vector(0, 0)) should be (true)
    map.isTreeAtLocation(assignment3.Vector(1, 0)) should be (false)
    map.isTreeAtLocation(assignment3.Vector(2, 0)) should be (true)
  }

  "part 1" should "return 7" in {
    Assignment3.executePart1(testInput) should be(7)
  }
  "part 1" should "return 176" in {
    Assignment3.executePart1(actualInput) should be(176)
  }

  "part 2" should "return 336" in {
    Assignment3.executePart2(testInput) should be(336)
  }

  "part 2" should "return 5872458240" in {
    Assignment3.executePart2(actualInput) should be(BigInt(5872458240L))
  }
}
