package chapter03

import org.scalatest.FunSuite

class Exercise14Test extends FunSuite{

  test("append(1, (2,3) ) == (1,2,3)"){
    assert( List.append( 1, List(2,3 ) ) === List(1, 2, 3))
  }
}
