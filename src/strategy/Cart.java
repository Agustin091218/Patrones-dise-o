package strategy;

public class Cart {
    private DiscountStrategy strategy;
    
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void makePayment(double amount) {
        double finalAmount = strategy.apply(amount);
        System.out.println("Precio sin descuento: $" + amount);
        System.out.println("Precio con descuento: $" + finalAmount);
    }
}