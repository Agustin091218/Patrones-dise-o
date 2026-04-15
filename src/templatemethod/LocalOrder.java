package templatemethod;

public class LocalOrder extends OrderProcessor {
    @Override
    protected void makePayment() {
        System.out.println("Pago realizado en efectivo");
    }
    
    @Override 
    protected void deliver() {
        System.out.println("Producto entregado en la tienda");
    }
}
