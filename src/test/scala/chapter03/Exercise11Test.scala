package chapter03

import org.scalatest.FunSuite

class Exercise11Test extends FunSuite{

  test("sumFL (1,2,3) == 6"){
    assert( List.sumFL( List(1,2,3 ) ) === 6)
  }

  test("productFL (1,2,3, 4) == 24"){
    assert( List.productFL( List(1,2,3, 4 ) ) === 24)
  }

  test("lengthFL (1,2,3, 4) == 4"){
    assert( List.lengthFL( List(1,2,3, 4 ) ) === 4)
  }
}
