import scala.io.Source

val in =
  Source.fromURL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt")

val words = in.getLines.toList
            .filter(word => word forall (ch => ch.isLetter))
            .take(100000) //~340,000 words

val mnemonics = Map(
  '2' ->"ABC",
  '3' -> "DEF",
  '4' -> "GHI",
  '5' -> "JKL",
  '6' -> "MNO",
  '7' -> "PQRS",
  '8' -> "TUV",
  '9' -> "WXYZ"
)

val charCode: Map[Char,Char] =
  for {
    (key,value) <- mnemonics
    c <- value
  } yield (c,key)

def wordCode(word: String): String =
  word map (l => charCode(l.toUpper))

wordCode("java")

val wordsForNum: Map[String, Seq[String]] =
 words groupBy wordCode withDefaultValue Seq()

def encode(number: String): Set[List[String]] =
  if(number.isEmpty) Set(List())
  else {
    for {
      split <- 1 to number.length
      word <- wordsForNum(number take split)
      rest <- encode(number drop split)
    } yield word :: rest
  }.toSet

def translate(number: String) =
  encode(number) map (_ mkString (" ") )

translate("28773337")

