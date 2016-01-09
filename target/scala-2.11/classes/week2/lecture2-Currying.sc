import com.sun.org.apache.xpath.internal.operations.UnaryOperation

def sumOld(f: Int => Int, a: Int, b: Int): Int =
  if(a > b) 0
  else f(a) + sumOld(f, a + 1, b)

def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
def fact(x: Int):Int = if(x == 0) 1 else x * fact(x-1)

def sumInts(a: Int, b: Int):Int = sumOld(id,a,b)
def sumCubes2(a: Int, b: Int): Int = sumOld(cube,a,b)
def sumFactorials(a: Int, b: Int): Int = sumOld(fact,a,b)

def sum(f: Int => Int): (Int,Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if(a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

sum (cube) (1,10)

def sum2(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sum(f)(a + 1, b)
}

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 1
  else f(a) * product(f)(a + 1, b)
}

product (id) (1,4)

def fact2(n: Int): Int = product(id)(1,n)
fact2(5)

def combined(f: Int => Int)(base: Int, op: (Int,Int) => Int)(a: Int, b: Int): Int = {
  if(a > b) base
  else op(f(a),combined(f)(base,op)(a + 1, b))
}

combined (id) (1,(a:Int,b:Int)=>a*b)(1,4)

def product2(f: Int => Int)(a: Int, b: Int): Int =
  combined(f)(1,(x,y)=>x*y)(a,b)

product2(id)(1,3)