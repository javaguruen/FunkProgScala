package chapter02

object Exercise04 {
  def main(args : Array[String]) {
    val cur = (a : Int, b:Int) => a*b
    val temp = curry(cur)
    val resultat = temp(6)
    println("Resultat= " + resultat(10))
  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    def g(a:A)(b:B) = f(a,b)
    g
  }
}
