package Strategy;

public class Main {
    public static void main(String[] args) {
        Cart myCart = new Cart();
        
        //aplicamos descuento
        System.out.println("Precios con descuentos");
        myCart.setEstrategy(new ChristmanDiscount());
        myCart.makePagment(11231);
        
        //cambiamos el comportamiento
        System.out.println("Dia normal");
        myCart.setEstrategy(new NoDiscount());
        myCart.makePagment(1500);
        
    }
}
