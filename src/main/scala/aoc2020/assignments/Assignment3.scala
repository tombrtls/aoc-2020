
package aoc2020.assignments

import aoc2020.Helper

import scala.util.Try

case class Vector(x: Int, y: Int) {
  def *(scalar: Int): Vector = {
    Vector(x * scalar, y * scalar)
  }
}

class GeoTile
object GeoTile {
  def fromChar(char: Char): GeoTile = {
    char match {
      case '.' => Empty
      case '#' => Tree
    }
  }
}
case object Tree extends GeoTile
case object Empty extends GeoTile
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
      .count((loc) => {
        isTreeAtLocation(loc)
      })
  }
}

object Assignment3 extends BaseAssignment [GeoMap, BigInt]{
  override def prepareInput(filePath: String) = {
    val tiles = Helper.readLinesFromFile(filePath)
      .map(line => {
        line
          .map(GeoTile.fromChar)
          .toList
      })
      .toList

    GeoMap(tiles)
  }

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
