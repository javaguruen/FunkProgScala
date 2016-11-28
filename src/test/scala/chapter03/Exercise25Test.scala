package chapter03

import org.scalatest.FunSuite

class Exercise25Test extends FunSuite {

  test("CreateEmployeeObjectAndProperties") {

    val tree: Leaf[Int] = Leaf(1)
    assert( Tree.size( tree ) === 1 )
  }
}
