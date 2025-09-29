package src.subject;

import src.observer.ChannelObserver;

public interface ChannelSubject {

    void subscribe(ChannelObserver subscriber);

    void unsubscribe(ChannelObserver subscriber);

    void notifyAllSubscribers(String videoTitle);
}
