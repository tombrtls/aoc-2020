package aoc2020.assignments.toboggantrajectory

import aoc2020.assignments.BaseAssignment

object Assignment extends BaseAssignment [GeoMap, BigInt]{
  override def prepareLinesForInput(lines: List[String]): GeoMap = {
    GeoMap(lines.map(lineToTiles))
  }

  def lineToTiles(line: String) =
    line.map(GeoTile.fromChar(_)).toList

  override def processPart1(input: GeoMap) = {
    input.numberOfTreesFollowingVector(Vector(3, 1))
  }

  override def processPart2(input: GeoMap) = {
    val vectors = Seq(Vector(1, 1), Vector(3, 1), Vector(5,1), Vector(7, 1), Vector(1, 2))
    vectors
      .map(input.numberOfTreesFollowingVector)
      .product
  }
}
