package aoc2020

import scala.io.Source
import java.io.InputStream

object Helper {
  def readLinesFromFile(path: String): Iterator[String] = {
    Source.fromResource(path).getLines()
  }
}
