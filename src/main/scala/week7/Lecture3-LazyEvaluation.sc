/**
  * Haskell used default lazes by default
  *
  * Scala uses strict evaluation by default
  *
  * lazy val x = expr
  *
  * */


def expr = {
  val x = {print("x");1} //gets evaluated ONCE EAGERLY
                    //no matter how many times you call it
  lazy val y = {print("y");2} //gets evaluated ONCE LAZILY
                    //no matter how many times you call it
  def z = {print("z");3} //gets evaluated every time it's called
  z + y + x + z + y + x
}

expr

def streamRange(lo: Int, hi: Int): Stream[Int] = {
  print(lo + " ")
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

def isPrime(n: Int): Boolean =
  (2 until n) forall (d => n % d != 0)

(streamRange(1000,10000) filter isPrime) apply 1