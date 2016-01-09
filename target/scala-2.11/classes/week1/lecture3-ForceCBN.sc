/*
* If CBV terminates, then CBN terminates
* NOT VICE VERSA
* */

def loop:Int = loop

def first(x: Int, y: Int) = x

/*
* first(1,loop)
*   CBN ->
*     1
*   CBV ->
*     infinite loop
* */

//first(1,loop) //Does not Compile

//************ 2nd Param forces scala to treat 2nd param
//************ as CBN *observe arrow b4 type*
def constOne(x: Int, y: => Int) = 1

/*
* constOne(1+2,loop)
*   CBV ->
*     constOne(1+2,loop)
*     constOne(3,loop)
*     1
* constOne(loop, 1+2)
*   CBV ->
*     constOne(loop, 1+2)
*     infinite loop
* */
constOne(1+2,loop)
//constOne(loop, 1+2) //Does not Compile