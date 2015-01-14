package chapter03

import org.scalatest.FunSuite

class Exercise09Test extends FunSuite {

  test("length by foldRight") {
    val xs: List[Int] = chapter03.List(1, 2, 3)
    assert(List.length( xs ) === 3 )
  }
}