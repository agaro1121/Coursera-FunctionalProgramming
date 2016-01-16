/**
  * Streams
  *
  * Like lists but tail is only evaluated on demand
  *
  *
  * */

val xs = Stream.cons(1, Stream.cons(2,Stream.empty))

Stream(1,2,3)

(1 to 1000).toStream

def streamRange(lo: Int, hi: Int): Stream[Int] = {
  print(lo + " ")
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

def listRange(lo: Int, hi: Int): List[Int] = {
  print(lo + " ")
  if (lo >= hi) Nil
  else lo :: listRange(lo + 1, hi)
}

def isPrime(n: Int): Boolean =
  (2 until n) forall (d => n % d != 0)


(((1 to 1000).toStream) filter isPrime)(21)

/**
  * Lists vs Streams
  *
  * Lists   ->  ::
  * Streams -> #::
  *
  * */

streamRange(1,10).take(3).toList
