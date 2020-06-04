import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class PingPong {

  public static void main(String[] args) {
    ActorSystem actorSystem = ActorSystem.create();
    ActorRef pong = actorSystem.actorOf(Pong.props());
    ActorRef ping = actorSystem.actorOf(Ping.props(pong));
    ping.tell("hello", ActorRef.noSender());
  }

}
