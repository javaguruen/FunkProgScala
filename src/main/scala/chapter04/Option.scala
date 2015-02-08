package chapter04

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a:A) => Some(f(a))
  }

    def flatMap[B](f: A => Option[B]): Option[B] = None
    def getOrElse[B >: A](default: => B): B = default
    def orElse[B >: A](ob: => Option[B]): Option[B] = ob
    def filter(f: A => Boolean): Option[A] = None
}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
