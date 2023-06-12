package bankaccount;

public class AccountService {

    private final TransactionRepository transactionRepository;

    public AccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amountToDeposit) {
        transactionRepository.store(amountToDeposit);
    }

    public void withdraw(int amountToWithdraw) {
        transactionRepository.store(-amountToWithdraw);
    }

    public String printStatement() {
        throw new UnsupportedOperationException();
    }
}
