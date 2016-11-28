package chapter03

import org.scalatest.FunSuite

class Exercise01Test extends FunSuite{
    test("execute match expression"){
      assert( Exercise01.execute()  === 3)
    }
}