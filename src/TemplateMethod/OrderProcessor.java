package TemplateMethod;

public abstract class OrderProcessor {
    
    public final void process() {
        selectProducts();
        calculatePrice();
        makePayment();
        deliver();
    }
    
    
    //Pasos comunes
    private void selectProducts() {
        System.out.println("Productos seleccionados y agregados al carrito");
    }
    
    private void  calculatePrice() {
        System.out.println("Precio total calculado incluyendo impuestos");
    }
    
    //Cada sublclase los rellena a su manera
    protected abstract void makePayment();
    protected abstract void deliver();
}
