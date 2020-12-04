package aoc2020.assignments.assignment3

case class Vector(x: Int, y: Int) {
  def *(scalar: Int): Vector = {
    Vector(x * scalar, y * scalar)
  }
}
