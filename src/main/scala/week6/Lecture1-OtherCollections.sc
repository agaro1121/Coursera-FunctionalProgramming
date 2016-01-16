/**
  * Vector
  *
  * First 32 elements stored as (linear)list
  *
  * If it gets more than 32 then it becomes
  * list of 32 pointers pointing to 32 linear lists 32x32=1024
  *
  * If that gets exhausted that it becomes list of
  * pointers pointing to 32 lists of pointers pointing
  * to lists 32x32x32=32,768 aka 32bits
  *
  * This slowly becomes tree structure
  *
  * Levels
  * 1-32
  * 2-2^10
  * 2-2^15
  * 2-2^20
  * 2-2^25
  * 2-2^30 -> Limit 1billion
  *
  * Depth = log32(N)
  *
  * Good for bulk operations
  * Traverses list fairly quickly
  *
  * */

val nums = Vector(1,2,4,-88)
val people = Vector("Bob","James","Peter")

/**
  * New Operations
  * -Cons operation not here
  *
  * x +: xs -> Create new Vector prepending x to xs
  * x :+ xs -> Create new Vector appending x to xs
  * Note: ":" points to sequence
  *
  * */

/**
  * Arrays and Strings support
  * iterable operations
  * */
val xs = Array(1,2,3,4)
xs map (x => x * 2)

val s = "Hello World"
s filter (c => c.isUpper)

/***
  * Range
  * Represents sequence of evenly spaced integers
  *
  * 3 Operators:
  *   1. to (inclusive)
  *   2. until (exclusive)
  *   3. by (to determine step value)
  *
  * Represents SINGLE object with 3 fields:
  *   1. lower bound
  *   2. upper bound
  *   3. step value
  */
var r: Range = 1 until 5
var t: Range = 1 to 5
1 to 10 by 3
1 until 10 by 3
6 to 1 by -2
6 until 2 by -2

/**
  * Sequence Operations
  *
  * xs zip yes -> Sequence of pairs constructed
  *               from both sequences
  *
  * xs.unzip -> Splits sequence of pairs into 2 sequences
  *
  * */

s exists (c => c.isUpper)
s forall (c => c.isUpper)

val pairs = List(1,2,3) zip s
pairs.unzip

s flatMap (c => List('.',c))
xs.sum
xs.max
xs.product


/*
* List all combinations of numbers x and y where is drawn
* from 1..M and y is drawn from 1..N
*
* (1 to M) flatMap (x => (1 to N) map (y => (x,y)))
*
* */

val M = 5
val N = 3

(1 to M) flatMap (x => (1 to N) map (y => (x,y)))

/*
* To compute the scalar product of two vectors
*
*
*
* */

def scalarProduct(xs: Vector[Int], ys: Vector[Int]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum


val a = Vector(1,2,3)
val b = Vector(4,5,6)
scalarProduct(a,b)

def scalarProduct2(xs: Vector[Int], ys: Vector[Int]): Double =
  (xs zip ys).map{case (x,y) => x*y}.sum

def isPrime(n: Int): Boolean =
  /*if(2 until n exists(x => n%x == 0)) false
  else true*/ //My original
  (2 until n) forall (d => n % d != 0) //ANSWER

isPrime(11)
isPrime(10)