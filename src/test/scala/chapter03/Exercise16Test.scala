package chapter03

import org.scalatest.FunSuite

class Exercise16Test extends FunSuite{

  test("Legg 1 til alle integere i listen"){
    val input = List(1,2 ,3)
    val expected = List(2,3 ,4)
    assert( List.mapI(input)(_+1) === expected)
  }

  test("Legg 3 til alle integere i listen"){
    val input = List(1,2 ,3)
    val expected = List(4,5 ,6)
    assert( List.mapI(input)(_+3) === expected)
  }
}
