package bankaccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomClock {

    public String dateAsString() {
        LocalDate now = getNow();
        return now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate getNow() {
        return LocalDate.now();
    }
}
