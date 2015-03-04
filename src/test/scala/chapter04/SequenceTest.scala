package chapter04

import org.scalatest.FunSuite

class SequenceTest extends FunSuite {

  test("sequence(Nil) === Some(Nil)") {
    assert(Option.sequence(Nil) === scala.Some(Nil))
  }

  test("sequence(List( Some(1) ) === Some(List(1))") {
    assert(Option.sequence(List(scala.Some(1))) === scala.Some( List(1)))
  }

  test("sequence(List( None ) === None") {
    assert(Option.sequence( List( scala.None) ) === scala.None)
  }

  test("sequence(List( Some(1), None ) === None") {
    assert(Option.sequence( List( scala.Some(1), scala.None) ) === scala.None)
  }
}
