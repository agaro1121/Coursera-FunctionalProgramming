/*
Write a recursive function which verifies the balancing of
parentheses in a string, which we represent as a List[Char]
not a String. For example,
the function should return true for the following strings:

  (if (zero? x) max (/ 1 x))
I told him (that it’s not (yet) done). (But he wasn’t listening)

The function should return false for the following strings:

  :-)
())(*/

def balance(chars: List[Char]): Boolean = {
  def loop(count: Int, chars: List[Char]): Int = {
    if (chars.isEmpty || count < 0) count
    else if (chars.head == '(') loop(count + 1, chars.tail)
    else loop(count - 1, chars.tail)
  }
  0 == loop(0, chars.filter((x => x==')' || x=='(')))
}

val positiveTest = "(if (zero? x) max (/ 1 x))".toList
val negativeTest = "())(*/".toList

balance(positiveTest)
balance(negativeTest)