//In General, if last action of a function is to call a
//function(could be itself), then one stack frame will be enough
//for both functions

//Not Tail Recursive
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

//Tail recursive
def factorial2(n: Int): Int = {
  @annotation.tailrec
  def loop(n: Int, acc: Int):Int = {
    if(n == 0) acc
    else loop(n-1,acc * n)
  }
  loop(n,1)
}

//Tail Recursive - Able to reuse stack frame of
//that function
@annotation.tailrec
def gcd(a: Int, b: Int): Int =
  if(a == 0) a else gcd(b, a % b)

factorial(3) == factorial2(3)
