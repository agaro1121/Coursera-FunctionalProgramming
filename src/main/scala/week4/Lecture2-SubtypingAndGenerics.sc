//arrays NOT covariant in Scala !!!
val a: Array[Int] = Array[Int](1,2)
val b: Array[AnyVal] = a

/**
* <:  === UpperBound -> value on right is upperbound of left
* >:  === LowerBound -> value on right is lowerbound of left
**/

