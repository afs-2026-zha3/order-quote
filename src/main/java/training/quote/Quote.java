package training.quote;
import java.math.BigDecimal;
public record Quote(BigDecimal original, BigDecimal memberPrice, BigDecimal promotion,
                    BigDecimal goods, BigDecimal shipping, BigDecimal total) {}
