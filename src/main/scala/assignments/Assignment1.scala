package assignments

object Assignment1 {

  implicit class Crossable[X](xs: Traversable[X]) {
    def cross[Y](ys: Traversable[Y]) =
      for { x <- xs; y <- ys } yield (x, y)
  }

  implicit def flatten[A, B, C](t: ((A, B), C)): (A, B, C) =
    (t._1._1, t._1._2, t._2)

  def part1(input: List[Int]): Int = {
    val combination =
      input
        .cross(input)
        .find(sumTuple2Equals(2020))

    combination match {
      case Some((val1, val2)) => val1 * val2
      case None               => 0
    }
  }

  def part2(input: List[Int]): Int = {
    val combination =
      input
        .cross(input)
        .cross(input)
        .map(flatten)
        .find(sumTuple3Equals(2020))

    combination match {
      case Some((val1, val2, val3)) => val1 * val2 * val3
      case None                     => 0
    }
  }

  def sumTuple2Equals(value: Int) = { (tuple: (Int, Int)) =>
    (tuple._1 + tuple._2) == value
  }

  def sumTuple3Equals(value: Int) = { (tuple: (Int, Int, Int)) =>
    (tuple._1 + tuple._2 + tuple._3) == value
  }
}
