package training.quote;
public final class QuotePrinter {
    public String format(Quote quote) {
        String text = "Order quote\n"
                + "original=" + quote.original() + "\n"
                + "member_price=" + quote.memberPrice() + "\n"
                + "promotion=" + quote.promotion() + "\n"
                + "goods=" + quote.goods() + "\n"
                + "shipping=" + quote.shipping() + "\n"
                + "total=" + quote.total() + "\n";
        return text;
    }
}
