package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise22Test extends FunSuite{

  test("add two lists pairwise"){
    assert( List.addLists( List(1,2,3), List(4, 5, 6)) === List(5, 7, 9)  )
  }

}
