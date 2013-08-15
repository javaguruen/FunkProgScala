package chapter02

import scala.annotation.tailrec

object Exercise02 {

  def main(args : Array[String]) {
  }

  def isSorted[A](as: Array[A], gt : (A,A) => Boolean) : Boolean = {

    @tailrec
    def fold[A](a : A, as : List[A], gt : (A,A)=> Boolean) : Boolean = {
      as match {
        case xs :: xt => {
          if( gt(a, xs) ) fold(xs, xt, gt) else false
        }
        case Nil => true
      }
    }

    val list = as.toList
    if( list.isEmpty) true
    else fold( list.head, list.tail, gt)
  }
}
