trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
  def isEmpty = false
}

class Nil[T] extends List[T]
{
  def isEmpty: Boolean = true
  def tail: List[T] =
    throw new NoSuchElementException("Empty list has no head")
  def head: T =
    throw new NoSuchElementException("Empty list has no tail")
}

object List{

  def apply[T](x1: T,x2: T): List[T] =
    new Cons(x1, new Cons(x2,new Nil))

  def apply[T]() = new Nil

  def apply[T](x1: T) = new Cons(x1,new Nil)

  def apply[T](x1: T, x2: T, x3: T) =
    new Cons(x1, apply(x2,x3))
}

