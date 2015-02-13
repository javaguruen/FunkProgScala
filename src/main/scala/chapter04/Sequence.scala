package chapter04

object Sequence {

  def sequence[A](a: List[scala.Option[A]]): scala.Option[List[A]] = {
    def f(xs: List[scala.Option[A]], ys: List[A]): List[A] = xs match {
      case Nil => ys
      case z :: zs if z.isDefined => f(zs, z.get :: ys)
      case _ => Nil
    }

    val traversed = f(a, Nil)
    traversed match{
      case Nil => scala.None
      case l => scala.Some( l )
  }
}

/*
    if (a.contains( scala.None) )
      scala.None
    else
      scala.Some( a.map( x => x.get) )
*/
}
