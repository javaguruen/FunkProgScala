package chapter03

object Exercise08 {

  def main(args: Array[String]) {
    val r = List.foldRight(List(1,2,3), Nil : List[Int] )(Cons(_,_))
    println("r=" + r)
  }
}
