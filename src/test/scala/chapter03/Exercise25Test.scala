package chapter03

import no.hamre.UnitSpec
import org.scalatest.junit.JUnitSuite
import org.junit.Test

class Exercise25Test extends JUnitSuite {

  @Test def testCreateEmployeeObjectAndProperties() {

    val tree: Leaf[Int] = Leaf(1)
    assert( Tree.size( tree ) === 1 )

//    assert(employee.firstName === "Lukasz")

  }

/*
  "Tree with one leaf " should " have size one" in{
    val tree: Leaf[Int] = Leaf(1)
    Tree.size( tree ) should be ( 1 )
  }
*/

/*
  test("size Løv 1"){
    assert( Tree.size( Leaf(1) ) === 1 )
  }

  test("size tre 5"){
    val tre = Branch(  Branch( Leaf(2), Leaf(4)), Leaf(3))
    assert( Tree.size( tre ) === 5 )
  }

*/
}
