
import src.facade.*;
import src.subsystem.*;

public class HomeTheatre {

    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        HomeTheatreFacade homeTheatre = new HomeTheatreFacade(amp, dvd, projector, lights, popper);

        homeTheatre.watchMovie("Inception");
        homeTheatre.endMovie();
    }
}
