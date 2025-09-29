package src.adapter;

import src.power.ThreePinSocket;
import src.target.TwoPinPlug;

// Adapter makes a 2-pin plug fit into a 3-pin socket
public class TravelAdapter implements TwoPinPlug {

    private ThreePinSocket socket;

    public TravelAdapter(ThreePinSocket socket) {
        this.socket = socket;
    }

    @Override
    public void connect() {
        System.out.println(" Inserting 2-pin plug into travel adapter...");
        socket.provideElectricity();
        System.out.println(" Laptop is charging safely using adapter.");
    }
}
