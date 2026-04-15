package templatemethod;

public abstract class OrderProcessor {
    public final void process() {
        selectProducts();
        calculatePrice();
        makePayment();
        deliver();
    }
    
    private void selectProducts() {
        System.out.println("Productos seleccionados y agregados al carrito");
    }
    
    private void calculatePrice() {
        System.out.println("Precio total calculado incluyendo impuestos");
    }
    
    protected abstract void makePayment();
    protected abstract void deliver();
}
