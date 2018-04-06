import akka.actor.ActorRef

sealed trait Messages

case class FuturesDetails(price: Double, quant: Int, value: Double, FutureAggregator: ActorRef) extends Messages
case class FuturesValue(value: Double) extends Messages
case class StartWork(futureCalculator: ActorRef) extends Messages

