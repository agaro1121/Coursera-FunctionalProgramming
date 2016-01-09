/*
* Types that accept mutations should NOT be covariant i.e Arrays
* Immutable typse can be covariant, if some conditions are met
* */

/**
  * Defining Variance
  *
  * Paramaterized C[T] and types A,B such that A <: B
  *
  * 3 possible relations between C[A] and C[B]
  *
  * C[A] <: C[B] -> Covariant
  * C[A] >: C[B] -> Contravariant
  * neither      -> Nonvariant (invariant)
  *
  * Scala
  * lets you declare the variance of a type by
  * annotating the type parameter
  *
  * class C[+A] { .. }      ->  C is Covariant
  * class C[-A] { .. }      ->  C is Contravariant
  * class C[A] { .. }       ->  C is Nonvariant (invariant)
  *
  * ---------------------------------------------------
  * Typing Rules for Functions
  * if A2 <: A1 and B1 <: B2, then
  * A1 => B1 <: A2 => B2
  *
  * SO, functions are CONTRAvariant in their ARGUMENTS
  * and COvariant in the result type
  *
  * trait Function1[-T, +U] {
  *   def apply(x: T): U
  *  }
  *
  * Scala Compiler Checks:
  * covariant type params     -> method results
  * contravariant type params -> method params
  * invariant type params     -> anywhere
  *
  *
  *
  * */

