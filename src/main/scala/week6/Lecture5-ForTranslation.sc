/**
  * for (x <- e1) yield e2
  *   e1.map(x => e2)
  *
  *   for(x <- e1 if f; s) yield e2
  *
  *   f = filter
  *
  *   for (x<- e1.withFilter(x => f); s) yield e2
  *
  * for (x <- e1; y <- e2; s) yield e3
  *   e1.flatMap(x => for (y <- e2; s ) yield e3
  *
  * for {
  *   j <- 1 until n
  *   j <- 1 until i
  *   if isPrime(i + j)
  *  } yield (i,j)
  * //Above is same as below
  * (1 until n).flatMap(i =>
  *   (1 until i).withFilter(j => isPrime(i+j))
  *     .map(j => (i,j)))
  *
  * for (b <- books; a <- b.authors if a startsWith "Bird")
  * yield b.title
  * answer below:
  * books.flatMap( b =>
  *    (b.authors.withFilter(a => a startsWith "Bird")
  *     .map(c => c.title)))
  *
  * */