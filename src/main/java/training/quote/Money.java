package training.quote;
import java.math.BigDecimal;
import java.math.RoundingMode;
public final class Money {
    private Money() {}
    public static BigDecimal amount(String value) {
        return new BigDecimal(value).setScale(2, RoundingMode.UNNECESSARY);
    }
    public static BigDecimal memberPrice(BigDecimal original, boolean member) {
        return member ? original.multiply(new BigDecimal("0.8")).setScale(2, RoundingMode.HALF_UP) : original;
    }
}
