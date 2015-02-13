package chapter04

object Variance {
  def variance(xs: Seq[Double]): scala.Option[Double] = {
    def mean(xs: Seq[Double]):scala.Option[Double] = xs match {
      case Nil => scala.None
      case _   => scala.Some(xs.sum / xs.size)
    }

    val avg : scala.Option[Double] = mean(xs)
    avg flatMap( m =>  mean( xs.map( x => math.pow(x-m, 2.0))))
  }
}
