package chapter04

import org.scalatest.FunSuite

class OptionTest extends FunSuite {

  test("map(None) === None") {
    assert(None.map(a => a) === None)
  }

  test("Some(10).map(_=>_*2 === Some(20)") {
    assert(Some(10).map(_ * 2) === Some(20))
  }

  test("Some(10).flatMap( f  === Some(10)") {
    assert(Some(10).flatMap(n => mayBeEven(n)) === Some(10))
  }

  test("Some(5).flatMap( f  === None") {
    assert(Some(5).flatMap(n => mayBeEven(n)) === None)
  }

  test("Some(10) getOrElse (5) == 10"){
    assert( Some(10).getOrElse(5) === 10)
  }

  test("None getOrElse (5) == 5"){
    assert( None.getOrElse(5) === 5)
  }

  test("Some(10) orElse None == Some(10)"){
    assert( Some(10).orElse( None ) === Some(10))
  }

  test("None orElse Some(10) == Some(10)"){
    assert( None.orElse( Some(10) ) === Some(10))
  }

  test("None orElse None == None"){
    assert( None.orElse( None ) === None)
  }

  test("Some(10).filter( isEven ) === Some(10)"){
    assert( Some(10).filter( isEven ) == Some(10))
  }

  test("Some(5).filter( isEven ) === None"){
    assert( Some(5).filter( isEven ) == None)
  }

  test("None.filter( isEven ) === None"){
    assert( None.filter( isEven ) == None)
  }

  def isEven( n: Int): Boolean = {
    n % 2 == 0
  }

  def mayBeEven(n: Int): Option[Int] = {
    if (n % 2 == 0) {
      Some(n)
    }
    else {
      None
    }
  }
}
