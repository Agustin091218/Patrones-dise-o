package strategy;

public class Main {
    public static void main(String[] args) {
        Cart myCart = new Cart();
        
        // aplicamos descuento
        System.out.println("Precios con descuentos");
        myCart.setStrategy(new ChristmasDiscount());
        myCart.makePayment(11231);
        
        // cambiamos el comportamiento
        System.out.println("Dia normal");
        myCart.setStrategy(new NoDiscount());
        myCart.makePayment(1500);
    }
}
