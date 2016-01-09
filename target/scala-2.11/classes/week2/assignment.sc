type Set = Int => Boolean
def contains(s: Set, elem: Int): Boolean = s(elem)
def singletonSet(elem: Int): Set = (x:Int) => x == elem
val one = singletonSet(1)
val two = singletonSet(2)
val three = singletonSet(3)
val one2 = singletonSet(1)
def union(s: Set, t: Set): Set = (x:Int) => s(x) || t(x)
def intersect(s: Set, t: Set): Set = (x:Int) => s(x) && t(x)
def diff(s: Set, t: Set): Set = (x:Int) => s(x) && !t(x)
def filter(s: Set, p: Int => Boolean): Set = intersect(s,p)
val u = union(union(one,two),three)
val i = intersect(one,two)
val d = diff(one,two)
val d2 = diff(two,one)
contains(u,1)
contains(u,2)
contains(u,3)
contains(i,1)
contains(i,2)
contains(i,3)
contains(d,1)
contains(d,2)
contains(d,3)
contains(d2,1)
contains(d2,2)
contains(d2,3)

contains(one,1)
contains(one,2)
contains(one,3)

contains(two,1)
contains(two,2)
contains(two,3)

contains(three,2)
contains(three,1)
contains(three,3)

val filteredByOne = filter(u,(x: Int) => x == 1)
filteredByOne(1)
filteredByOne(2)
filteredByOne(3)

//-1000 <= x <= 1000
/*
* iterate over all integers,
* testing each time whether it
* is included in the set, and if
* so, to do something with it
* */
def forall(s: Set, p: Int => Boolean): Boolean = {
  @annotation.tailrec
  def iter(a: Int): Boolean = {
    if (a >= 1000) s(a) && p(a)
    else if (s(a)) p(a)
    else iter(a + 1)
  }
  iter(-1000)
}
forall(u, (x:Int)=> x < 3)
forall(u, (x:Int)=> x > 3)
forall(u, (x:Int)=> x > 2)
forall(u, (x:Int)=> x > 1)
forall(u, (x:Int)=> x >= 1)

def exists(s: Set, p: Int => Boolean): Boolean = {
  @annotation.tailrec
  def iter(a: Int): Boolean = {
    if (a >= 1000) s(a) && p(a)
    else if (s(a) && p(a)) true
    else iter(a + 1)
  }
  iter(-1000)
}

exists(u, (x:Int)=> x < 3)
exists(u, (x:Int)=> x > 3)
exists(u, (x:Int)=> x > 2)
exists(u, (x:Int)=> x > 1)
exists(u, (x:Int)=> x >= 1)

def map(s: Set, f: Int => Int): Set =
  b => exists(s, f(_) == b)
val plusOne = map(one,x => x + 1)
plusOne(1)
plusOne(2)
plusOne(3)

/*
* s = x == 1
* f = x + 1
*
* */