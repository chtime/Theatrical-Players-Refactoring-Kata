import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public String print(Invoice invoice) {
        final StringBuilder builder = new StringBuilder();

        int totalAmount = invoice.getTotalAmount();
        int volumeCredits = invoice.getTotalVolumeCredits();

        builder.append(String.format("Statement for %s\n", invoice.getCustomer()));
        invoice.getPerformances().forEach((perf) -> builder.append(formatPerformance(perf)));
        builder.append(String.format("Amount owed is %s\n", numberFormat.format(totalAmount / 100)));
        builder.append(String.format("You earned %s credits\n", volumeCredits));

        return builder.toString();
    }

    private String formatPerformance(Performance perf) {
        int performanceAmount = perf.getAmount();
        int performanceAudience = perf.getAudienceSize();
        String playName = perf.getPlayName();
        return String.format("  %s: %s (%s seats)\n", playName, numberFormat.format(performanceAmount / 100), performanceAudience);
    }

}
