package Facade;


public class Sound {
    
    public void turnOn() {
        System.out.println("Sonido encendido");
    }
    
    public void setVolume(int vol) {
        System.out.println("Volumen en " + vol);
    }
}
