val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
val capitalOfCountry = Map("US" -> "Washington",
"Switzerland" -> "Bern")

/**
  *
  * Class Map[Key,Value] extends function type Key => value,
  * so maps can be used everywhere functions can
  *
  * In particular, maps can be applied to key args:
  *   capitalOfCountry("US")
  *
  * */

capitalOfCountry("US")
//capitalOfCountry("Penis") //NoSuchElementException

//capitalOfCountry get "Penis"  //NoSuchElementException
capitalOfCountry get "US" //returns Option

/**
  * Operations similar to SQL:
  *
  * OrderBy:
  *   -can be expressd with sortWith and sorted
  *   val fruits = List("apple","pear","orange","pineapple")
  *   fruits sortWith (_.length < _.length)
  *   fruits.sorted
  *
  * GroupBy:
  *   -partitions a collecition into a map of collections
  *   according to a discriminator function f
  *
  *   fruits groupBy (_.head)
  *
  *
  * */

val fruits = List("apple","pear","orange","pineapple")
fruits sortWith (_.length < _.length)
fruits.sorted
fruits groupBy (_.head)


class Poly(val terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  val terms = terms0 withDefaultValue 0.0

 /* def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))

  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    /*terms get exp match {
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp -> coeff*/
    //Since we have default values. This can be replaced
    //with
    exp -> (coeff + terms(exp))
  }*/

  def +(other: Poly) = new Poly((other.terms foldLeft terms) (addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  override def toString: String =
    (for((exp,coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
}

val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)  //can remove explicit Map
                                                // Constructor call because
                                               //of constructor defined in class
val p2 = new Poly(Map(1 -> 3.0, 3 -> 7.0))
p1 + p2


/**
  * Maps are partial functions because a wrong key can give you an exception
  * you can make it a pure function by using method: withDefaultValue
  * */
val cap1 = capitalOfCountry withDefaultValue "<unknown>"
cap1("Angorra")


p1.terms(7) //shows default values