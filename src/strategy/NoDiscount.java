package strategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double apply(double price) {
        return price;
    }
}