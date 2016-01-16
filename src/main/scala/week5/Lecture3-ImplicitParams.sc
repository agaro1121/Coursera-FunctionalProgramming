//merge sort
def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
  val n =  xs.length/2
  if(n == 0) xs
  else{
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs,ys) match {
        case (Nil,ys) => ys
        case (xs,Nil) => xs
        case (x::xs1, y::ys1) =>
          if(lt(x , y)) x::merge(xs1,ys)
          else y::merge(xs,ys1)
      }

    val (fst,snd) = xs splitAt(n)
    merge(msort(fst)(lt),msort(snd)(lt))
  }
}

val nums = List(2,-4,5,7,1)
msort(nums)((x:Int,y:Int) => x < y)
msort(nums)((x,y) => x < y)

val fruits = List("apple","pineapple","banana","orange")
msort(fruits)((x:String,y:String) => x.compareTo(y) < 0)
msort(fruits)((x,y) => x.compareTo(y) < 0)

//msort with Built in Ordering[T]
//merge sort
import math.Ordering
def msort2[T](xs: List[T])(ord: Ordering[T]): List[T] = {
  val n =  xs.length/2
  if(n == 0) xs
  else{
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs,ys) match {
        case (Nil,ys) => ys
        case (xs,Nil) => xs
        case (x::xs1, y::ys1) =>
          if(ord.lt(x , y)) x::merge(xs1,ys)
          else y::merge(xs,ys1)
      }

    val (fst,snd) = xs splitAt(n)
    merge(msort2(fst)(ord),msort2(snd)(ord))
  }
}

msort2(nums)(Ordering.Int)
msort2(fruits)(Ordering.String)

//msort with Implicit Ordering[T] - MUCH SHORTER
//merge sort
import math.Ordering
def msort3[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n =  xs.length/2
  if(n == 0) xs
  else{
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs,ys) match {
        case (Nil,ys) => ys
        case (xs,Nil) => xs
        case (x::xs1, y::ys1) =>
          if(ord.lt(x , y)) x::merge(xs1,ys)
          else y::merge(xs,ys1)
      }

    val (fst,snd) = xs splitAt(n)
    merge(msort3(fst),msort3(snd))
  }
}

msort3(nums) //Implicit Ordering defined in it's Companion Object
msort3(fruits)