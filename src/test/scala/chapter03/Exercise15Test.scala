package chapter03

import org.scalatest.FunSuite

class Exercise15Test extends FunSuite{

  test("Concatenate( (1,2,3), (4,5,6), (7,8,9) ) == (1,2,3,4,5,6,7,8,9)"){
    assert( List.concat( List( List(1,2,3), List(4,5,6), List(7,8,9)) ) === List(1, 2, 3, 4, 5,6 ,7 ,8 ,9))
  }
}
