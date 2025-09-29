
import src.observer.UserSubscriber;
import src.subject.YouTubeChannel;

public class Main {

    public static void main(String[] args) {
        YouTubeChannel techChannel = new YouTubeChannel("TechExplained");

        UserSubscriber alice = new UserSubscriber("Alice");
        UserSubscriber bob = new UserSubscriber("Bob");
        UserSubscriber carol = new UserSubscriber("Carol");

        techChannel.subscribe(alice);
        techChannel.subscribe(bob);
        techChannel.subscribe(carol);

        techChannel.uploadVideo("Observer Pattern in Java");
        techChannel.uploadVideo("Design Patterns Crash Course");

        techChannel.unsubscribe(bob);
        techChannel.uploadVideo("Multithreading in Java");
    }
}
