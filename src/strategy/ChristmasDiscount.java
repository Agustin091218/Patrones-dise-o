package strategy;

public class ChristmasDiscount implements DiscountStrategy {
    @Override
    public double apply(double price) {
        return price * 0.50;
    }
}