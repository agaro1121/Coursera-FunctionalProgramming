package week3

/**
 * Created by Hierro on 12/3/15.
 */
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

  def unary_- : Rational= new Rational(-numer,denom)
  def -(that: Rational) = this + -that

  def <(that: Rational) =
    numer * that.denom < that.numer * denom
  def >(that: Rational) = that < this




  override def toString: String = s"${x/g} / ${y/g}"
}
