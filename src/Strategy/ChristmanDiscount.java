package Strategy;

public class ChristmanDiscount implements DiscountEstrategy {
    @Override
    public double apply(double price) {
        return price * 0.50;
    }
}