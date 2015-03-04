package chapter04

sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    map(f) getOrElse None
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case Some(a) => a
    case None => default
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = {
    this.map(Some(_)) getOrElse ob
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if f(a) => this
    case _ => None
  }
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

object Option {

  def sequence[A](a: List[scala.Option[A]]): scala.Option[List[A]] =
    a match {
      case Nil => scala.Some(Nil)
      case (h :: t) => h.flatMap(hh => sequence(t) map (tt => hh :: tt))
    }

  def sequence2[A](a: List[scala.Option[A]]): scala.Option[List[A]] = {
    def f(xs: List[scala.Option[A]], ys: List[A]): List[A] = xs match {
      case Nil => ys
      case z :: zs if z.isDefined => f(zs, z.get :: ys)
      case _ => Nil
    }

    val traversed = f(a, Nil)
    traversed match {
      case Nil => scala.None
      case l => scala.Some(l)
    }
  }

  def map2[A,B,C](a: scala.Option[A], b: scala.Option[B])(f: (A,B) => C): scala.Option[C] = {
    a.flatMap( aa => b.map( bb => f(aa, bb)))
  }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    None
  }

  def variance(xs: Seq[Double]): scala.Option[Double] = {
    def mean(xs: Seq[Double]): scala.Option[Double] = xs match {
      case Nil => scala.None
      case _ => scala.Some(xs.sum / xs.size)
    }

    val avg: scala.Option[Double] = mean(xs)
    avg flatMap (m => mean(xs.map(x => math.pow(x - m, 2.0))))
  }
}