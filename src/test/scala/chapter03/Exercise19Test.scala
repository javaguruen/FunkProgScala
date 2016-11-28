package chapter03

import org.scalatest.FunSuite

class Exercise19Test extends FunSuite{

  test("filter - ta vekk oddetall"){
    assert( List.filter(List(1,2,3,4))( _%2==0) === List(2,4) )
  }

}
