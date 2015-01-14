package chapter03

import org.scalatest.FunSuite

class Exercise02Test extends FunSuite {

  test("tail ok") {
    val xs: List[Int] = chapter03.List(1, 2, 3)
    assert(List.tail(xs) === List(2, 3))
  }

  test("tail list Nil") {
    val xs: List[Int] = Nil
    assert(List.tail(xs) === Nil)
  }
}