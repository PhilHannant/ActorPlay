import akka.actor.{Actor, ActorLogging}


class FuturesCalculator extends Actor with ActorLogging {

  def receive: Receive = {
    case FuturesDetails(price, quant, value, futureAggregator) =>
      println(s"${self.path} received future " + price + ", " + quant + ", " + value )
      futureAggregator ! FuturesValue((price - value)*quant)
  }

}
