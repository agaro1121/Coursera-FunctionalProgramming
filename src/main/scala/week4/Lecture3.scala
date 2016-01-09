package idealized.scala

abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def &&(x: idealized.scala.Boolean): idealized.scala.Boolean = ifThenElse[idealized.scala.Boolean](x, idealized.scala.`false`)

  def ||(x: idealized.scala.Boolean): idealized.scala.Boolean = ifThenElse[idealized.scala.Boolean](idealized.scala.`true`,x)

  def unary_! = ifThenElse(idealized.scala.`false`,idealized.scala.`true`)

  def == (x: idealized.scala.Boolean): idealized.scala.Boolean = ifThenElse(x,x.unary_!)
  def != (x: idealized.scala.Boolean): idealized.scala.Boolean = ifThenElse(x.unary_!, x)

  def < (x: Boolean) = ifThenElse(`false`,x)
}

object `true` extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

object `false` extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}

