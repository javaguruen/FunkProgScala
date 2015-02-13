package chapter04

object OptionMapper {
  def map2[A,B,C](a: scala.Option[A], b: scala.Option[B])(f: (A,B) => C): scala.Option[C] = {
    a.flatMap( aa => b.map( bb => f(aa, bb)))
  }
}
