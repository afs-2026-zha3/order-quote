package training.quote;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BasicsTest {
    @Test void emptyOrderHasNoCharge() {
        for (boolean member : new boolean[]{false, true}) {
            var quote = new QuoteCalculator().calculate(Money.amount("0.00"), member);
            assertEquals(Money.amount("0.00"), quote.total());
        }
    }
    @Test void memberPriceRoundsOnce() {
        var quote = new QuoteCalculator().calculate(Money.amount("100.01"), true);
        assertEquals(Money.amount("80.01"), quote.memberPrice());
    }
    @Test void displayedTotalMatchesCalculation() {
        var quote = new QuoteCalculator().calculate(Money.amount("50.00"), false);
        assertEquals(quote.goods().add(quote.shipping()), quote.total());
        assertTrue(new QuotePrinter().format(quote).contains("total=" + quote.total() + "\n"));
    }
}
