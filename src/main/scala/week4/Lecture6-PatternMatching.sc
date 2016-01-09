trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(s: String) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match {
  case Number(n) => n
  case Sum(e1,e2) => eval(e1) + eval(e2)
}

def show(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(e1,e2) => s"${show(e1)} + ${show(e2)}"
  case Var(x) => x
  case Prod(x,y) => s"${show(x)} * ${show(y)}"
}

show(Sum(Number(1) , Number(44)))

show(Sum(Prod(Number(2),Var("x")), Var("y")))
show(Prod(Sum(Number(2), Var("x")), Var("y")) )
