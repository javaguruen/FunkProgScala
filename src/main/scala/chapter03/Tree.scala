package chapter03


sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A]( tree : Tree[A] ) : Int = {

    def count(t : Tree[A] ) :Int = {
      t match{
        case Leaf(a) => 1
        case Branch(l,r) => 1 + count(l) + count(r)
        case _ => 0
      }
    }

    count(tree)
  }

  def maximum(tree : Tree[Int] ) : Int = {

    tree match{
      case Leaf(v) => v
      case Branch(l,r) =>   maximum(l).max( maximum(r))
    }
  }
}
