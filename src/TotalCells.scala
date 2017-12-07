object TotalCells {

  def main(args: Array[String]): Unit = {
    println("Select First from 1 to 100: ")
    val n = scala.io.StdIn.readLine().toInt

    println("Select Second from 1 to 100: ")
    val m = scala.io.StdIn.readLine().toInt

    println(totalCellsVisited(n, m))
  }


  def totalCellsVisited(n: Int, m: Int): Int = m match {
    case _ if m < 2 || n < 2 => n * m
    case _ if n % 2 == 1 => 2 * n + totalCellsVisited(m - 2, n)
    case _ => 2 * n
  }

}



