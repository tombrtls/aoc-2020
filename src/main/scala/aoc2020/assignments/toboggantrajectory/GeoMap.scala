package aoc2020.assignments.toboggantrajectory

case class GeoMap(tiles: List[List[GeoTile]]) {
  val height: Int = tiles.length
  val width: Int = tiles.head.length

  def tileAtLocation(location: Vector): GeoTile = {
    tiles(location.y)(location.x % width)
  }

  def isTreeAtLocation(location: Vector): Boolean = tileAtLocation(location) == Tree

  def numberOfTreesFollowingVector(vector: Vector): BigInt = {
    val steps = Math.floorDiv(height - 1, vector.y)
    Range(0, steps)
      .inclusive
      .map(vector * _)
      .count(isTreeAtLocation)
  }
}
