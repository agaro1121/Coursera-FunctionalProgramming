class Rational(x: Int,y: Int) {
  require(y != 0, "Denominator must not be Zero")
//  assert(y != 0, "Denominator must not be Zero")

  def this(x: Int) = this(x,1)

  private def gcd(a: Int, b: Int):Int = if(b==0) a else gcd(b,a%b)
  private val g = gcd(x,y)

  //will simplify at construction
//  val numer = x / g
//  val denom = y / g

  val numer = x
  val denom = y

  def +(that: Rational) =
    new Rational(
      that.numer*this.denom + this.numer*that.denom,
      that.denom * this.denom)

  def neg = new Rational(-numer,denom)
  def -(that: Rational) = this + that.neg

  def <(that: Rational) =
    numer * that.denom < that.numer * denom
  def >(that: Rational) = that < this




  override def toString: String = s"${x/g} / ${y/g}"
}

def addRational(x: Rational, y: Rational): Rational =
  new Rational(
    x.numer*y.denom + y.numer*x.denom,
    x.denom * y.denom
  )


val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)

addRational(x,y)
x + y
x.neg
x - y
x - y - z

y + y
x < y
x > y
y > x

//throws exception due to requirement
//val strange = new Rational(1,0)


val onlyNum = new Rational(5)
