import week3._ //wild card
//import week3.Rational  //named import
//import week3.{Rational, somethingElse } //many imports
new Rational(1,2)
trait Planar {
  def height: Int
  def width: Int
  def surface: Int = height * width
}

//Nothing type - descends from ALL types
//observe type once compiled
def error(msg: String) = throw new Error(msg)
//error("test")

// Null type (yes capital 'N') - descends from all REF types
// NOT compatible with subtypes of AnyVal
// observce below once compiled
null
val x = null
val y:String = null
//val Z:Int = null //not comptabile

if(true) 1 else false //type -> AnyVal

