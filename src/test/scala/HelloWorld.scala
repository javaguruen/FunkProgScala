import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HelloWorld  extends FunSuite {

  test("pop is invoked on a non-empty stack") {
    assert( "Hello World" === "Hello World")
  }

}

