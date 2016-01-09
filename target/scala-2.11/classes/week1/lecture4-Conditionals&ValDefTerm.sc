//if-else is an expression not a statement
def abs(x: Int) = if(x >=0) x else -x

/* Right operand doesn't always get evaluated -
 * Short circuit evaluation
 * true  && e -> e
 * false && e -> false
 * true  || e -> true
 * false || e -> e
 */

def loop: Boolean = loop

def x = loop
//val x = loop //Does not compile.
               //y evaluated at point of def'n

/*Exercise
 * Write functions for and(x,y) == x && y
 * or(x,y) == x || y
 */
//def and(x: Boolean, y: Boolean) = if(x) y else x
//2nd Param needs to be CBN according to above notes
def and(x: Boolean, y: => Boolean) = if(x) y else x
//Below CBN param is debatable but still works
def or(x: Boolean, y: => Boolean)  = if(x) x else y

and(true,true)
and(true,false)
and(false,true)
and(false,false)

or(true,true)
or(true,false)
or(false,true)
or(false,false)