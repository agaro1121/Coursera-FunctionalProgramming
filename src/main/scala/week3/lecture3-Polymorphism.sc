import java.util.NoSuchElementException

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Cons[T](val head: T, val tail: List[T]) extends List[T]
{
  override def isEmpty: Boolean = false

}

class Nil[T] extends List[T]
{
  def isEmpty: Boolean = true

  def tail: List[T] =
    throw new NoSuchElementException("Empty list has no head")

  def head: T =
    throw new NoSuchElementException("Empty list has no tail")
}

def singleton[T](elem: T) = new Cons[T](elem,new Nil[T])
singleton[Boolean](true)
singleton[Int](1)

singleton(true)
singleton(1)

def nth[T](n: Int, list: List[T]): T =
{
  @annotation.tailrec
  def loop[T](index: Int,list: List[T]): T = {
    if(list.isEmpty) throw new IndexOutOfBoundsException
    else if(n == index) list.head
    else loop(index + 1, list.tail)
  }

  loop(0,list)
}

/*
def nth[T](n: Int, list: List[T]): T =
{
    if(list.isEmpty) throw new IndexOutOfBoundsException
    else if(n == 0) list.head
    else nth(n - 1, list.tail)
}
*/


nth(0,singleton(1))
val list = new Cons(1,new Cons(2, new Cons(3, new Nil)))
nth(2,list)
//nth(-1,list) //throws exception as expected
//nth(4,list) //throws exception as expected