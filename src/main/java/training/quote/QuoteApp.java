package training.quote;
public final class QuoteApp {
    private static final String USAGE =
            "Use: QuoteApp price=50.00 is_member=true (is_member must be true or false)";

    public static void main(String[] args) {
        String price = null;
        String member = null;
        if (args.length != 2) {
            throw new IllegalArgumentException(USAGE);
        }
        for (String arg : args) {
            if (arg.startsWith("price=") && price == null) {
                price = arg.substring("price=".length());
            } else if (arg.startsWith("is_member=") && member == null) {
                member = arg.substring("is_member=".length());
            } else {
                throw new IllegalArgumentException(USAGE);
            }
        }
        if (price == null || price.isEmpty() || member == null
                || !(member.equals("true") || member.equals("false"))) {
            throw new IllegalArgumentException(USAGE);
        }
        var quote = new QuoteCalculator().calculate(Money.amount(price), Boolean.parseBoolean(member));
        System.out.print(new QuotePrinter().format(quote));
    }
}
