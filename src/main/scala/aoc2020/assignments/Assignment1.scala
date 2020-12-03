package aoc2020.assignments

import aoc2020._

object Assignment1 extends BaseAssignment[List[Int], Int] {
  implicit class Crossable[X](xs: Iterable[X]) {
    def cross[Y](ys: Iterable[Y]): Iterable[(X, Y)] =
      for { x <- xs; y <- ys } yield (x, y)
  }

  def flattenTuple[A, B, C](t: ((A, B), C)): (A, B, C) =
    (t._1._1, t._1._2, t._2)

  def prepareInput(path: String): List[Int] =
    Helper
      .readLinesFromFile(path)
      .map(_.toInt)
      .toList

  def processPart1(input: List[Int]): Int = {
    def sumTuple2Equals(value: Int) = { (tuple: (Int, Int)) =>
      (tuple._1 + tuple._2) == value
    }

    input
      .cross(input)
      .find(sumTuple2Equals(2020))
      .map { case (val1, val2) => val1 * val2 }
      .getOrElse(0)
  }

  def processPart2(input: List[Int]): Int = {
    def sumTuple3Equals(value: Int) = { (tuple: (Int, Int, Int)) =>
      (tuple._1 + tuple._2 + tuple._3) == value
    }

    input
      .cross(input)
      .cross(input)
      .map(flattenTuple)
      .find(sumTuple3Equals(2020))
      .map { case (val1, val2, val3) => val1 * val2 * val3 }
      .getOrElse(0)
  }
}
