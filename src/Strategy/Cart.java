package Strategy;

public class Cart {
    private DiscountEstrategy estrategy;
    
    public void setEstrategy( DiscountEstrategy estrategy) {
        this.estrategy = estrategy;
    }
    
    public void makePagment(double amount) {
        double finalAmount = estrategy.apply(amount);
        System.out.println("Precio sin descuento: $" + amount);
        System.out.println("Precio con descuento: $" + finalAmount);
    }
}