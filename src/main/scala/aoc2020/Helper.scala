package aoc2020

import scala.io.Source
import java.io.InputStream

object Helper {
  def readFile(path: String): InputStream = {
    getClass.getResourceAsStream(path)
  }

  def readLinesFromFile(path: String): Iterator[String] = {
    val inputStream = readFile(path)
    Source.fromInputStream(inputStream).getLines()
  }
}
