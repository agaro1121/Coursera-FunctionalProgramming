//Lists are recursive. Arrays are flat
val empty: List[Nothing] = List()

/**
  * All Lists constructed from the empty List: Nil and...
  * the construction operation :: (cons)
  * x::xs -> new list with x first followed by xs
  */

val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3:: (4 :: Nil)))
val empty2 = Nil


/**Note: Operaations ending in ":" associate to the right
  *
  * A::B::C -> A::(B::C)
  *
  * example:
  * val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
  *
  * Operators ending in ":" are seen as method calls of the
  * RIGHT-HAND operand
  *
  * example:
  * Nil.::(4).::(3).::(2).::(1)
  * <---  <---  <---  <---  <---
  *
  */

/**
  * Pattern Matching
  * Nil             -> The Nil constant
  * p :: ps         -> A pattern that matches a list with a head
  *                    matching p and a tail matching ps
  * List(p1,...,pn) -> same as p1 :: ... :: pn :: Nil
  *
  * Example
  * 1 :: 2:: xs   -> Lists that start with 1 and then 2
  * x :: Nil      -> Lists of length 1
  * List(x)       -> Same as x :: Nil
  * List()        -> Empty List/Nil
  * List(2 :: xs) -> List with List in it that starts with 2
  *                  List(List(2,...,n))
  */

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y::ys => insert(y,isort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if(x <= y) x::xs
                  else y::insert(x,ys)
}

val r = isort(List(7,3,9,2))
