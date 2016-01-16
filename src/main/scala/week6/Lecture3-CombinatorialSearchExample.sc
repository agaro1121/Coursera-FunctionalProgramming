/**
  * Sets
  *
  * Sets vs Sequences
  * 1. Unordered. No predefined order
  * 2. No duplicates
  * 3. Fundamental Operation: Contains
  *   -For Sequence: Head, Tail
  *
  *
  * */

/*
* Example
*
* N-Queens
* Place all 8 queens on a chessboard so that no queen
* threatens another
*
* No 2 queens can be in the same row, column, diagonal
*
*
* */

def queens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] =
    if(k == 0) Set(List())
    else
      for{
        queens <- placeQueens(k-1)
        col    <- 0 until n
        if isSafe(col,queens)
      } yield col :: queens

  placeQueens(n)
}

def isSafe(col: Int, queens: List[Int]): Boolean = {
  val row = queens.length
  val queensWithRow = (row-1 to 0 by -1) zip queens
  queensWithRow forall {
    case(r,c) => col != c && math.abs(col - c) != row - r
  }
}

def show(queens: List[Int]) = {
  val lines =
    for(col <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(col,"X ").mkString
    "\n" + (lines mkString "\n")
}

(queens(8) take 2 map show) mkString "\n"
