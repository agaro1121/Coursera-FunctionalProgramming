/**
  * Handling Nested Sequences
  *
  * Given a positive integer n, find all pairs of
  * positive integers i and j with 1 <= j < i < n
  * such that i + j is prime
  *
  * example: if n = 7, the pairs are
  *
  * i: Seq[Int] = List(2, 3, 4, 4, 5, 6, 6)
  * j: Seq[Int] = List(1, 2, 1, 3, 2, 1, 5)
  * i+j: Seq[Int] = List(3, 5, 5, 7, 7, 7, 11)
  *
  *
  * */


val i = Seq(2,3,4,4,5,6,6)
val j = Seq(1,2,1,3,2,1,5)
val iplusj = i zip j map{case(x,y) => x+y}

val n = 7
val result = (1 until n) map (i =>
              (1 until i) map (j => (i,j)))

//(result foldRight Seq[Int]() )(_ ++ _) //Not sure why it's not working
result.flatten

val result2 = (1 until n) flatMap (i =>
  (1 until i) map (j => (i,j)))

def isPrime(n: Int): Boolean =
  (2 until n) forall (d => n % d != 0) //ANSWER

result2 filter (pair => isPrime(pair._1 + pair._2))

/**
  * For-Expressions
  *
  * for (s) yield e
  * for {s} yield e
  *
  * s -> sequence of generators and filters
  *
  * */

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i+j)
} yield (i,j)

def scalarProduct(xs: Vector[Int], ys: Vector[Int]): Double =
//  (xs zip ys).map{case (x,y) => x*y}.sum
  (for( (r,s) <- xs zip ys ) yield r * s).sum

val a = Vector(1,2,3)
val b = Vector(4,5,6)
scalarProduct(a,b)