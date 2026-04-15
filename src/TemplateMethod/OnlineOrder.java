package TemplateMethod;


public class OnlineOrder extends OrderProcessor {
    @Override
    protected void makePayment() {
        System.out.println("Pago realizado con tarjeta");
    }
    
    @Override
    protected void deliver() {
        System.out.println("Pedido enviado por correo");
    }
    
}
