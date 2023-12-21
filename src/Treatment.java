import java.time.LocalDate;
import java.util.Date;

public class Treatment {
    private String description;
    private LocalDate date;

    public Treatment(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return description + " (Treatment Date: " + date.toString() + ")";
    }
}
