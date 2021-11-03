import java.util.List;

public class Invoice {

    private final String customer;
    private final List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public int getTotalAmount() {
        return performances.stream().map(Performance::getAmount).reduce(0, Integer::sum);
    }

    public int getTotalVolumeCredits() {
        return performances.stream().map(Performance::getVolumeCredits).reduce(0, Integer::sum);
    }
}
