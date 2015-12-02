class Rational(x: Int,y: Int) {
  val numer = x
  val denom = y

  def +(that: Rational) =
    new Rational(
      that.numer*this.denom + this.numer*that.denom,
      that.denom * this.denom)

  def neg = new Rational(-numer,denom)
  def -(that: Rational) = this + that.neg



  override def toString: String = s"$x / $y"
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