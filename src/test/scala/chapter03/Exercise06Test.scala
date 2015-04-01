package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise06Test extends FunSuite {

  test("init") {
    val xs: List[Int] = chapter03.List(1, 2, 3, 4, 5, 6)
    assert(List.init(xs) === List(1, 2, 3, 4, 5))
  }
}