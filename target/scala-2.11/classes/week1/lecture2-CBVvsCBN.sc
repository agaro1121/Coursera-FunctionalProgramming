def square(x: Double):Double = x * x
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

/* Call By Value - Advantage - Every function arg evaluated only once
* sumOfSquares(3,2+2)
* sumOfSquares(3,4)
* square(3) + square(4)
* 3 * 3 + square(4)
* 9 + square(4)
* 9 + 4 * 4
* 9 + 16
* 25
* */

/* Call By Name - Advantage - Function arg not evaluated at all if
* if corresponding param is not used in evaluation of the function body
* sumOfSquares(3,2+2)
* square(3) + square(2+2)
* 3 * 3 + square(2 + 2)
* 9 + (2+2) * (2+2)
* 9 + 4 + (2+2)
* 9 + 4 * 4
* 25
*/

/* Exercise - def test(x: Int, y: Int) = x * x
* test(2,3) -> SAME
* CBV ->
*   test(2,3)
*   2 * 2
*   4
* CBN ->
*   test(2,3)
*   2 * 2
*   4
*
* test(3+4,8) -> CBV
* CBV ->
*   test(3+4,8)
*   test(7,8)
*   7 * 7
*   49
* CBN ->
*   test(3+4,8)
*   (3+4) * (3+4)
*   7 * (3+4)
*   7 * 7
*   49
*
* test(7,2*4) -> CBN
* CBV ->
*   test(7,2*4)
*   test(7,8)
*   7 * 7
*   49
* CBN ->
*   test(7,2*4)
*   7 * 7
*   49
*
* test(3+4, 2*4) -> SAME
* CBV ->
*   test(3+4, 2*4)
*   test(7,2*4)
*   test(7,8)
*   7 * 7
*   49
* CBN ->
*   test(3+4, 2*4)
*   (3+4) * (3+4)
*   7 * (3+4)
*   7 * 7
*   49
*
* */