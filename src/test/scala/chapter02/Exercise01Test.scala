package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise01Test  extends FunSuite {


  test("Fibonacci(1)") {
    assert( Exercise01.fibonacci(1) === 0)
  }
  test("Fibonacci(2)") {
    assert( Exercise01.fibonacci(2) === 1)
  }
  test("Fibonacci(3)") {
    assert( Exercise01.fibonacci(3) === 1)
  }
  test("Fibonacci(4)") {
    assert( Exercise01.fibonacci(4) === 2)
  }
  test("Fibonacci(5)") {
    assert( Exercise01.fibonacci(5) === 3)
  }


}

