package src.subject;

import src.observer.ChannelObserver;
import src.observer.UserSubscriber;
import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements ChannelSubject {

    private String name;
    private List<ChannelObserver> subscribers = new ArrayList<>();
    private List<String> videos = new ArrayList<>();

    public YouTubeChannel(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(ChannelObserver subscriber) {
        subscribers.add(subscriber);
        if (subscriber instanceof UserSubscriber) {
            System.out.println(((UserSubscriber) subscriber).getName()
                    + " subscribed to " + name);
        }
    }

    @Override
    public void unsubscribe(ChannelObserver subscriber) {
        subscribers.remove(subscriber);
        if (subscriber instanceof UserSubscriber) {
            System.out.println(((UserSubscriber) subscriber).getName()
                    + " unsubscribed from " + name);
        }
    }

    public void uploadVideo(String videoTitle) {
        videos.add(videoTitle);
        System.out.println("\n" + name + " uploaded a new video: " + videoTitle);
        notifyAllSubscribers(videoTitle);
    }

    @Override
    public void notifyAllSubscribers(String videoTitle) {
        for (ChannelObserver sub : subscribers) {
            sub.update(name, videoTitle);
        }
    }
}
