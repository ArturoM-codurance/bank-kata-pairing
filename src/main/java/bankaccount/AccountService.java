package bankaccount;

public class AccountService {

    private final TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public AccountService(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amountToDeposit) {
        transactionRepository.store(amountToDeposit);
    }

    public void withdraw(int amountToWithdraw) {
        transactionRepository.store(-amountToWithdraw);
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.allTransactions());
    }
}
