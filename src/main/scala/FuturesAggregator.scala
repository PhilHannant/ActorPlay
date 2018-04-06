import akka.actor.{Actor, ActorLogging}


class FuturesAggregator extends Actor with ActorLogging {

  var total: Double = 0

  def receive: Receive = {
    case FuturesValue(value) =>
      println(s"${self.path} received value " + value)
      total+=value
      println(total)
    case StartWork(futureCalculator) =>
      var v = scala.util.Random
      println(s"${self.path} received work")
      futureCalculator ! FuturesDetails(v.nextInt(10000), v.nextInt(50), v.nextInt(10000), self)

  }

}
