import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class Pong extends AbstractActor {

  public Receive createReceive() {

    return ReceiveBuilder.create()
        .match(String.class, s -> {
          System.out.println(s);
        })
        .match(Ping.class, s -> {
          System.out.println("ping served");
          sender().tell(this, self());
        }).build();

  }
  public static Props props() {
    return Props.create(Pong.class);
  }

}
