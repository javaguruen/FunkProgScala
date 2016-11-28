package chapter03

import org.scalatest.FunSuite

class Exercise06Test extends FunSuite {

  test("init") {
    val xs: List[Int] = chapter03.List(1, 2, 3, 4, 5, 6)
    assert(List.init(xs) === List(1, 2, 3, 4, 5))
  }
}