/*
* Write a function that computes the elements
* of Pascal’s triangle by means of a recursive process.
*
* Do this exercise by implementing the pascal function
* in Main.scala, which takes a column c and a row r,
* counting from 0 and returns the number at that spot
* in the triangle. For example,
* pascal(0,2)=1
* pascal(1,2)=2
* pascal(1,3)=3.
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
*/

def pascal(c: Int, r: Int): Int = {
  @annotation.tailrec
  def inner(counter: Int, currRow: List[Int]): List[Int] = {
    if(counter == r) currRow
    else inner(counter+1,getNextRow(currRow))
  }
  def getNextRow(s: List[Int]) =
    1 :: {for { i <- s.indices }
      yield s(i) + {if(i != s.length-1) s(i+1) else 0}}.toList

  inner(0,List(1))(c)
}

pascal(0,2)
pascal(1,2)
pascal(1,3)

def pascal2(c: Int, r: Int): Int = {
  if (c == 0 || c == r) 1
  else pascal(c - 1, r - 1) + pascal(c, r - 1)
}

pascal2(0,2)
pascal2(1,2)
pascal2(1,3)

