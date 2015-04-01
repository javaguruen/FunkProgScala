package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise04Test extends FunSuite {

  test("drop") {
    val xs: List[Int] = chapter03.List(1, 2, 3, 4, 5, 6)
    assert(List.drop(2, xs) === List(3, 4, 5, 6))
  }
}