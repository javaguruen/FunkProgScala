package chapter04

import org.junit.runner.RunWith
import org.scalactic.TolerantNumerics
import org.scalatest.FunSuite
import org.scalatest.Matchers._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VarianceTest extends FunSuite {
  implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.01)

  test("variance(None) === None") {
    assert( Option.variance(Nil) === scala.None)
  }

  test("variance (2,4,6) === 2.6666") {
    val variance = Option.variance( Seq(2.0, 4.0, 6.0) )
    variance should not be empty
    variance.get shouldEqual (2.6666 +- 0.2)
  }


}
