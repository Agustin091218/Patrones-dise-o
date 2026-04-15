package Strategy;

public class NoDiscount implements DiscountEstrategy {
    @Override
    public double apply(double price) {
        return price;
    }
}