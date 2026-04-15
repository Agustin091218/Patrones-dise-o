package templatemethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Procesando pedido online");
        OrderProcessor online = new OnlineOrder();
        online.process();
        
        System.out.println("Procesando pedido en el local");
        OrderProcessor local = new LocalOrder();
        local.process();
    }
}
