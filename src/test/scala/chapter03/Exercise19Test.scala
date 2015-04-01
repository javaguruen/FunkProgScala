package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise19Test extends FunSuite{

  test("filter - ta vekk oddetall"){
    assert( List.filter(List(1,2,3,4))( _%2==0) === List(2,4) )
  }

}
