type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)

def singletonSet(elem: Int): Set = (elem) => elem == elem

val one = singletonSet(1)
val two = singletonSet(2)



//(x: Int) => x < 0
def union(s: Set, t: Set): Set = ???


def intersect(s: Set, t: Set): Set = ???
def diff(s: Set, t: Set): Set = ???

