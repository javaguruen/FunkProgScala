package chapter03

import org.scalatest.FunSuite

class Exercise23Test extends FunSuite{

  test("add two lists pairwise"){
    assert( List.zipWith( List(1,2,3), List(4, 5, 6))(_+_) === List(5, 7, 9)  )
  }

  test("multiply two lists pairwise"){
    assert( List.zipWith( List(1,2,3), List(4, 5, 6))(_*_) === List(4, 10, 18)  )
  }

}
