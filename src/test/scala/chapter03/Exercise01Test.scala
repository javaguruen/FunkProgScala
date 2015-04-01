package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise01Test extends FunSuite{
    test("execute match expression"){
      assert( Exercise01.execute()  === 3)
    }
}