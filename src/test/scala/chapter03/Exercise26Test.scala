package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise26Test extends FunSuite{

  test("maximum Løv 1"){
    assert( Tree.maximum( Leaf(1) ) === 1 )
  }

  test("maximum tre 4"){
    val tre = Branch(  Branch( Leaf(7), Leaf(4)), Leaf(3))
    assert( Tree.maximum( tre ) === 7 )
  }

}
