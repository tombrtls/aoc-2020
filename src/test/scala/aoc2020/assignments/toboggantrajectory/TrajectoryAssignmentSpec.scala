package aoc2020.assignments.toboggantrajectory

import aoc2020.assignments.toboggantrajectory
import org.scalatest.flatspec._
import org.scalatest.matchers._

class TrajectoryAssignmentSpec extends AnyFlatSpec with should.Matchers {
  var testInput = "assign_3_test.txt"
  var actualInput = "assign_3.txt"

  "Vector" should "multiply" in {
    (toboggantrajectory.Vector(1, 1) * 2) should be(toboggantrajectory.Vector(2, 2))
    (toboggantrajectory.Vector(1, 1) * 3) should be(toboggantrajectory.Vector(3, 3))
    (toboggantrajectory.Vector(1, 3) * 3) should be(toboggantrajectory.Vector(3, 9))
    (toboggantrajectory.Vector(3, 1) * 3) should be(toboggantrajectory.Vector(9, 3))
  }

  "GeoMap" should "wrap it's locations around horizontally" in {
    val map = GeoMap(List(List(Tree, Empty)))
    map.isTreeAtLocation(toboggantrajectory.Vector(0, 0)) should be(true)
    map.isTreeAtLocation(toboggantrajectory.Vector(1, 0)) should be(false)
    map.isTreeAtLocation(toboggantrajectory.Vector(2, 0)) should be(true)
  }

  "part 1" should "return 7" in {
    TrajectoryAssignment.executePart1(testInput) should be(7)
  }
  "part 1" should "return 176" in {
    TrajectoryAssignment.executePart1(actualInput) should be(176)
  }

  "part 2" should "return 336" in {
    TrajectoryAssignment.executePart2(testInput) should be(336)
  }

  "part 2" should "return 5872458240" in {
    TrajectoryAssignment.executePart2(actualInput) should be(BigInt(5872458240L))
  }
}