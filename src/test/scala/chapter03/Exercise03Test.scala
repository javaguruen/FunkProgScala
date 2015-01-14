package chapter03

import org.scalatest.FunSuite

class Exercise03Test extends FunSuite {

  test("setHead") {
    val xs: List[Int] = chapter03.List(1, 2, 3)
    assert(List.setHead(42, xs) === List(42, 1, 2, 3))
  }
}