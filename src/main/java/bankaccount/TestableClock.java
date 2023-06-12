package bankaccount;

import java.time.LocalDate;

public class TestableClock extends CustomClock {
    @Override
    protected LocalDate getNow() {
        return LocalDate.of(2023,05,02);
    }
}
