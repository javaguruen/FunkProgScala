package chapter02

object Exercise05 {
  def main(args : Array[String]) {
    val product = (a : Int, b:Int) => a*b
    val curr = curry(product)
    val uncur = uncurry( curr )
    println("Resultat= " + uncur(10, 6))
  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    def g(a:A)(b:B) = f(a,b)
    g
  }

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    def h(a:A, b:B) = f(a)(b)
    h
  }
}
