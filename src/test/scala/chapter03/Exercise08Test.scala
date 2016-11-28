package chapter03

import org.scalatest.FunSuite

class Exercise08Test extends FunSuite {

  test("Nil and Cons to foldRight") {
    val xs: List[Int] = chapter03.List(1, 2, 3)
    assert(List.foldRight( xs, Nil:List[Int])(Cons(_, _)) === List(1, 2, 3))
  }
}