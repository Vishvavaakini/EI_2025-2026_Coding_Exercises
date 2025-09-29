package src.observer;

public class UserSubscriber implements ChannelObserver {

    private String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println(name + " received notification: '"
                + videoTitle + "' uploaded on " + channelName);
    }

    public String getName() {
        return name;
    }
}
