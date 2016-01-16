def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => y * y :: squareList(ys)
}

def squareList2(xs: List[Int]): List[Int] = xs map(y => y * y)

/**
  * Extra sublists based on a predicate
  *
  * xs filterNot p -> Sublist of elements that do not
  *                   satisfy predicate
  *
  * xs partition p -> Same as (xs filter p, xs filterNot p)
  *
  * xs takeWhile p -> longest prefix of list xs consisting
  *                   of elements that all satisfy the
  *                   predicate p
  *                   AKA
  *                   iterates the original list until it
  *                   finds one element that doesn’t satisfy
  *                   the predicate, all this elements
  *                   are added in the result list
  *
  * xs dropWhile p -> Remainder of the list xs after any
  *                   leading elements satisfying p have
  *                   been removed.
  *                   AKA
  *                   iterates the original list until it
  *                   finds one element that doesn’t
  *                   satisfy the predicate, the
  *                   remaining elements are added in
  *                   the result list
  *
  * xs span p      -> Same as (xs takeWhile p, xs dropWhile p)
  *
  *
  *
  * */


val nums = List(2,-4,5,7,1)
val fruits = List("apple","pineapple","banana","orange")


nums filter (x => x > 0)
nums filterNot (x => x > 0)
nums partition (x => x > 0)

nums partition a
def a(x: Int):Boolean = {
  x > 0
}

nums takeWhile (x => x > 0)
nums dropWhile (x => x > 0) //includes failing case
nums span (x => x > 0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x::xs1 =>
    val (first,rest) = xs span (y => x == y)
    first :: pack(rest)
}

val data = List("a","a","a","b","c","c","a")
pack(data) map(x => (x take 1,x.length))

def encode[T](xs: List[T]): List[(T,Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

encode(data)

