package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.Matchers._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class OptionMapper$Test extends FunSuite {
  test("map2(None, None)(f) === None"){
    Option.map2(scala.None, scala.None)(multiply) shouldBe empty
  }

  test("map2(Some(10), None)(f) === None"){
    Option.map2(scala.Some(10), scala.None)(multiply) shouldBe empty
  }

  test("map2(None, Some(10))(f) === None"){
    Option.map2(scala.None, scala.Some(10))(multiply) shouldBe empty
  }

  test("map2(Some(10), Some(5)(f) === 50"){
    val multiplied: scala.Option[Int] = Option.map2(scala.Some(10), scala.Some(5))(multiply)
    multiplied should not be empty
    multiplied.get shouldBe 50
  }

  def multiply(a: Int, b: Int) = a*b
}
