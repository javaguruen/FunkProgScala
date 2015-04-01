package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
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

  test("drop(1) gir siste verdier"){
    assert( List.drop( 1, List(1,2,3 ) ) === List(2,3))
  }

  test("drop(3) gir Nil"){
    assert( List.drop( 3, List(1,2,3 ) ) === Nil)
  }

  test("drop(n) på Nil gir Nil"){
    assert( List.drop( 2, Nil) === Nil )
  }

  test("drop(n) på tom liste gir Nil"){
    assert( List.drop( 1, List()) === Nil )
  }

  test("dropWhile(1,2,3)(_<2 ) gir (2,3) "){
    assert( List.dropWhile( List(1,2,3 ) )(_<2) === List(2,3))
  }

  test("dropWhile(1,2,3)(_<=3 ) gir Nil "){
    assert( List.dropWhile( List(1,2,3 ) )(_<=3) === Nil)
  }

  test("dropWhile(1,2,3)(_ > 3 ) gir (1,2,3) "){
    assert( List.dropWhile( List(1,2,3 ) )( _ > 3) === List(1,2,3) )
  }

  test("setHead(1, List(2,3) ) gir (1,2,3) "){
    assert( List.setHead( 1, List(2,3 ) ) === List(1,2,3) )
  }

  test("init( List(1, 2,3) ) gir (1,2) "){
    assert( List.init( List(1, 2,3 ) ) === List(1,2) )
  }

  test("length( List(1, 2,3) ) gir 3 "){
    assert( List.length( List(1, 2,3 ) ) === 3 )
  }

  test("length( Nil ) gir 0 "){
    assert( List.length( Nil ) === 0 )
  }

  test("foldRight gir StackOverflow"){
    var l = List(0)
    for( i <- 1 until 10000 ) l = List.setHead(i, l)
    intercept[StackOverflowError]{
      List.foldRight( l, 0)( _+_ )
    }
  }

  test("foldLeft gir ikke StackOverflow"){
    var l = List(0)
    for( i <- 1 until 10000 ) l = List.setHead(i, l)
    assert( List.foldLeft( l, 0)( _+_ ) === 49995000 )
  }



}
