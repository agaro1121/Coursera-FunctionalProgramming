package week3

/**
  * Created by anthonygaro on 11/11/15.
  */
class Lecture {

}

object Lecture extends App {
  val t1 = new NonEmpty(3, new Empty, new Empty)
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem,left incl x, right)
    else if (x > elem) new NonEmpty(elem,left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true


  override def union(other: IntSet): IntSet =
    (((left union right) union other) incl elem)

  override def toString: String = "{" + left + elem + right + "}"
}

class Empty extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def contains(x: Int): Boolean = false


  override def union(other: IntSet): IntSet = other

  override def toString: String = "."
}