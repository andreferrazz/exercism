import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay().plusSeconds((int) Math.pow(10, 9));
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds((int) Math.pow(10, 9));
    }

    public LocalDateTime getDateTime() {
        return this.moment;
    }
}
