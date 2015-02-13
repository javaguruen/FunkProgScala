object SuperTypes{
  def main(args: Array[String]) = {
    val a = new MyTopClass()
    val b = new MySubClass()

    val superTypes = new SuperTypes[MyTopClass]
    superTypes.method(a)
    superTypes.method(b)
    val subTypes = new SuperTypes[MyTopClass]
    subTypes.method(a)
    subTypes.method(b)
  }
}
class SuperTypes[+A] {
  def method[B >: A](b : B) ={
    println(s"arg: $b received")
  }
}

class MyTopClass{

}
class MySubClass{

}

