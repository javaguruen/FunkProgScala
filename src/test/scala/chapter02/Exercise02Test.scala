package chapter02

import org.scalatest.FunSuite

class Exercise02Test  extends FunSuite {


  test("er sortert stigende") {
    assert( Exercise02.isSorted( Array(12,9,6), (a:Int, b:Int) => a>b ) )
  }

  test("er sortert synkende") {
    assert( Exercise02.isSorted( Array(2,4,6), (a:Int, b:Int) => a<b ) )
  }

  test("ikke sortert") {
    assert( !Exercise02.isSorted( Array(5,4,6), (a:Int, b:Int) => a<b ) )
  }

  test("Tom liste") {
    assert( Exercise02.isSorted( Array(), (a:Int, b:Int) => a<b ) )
  }


}

