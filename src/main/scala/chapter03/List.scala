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
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))


  def tail[A](as: List[A] ) : List[A] = {
    as match{
      case Nil => Nil
      case Cons(x, xs) => xs
    }
  }

  def drop[A](n : Int, as: List[A] ) :List[A] = {
    if( n == 0 ) as
    else{
      drop(n-1, tail(as) )
    }
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = {
    l match{
      case Nil => Nil
      case Cons(x, xs) => if( f(x) ) dropWhile( xs)( f) else l
    }
  }

  def setHead[A](head : A, l: List[A]): List[A] = {
    Cons(head, l)
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

  def init[A](l: List[A]): List[A] = {

    def f( first : List[A], l : List[A] ) : List[A] ={
      l match {
        case Cons(_, Nil) => first
        case Cons( x, xs ) => f( append(first, Cons(x,Nil) ), xs )
      }
    }

    f( Nil, l)
  }

  def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B =
    l match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def length[A](l: List[A] ) : Int = {
    l match {
      case Nil => 0
      case Cons(x, xs) => 1 + length(xs)
    }
  }

  @tailrec
  def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = {
    l match{
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  def sumFL(ints: List[Int]): Int = foldLeft(ints, 0)(_+_)

  def productFL(ds: List[Double]): Double = foldLeft(ds, 1.0)(_*_)

  def lengthFL[A](l: List[A] ) : Int = foldLeft(l, 0)((b,_)=> b+1)

  def reverse[A](l: List[A] ) : List[A] = {
    foldLeft(l, Nil:List[A])( (a,b) => setHead( b, a))
  }

  def foldLeftByFoldRight[A,B](l: List[A], z: B)(f: (B, A) => B): B = {
    //todo
    l match{
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

}
