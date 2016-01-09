def sumInts(a: Int, b: Int): Int =
if(a > b) 0 else a + sumInts(a+1,b)

def cube(x: Int): Int = x * x * x

def sumCubes(a: Int, b: Int): Int =
  if(a > b) 0 else cube(a) + sumCubes(a+1,b)

def fact(x: Int):Int = if(x == 0) 1 else x * fact(x-1)
def sumFactorials(a: Int, b: Int): Int =
  if(a > b) 0 else fact(a) + sumFactorials(a+1,b)

def sum(f: Int => Int, a: Int, b: Int): Int =
  if(a > b) 0
  else f(a) + sum(f, a + 1, b)

def id(x: Int): Int = x

def sumInts2(a: Int, b: Int):Int = sum(id,a,b)
def sumCubes2(a: Int, b: Int): Int = sum(cube,a,b)
def sumFactorials2(a: Int, b: Int): Int = sum(fact,a,b)

def sumInts3(a: Int, b: Int):Int = sum(x => x,a,b)
def sumCubes3(a: Int, b: Int): Int = sum(x => x*x*x,a,b)

def sum2(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a+1,acc + f(a))
  }
  loop(a,0)
}

sumInts2(1,3)
sumInts3(1,3)
sum2(x=>x,1,3)