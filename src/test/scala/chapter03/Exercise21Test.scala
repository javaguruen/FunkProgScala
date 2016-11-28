package chapter03

import org.scalatest.FunSuite

class Exercise21Test extends FunSuite{

  test("filter using flatmap"){
    assert( List.filterByFlatmap( List(1,2,3))(i => i%2==0) === List(2)  )
  }

}
