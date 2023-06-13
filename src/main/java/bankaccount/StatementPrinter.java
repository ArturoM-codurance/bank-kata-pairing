package bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinter {
    private static final String STATEMENT_HEADER = " Date || Amount || Balance";
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);

        int runningBalance = 0;
        List<String> statements = new ArrayList<>();
        for (Transaction transaction : transactions) {
            statements.add(transaction.formattedToPrint() + " " + (runningBalance+=transaction.amount()) + "");
        }
        Collections.reverse(statements);
        for (String statement : statements) {
            console.printLine(statement);
        }

    }
}
