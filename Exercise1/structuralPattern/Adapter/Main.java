
import src.adapter.TravelAdapter;
import src.power.ThreePinSocket;
import src.target.TwoPinPlug;

public class Main {

    public static void main(String[] args) {
        // Local socket (3-pin wall socket)
        ThreePinSocket wallSocket = new ThreePinSocket();

        // Laptop charger has 2-pin plug
        TwoPinPlug laptopPlug = new TravelAdapter(wallSocket);

        // Connect laptop plug through adapter
        laptopPlug.connect();
    }
}
