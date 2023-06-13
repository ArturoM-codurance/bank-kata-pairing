package bankaccount;

import java.util.List;

public class StatementPrinter {
    private static final String STATEMENT_HEADER = " Date || Amount || Balance\n";
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
    }
}
