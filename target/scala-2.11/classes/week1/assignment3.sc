/*
* Exercise 3: Counting Change
Write a recursive function that counts
how many different ways you can make change
for an amount, given a list of coin denominations.

For example, there are 3 ways to give change for 4
if you have coins with denomiation 1 and 2:
1+1+1+1
1+1+2
2+2.

Do this exercise by implementing the countChange
function in Main.scala. This function takes an amount
to change, and a list of unique denominations for
the coins. Its signature is as follows:

def countChange(money: Int, coins: List[Int]): Int
Once again, you can make use of functions isEmpty,
head and tail on the list of integers coins.
* */
//
/*def countChange(money: Int, coins: List[Int]): Int = {
  def calculate(a: Int, b: Int, acc: Int, ex: Int): Int = {
    if (acc >= ex){println(s"calculate: a=$a b=$b acc=$acc"); acc}
    else calculate(a,b, acc + b,ex)
  }

  (
    for {
      a <- coins
      b <- coins
    } yield {
      calculate(a, b, a, money)
    }
    ).filter(_ == money).length
}*/

def countChange(money: Int, coins: List[Int]): Int = {
  if(money == 0)
    1
  else if(money > 0 && !coins.isEmpty)
    countChange(money - coins.head, coins) + countChange(money, coins.tail)
  else
    0
}
val money = 4
val coins = List(1,2)
countChange(money,coins)
