package chapter02

object Exercise06 {
  def main(args : Array[String]) {
    val dobbel = (a : Int) => a*2
    val multPi = (a: Int) => a*Math.PI
    val estimat = compose(multPi, dobbel)
    println("Resultat= " + estimat(10))
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a:A) => f(g(a))
  }
}
