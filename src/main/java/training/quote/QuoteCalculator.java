package training.quote;
import java.math.BigDecimal;
public final class QuoteCalculator {
    public Quote calculate(BigDecimal original, boolean member) {
        if (original.signum() == 0) {
            BigDecimal zero = Money.amount("0.00");
            return new Quote(original, zero, zero, zero, zero, zero);
        }
        BigDecimal memberPrice = Money.memberPrice(original, member);
        BigDecimal promotion = Money.amount("0.00");
        BigDecimal goods = memberPrice.subtract(promotion);
        BigDecimal shipping = Money.amount("10.00");
        if (member) {
            BigDecimal memberTotal = goods.add(shipping);
            return new Quote(original, memberPrice, promotion, goods, shipping, memberTotal);
        }
        BigDecimal standardTotal = goods.add(shipping);
        return new Quote(original, memberPrice, promotion, goods, shipping, standardTotal);
    }
}
