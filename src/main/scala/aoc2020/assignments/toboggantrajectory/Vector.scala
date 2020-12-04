package aoc2020.assignments.toboggantrajectory

case class Vector(x: Int, y: Int) {
  def *(scalar: Int): Vector = {
    Vector(x * scalar, y * scalar)
  }
}
