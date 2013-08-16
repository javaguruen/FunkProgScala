package chapter02

object Exercise03 {
  def main(args : Array[String]) {
    val produkt = (a : Int, b:Int) => a*b
    val temp = partial1(10, produkt)
    val resultat = temp(6)
    println("Resultat= " + resultat)
  }

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = {
    (b: B) => f(a, b)
  }

}
