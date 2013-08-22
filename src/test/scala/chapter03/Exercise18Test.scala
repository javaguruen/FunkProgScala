package chapter03

import org.scalatest.FunSuite

class Exercise18Test extends FunSuite{

  test("Map double til String "){
    val input : List[Double] = List(1.0, 2.0 , 3.0)
    val expected = List("1.0", "2.0", "3.0")
    assert( List.map(input)(_.toString) === expected)
  }

}
