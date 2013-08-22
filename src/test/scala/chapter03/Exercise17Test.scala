package chapter03

import org.scalatest.FunSuite

class Exercise17Test extends FunSuite{

  test("Map double til String i listen"){
    val input : List[Double] = List(1.0, 2.0 , 3.0)
    val expected = List("1.0", "2.0", "3.0")
    assert( List.mapD(input)(_.toString) === expected)
  }

}
