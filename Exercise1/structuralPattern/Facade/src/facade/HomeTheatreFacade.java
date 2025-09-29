package src.facade;

import src.subsystem.*;

public class HomeTheatreFacade {

    private Amplifier amp;
    private DvdPlayer dvd;
    private Projector projector;
    private TheaterLights lights;
    private PopcornPopper popper;

    public HomeTheatreFacade(Amplifier amp, DvdPlayer dvd, Projector projector,
            TheaterLights lights, PopcornPopper popper) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting movie theatre down...");
        popper.off();
        lights.on();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.off();
    }
}
