package chapter03

import org.scalatest.FunSuite

class ListTest extends FunSuite{

  test("tail gir siste verdier"){
    assert( List.tail( List(1,2,3 ) ) === List(2,3))
  }

  test("tail på Nil gir Nil"){
    assert( List.tail( Nil) === Nil )
  }

  test("tail på tom liste gir Nil"){
    assert( List.tail( List()) === Nil )
  }
}
