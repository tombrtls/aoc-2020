package aoc2020.assignments.assignment3

class GeoTile
case object Tree extends GeoTile
case object Empty extends GeoTile

object GeoTile {
  def fromChar(char: Char): GeoTile = {
    char match {
      case '.' => Empty
      case '#' => Tree
    }
  }
}