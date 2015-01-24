package chapter03

import org.scalatest.FunSuite

class Exercise20Test extends FunSuite{

  test("flatmap"){
    assert( List. flatMap(List(1,2,3))(i => List(i,i)) === List(1,1,2,2,3,3)  )
  }

}
