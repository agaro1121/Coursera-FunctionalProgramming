def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case y :: ys => y + sum(ys)
}

val nums = List(2,-4,5,7,1)

nums reduceLeft(_ + _)
nums reduceLeft(_ * _)

nums.foldLeft(0)((x:Int,y:Int) => x+y)
nums.foldLeft(0)(_+_)
nums.foldLeft(0)(_-_)
nums.foldRight(0)(_-_)
nums.foldLeft(1)(_*_)

(nums foldLeft 0)(_ + _)
(nums foldLeft 1)(_ * _)

(nums foldRight 0)(_ + _)
(nums foldRight 1)(_ * _)

def concat[T](xs: List[T], ys: List[T]): List[T] =
  (xs foldRight ys)(_ :: _)

//def concat2[T](xs: List[T], ys: List[T]): List[T] =
//  (xs foldLeft ys)(_ :: _)
//Cons doesn't work out on foldLeft

def mapFun[T,U](xs: List[T], f: T=>U): List[U] =
  (xs foldRight List[U]())( ??? )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( ??? )

