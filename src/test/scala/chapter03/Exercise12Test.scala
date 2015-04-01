package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise12Test extends FunSuite{

  test("reverse(1,2,3) == (3,2,1)"){
    assert( List.reverse( List(1,2,3 ) ) === List(3, 2, 1))
  }
}
