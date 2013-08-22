package chapter03

import org.scalatest.FunSuite

class Exercise25Test extends FunSuite{

  test("size Løv 1"){
    assert( Tree.size( Leaf(1) ) === 1 )
  }

  test("size tre 5"){
    val tre = Branch(  Branch( Leaf(2), Leaf(4)), Leaf(3))
    assert( Tree.size( tre ) === 5 )
  }

}
