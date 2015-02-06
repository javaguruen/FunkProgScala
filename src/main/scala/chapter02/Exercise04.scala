package chapter02

object Exercise04 {
  def main(args : Array[String]) {
    val cur = (a : Int, b:Int) => a*b
    val temp = curry(cur)
    val resultat = temp(6)
    println("Resultat= " + resultat(10))

    val dob = curry2(_*_)
    val dobler = dob(2)
    println("dobler(5)=" + dobler(5))
  }

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    def g(a:A)(b:B) = f(a,b)
    g
  }

  def curry2(f: (Int, Int) => Int): Int => (Int => Int) = {
    def g(a:Int)(b:Int) = f(a,b)
    g
  }
}
