package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise09Test extends FunSuite {

  test("length by foldRight") {
    val xs: List[Int] = chapter03.List(1, 2, 3)
    assert(List.lengthFR( xs ) === 3 )
  }
}