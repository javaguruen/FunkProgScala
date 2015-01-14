package chapter03

import org.scalatest.FunSuite

class Exercise05Test extends FunSuite {

  test("dropWhile") {
    val xs: List[Int] = chapter03.List(1, 2, 3, 4, 5, 6)
    assert(List.dropWhile(xs)(x => x<4) === List(4, 5, 6))
  }
}