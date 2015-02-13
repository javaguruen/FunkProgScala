package chapter04

import org.scalactic.TolerantNumerics
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class VarianceTest extends FunSuite {
  implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.01)

  test("variance(None) === None") {
    assert( Variance.variance(Nil) === scala.None)
  }

  test("variance (2,4,6) === 2.6666") {
    val variance = Variance.variance( Seq(2.0, 4.0, 6.0) )
    variance should not be empty
    variance.get shouldEqual (2.6666 +- 0.2)
  }


}
