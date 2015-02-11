package chapter04

sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a: A) => Some(f(a))
  }

  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(a) => f(a)
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case Some(a) => a
    case None => default
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => None
    case Some(a) => ob
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case None => None
    case Some(a) => ma
  }
}
case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]
