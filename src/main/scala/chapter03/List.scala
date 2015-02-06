package chapter03

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) {
      Nil
    }
    else {
      Cons(as.head, apply(as.tail: _*))
    }


  def head[A](as : List[A] ) : A = {
    as match {
      case Cons(x, xs) => x
      case _ => throw new MatchError("head of empty list")
    }
  }

  def tail[A](as: List[A]): List[A] = {
    as match {
      case Nil => Nil
      case Cons(x, xs) => xs
    }
  }

  def drop[A](n: Int, as: List[A]): List[A] = {
    if (n == 0) {
      as
    }
    else {
      drop(n - 1, tail(as))
    }
  }

  def dropWhile[A](xs: List[A])(f: A => Boolean): List[A] = {
    xs match {
      case Nil => Nil
      case Cons(a, as) => if (f(a)) {
        dropWhile(as)(f)
      }
      else {
        xs
      }
    }
  }

  def setHead[A](head: A, l: List[A]): List[A] = {
    Cons(head, l)
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h, t) => Cons(h, append(t, a2))
    }

  def init[A](xs: List[A]): List[A] = {


    def f(first: List[A], l: List[A]): List[A] = {
      l match {
        case Cons(_, Nil) => first
        case Cons(a, as) => f(append(first, Cons(a, Nil)), as)
      }
    }

    f(Nil, xs)
  }

  def foldRight[A, B](l: List[A], z: B)(f: (A, B) => B): B =
    l match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def length[A](xs: List[A]): Int = {
    xs match {
      case Nil => 0
      case Cons(x, xs) => 1 + length(xs)
    }
  }

  @tailrec
  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = {
    l match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  def sumFL(ints: List[Int]): Int = foldLeft(ints, 0)(_ + _)

  def productFL(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)

  def lengthFL[A](l: List[A]): Int = foldLeft(l, 0)((b, _) => b + 1)

  def lengthFR[A](xs: List[A]): Int =
    foldRight(xs, 0)((a, b) => b + 1)

  def reverse[A](l: List[A]): List[A] = {
    foldLeft(l, Nil: List[A])((a, b) => setHead(b, a))
  }

  def foldLeftByFoldRight[A, B](l: List[A], z: B)(f: (B, A) => B): B = {
    //todo
    l match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  def append[A](elem: A, list: List[A]): List[A] = {
    val l: List[A] = foldLeft(list, List(elem))((a, b) => Cons(b, a))
    reverse(l)
  }

  def concat[A](bigList: List[List[A]]): List[A] = {

    @tailrec
    def con(listA: List[A], listB: List[A]): List[A] = {
      listA match {
        case Cons(x, xs) => con(xs, append(x, listB))
        case _ => reverse(listB)
      }
    }

    reverse(foldLeft(bigList, Nil: List[A])(con))
  }

  def mapI(list: List[Int])(f: Int => Int): List[Int] = {
    list match {
      case Cons(x, xs) => Cons(f(x), mapI(xs)(f))
      case _ => Nil
    }
  }

  def mapD(list: List[Double])(f: Double => String): List[String] = {

    def m(l: List[Double], r: List[String]): List[String] = {
      l match {
        case Cons(x, xs) => m(xs, Cons(f(x), r))
        case _ => r
      }
    }
    reverse(m(list, Nil: List[String]))
  }

  def map[A, B](list: List[A])(f: A => B): List[B] = {

    def m(l: List[A], r: List[B]): List[B] = {
      l match {
        case Cons(x, xs) => m(xs, Cons(f(x), r))
        case _ => r
      }
    }
    reverse(m(list, Nil: List[B]))
  }

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {

    def fm[A, B](bs: List[A], res: List[B])(g: A => List[B]): List[B] = {
      bs match {
        case Nil => res
        case Cons(x, xs) => fm(xs, append( res, g(x)))(g)
      }
    }

    val temp = fm(as, Nil)(f)
    temp
  }

  def filterByFlatmap[A](list: List[A])(func: A => Boolean): List[A] = {
    flatMap(list)( (a) => if ( func(a) ) Cons(a, Nil) else Nil )
  }

  def addLists( as : List[Int], bs : List[Int] ) : List[Int] = {
    def adder(cs : List[Int], ds : List[Int], res: List[Int] ) : List[Int] = {
      cs match {
        case Nil => res
        case Cons(x, xs) => adder( xs, List.tail(ds), Cons( x+List.head(ds), res ))
      }
    }
    List.reverse( adder(as, bs, Nil) )
  }

  def zipWith[A, B]( as : List[A], bs : List[A] )( f : (A, A) => B) : List[B] = {

    def func(cs : List[A], ds : List[A], res: List[B] ) : List[B] = {
      cs match {
        case Nil => res
        case Cons(x, xs) => func( xs, List.tail(ds), Cons( f(x, List.head(ds)), res ))
      }
    }
    List.reverse( func(as, bs, Nil) )
  }

  def filter[A](list: List[A])(func: A => Boolean): List[A] = {

    def filt(l: List[A], r: List[A]): List[A] = {
      l match {
        case Cons(x, xs) => if (func(x)) {
          filt(xs, Cons(x, r))
        }
        else {
          filt(xs, r)
        }
        case _ => r
      }
    }
    reverse(filt(list, Nil: List[A]))
  }
}
