import akka.actor._

object Master extends App{

  val system = ActorSystem("futureSystem")
  val fa = system.actorOf(Props[FuturesAggregator], "futuresAggregator")
  val fc = system.actorOf(Props[FuturesCalculator], "futuresCalculator")

  for(x <- 0 to 10) {
    fa ! StartWork(fc)
    Thread.sleep(5000)
  }

//  fc ! PoisonPill
//  fa ! PoisonPill
  system.deadLetters
  system.terminate()
}
