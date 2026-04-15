package Facade;

public class FacadeCine {
    private Lights lights;
    private Sound sound;
    private Projector projector;
    
    public FacadeCine() {
        this.lights = new Lights();
        this.sound = new Sound();
        this.projector = new Projector();
    }
    
    public void showMovie() {
        System.out.println("Preparando la pelicula");
        lights.attenuate(10);
        projector.turnOn();
        projector.movieMode();
        sound.turnOn();
        sound.setVolume(50);
    }
}
