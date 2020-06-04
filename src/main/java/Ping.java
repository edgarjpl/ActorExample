import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class Ping extends AbstractActor {
  private static ActorRef pong;


  public Ping(ActorRef pong){
    this.pong = pong;
  }


  public Receive createReceive() {
    return ReceiveBuilder.create()
        .match(String.class, s -> {
          System.out.println(s);
          pong.tell(this, self());
        })
        .match(Pong.class, s -> {
          System.out.println("pong responded");
          sender().tell("Ok thats all", self());
        }).build();
  }

  public static Props props(ActorRef pong) {

    return Props.create(Ping.class, pong);

  }
}
