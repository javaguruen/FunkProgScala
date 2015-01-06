package chapter02

import scala.annotation.tailrec

object Exercise01 {

  def main(args : Array[String]) {
    println( "Fibonacci(1)=" + fibonacci(1))
    println( "Fibonacci(2)=" + fibonacci(2))
    println( "Fibonacci(3)=" + fibonacci(3))
    println( "Fibonacci(4)=" + fibonacci(4))
    println( "Fibonacci(5)=" + fibonacci(5))
  }

  def fibonacci(n: Int) : Int = {

    @tailrec
    def fibo(i : Int, sec : Int, prev : Int) : Int = i match {
      case 0 => prev
      case _ => fibo(i-1, prev, prev+sec)
    }

    n match {
      case 1 => 0
      case 2 => 1
      case _ => fibo(n-2, 0, 1)
    }
  }
}
