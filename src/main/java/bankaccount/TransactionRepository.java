package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions;
    private CustomClock customclock;

    public TransactionRepository(CustomClock customclock) {
        this.customclock = customclock;
        this.transactions = new ArrayList<>();
    }

    public void store(int amount) {
        Transaction transactionToStore = new Transaction(customclock.dateAsString(), amount);
        transactions.add(transactionToStore);
    }

    public List<Transaction> allTransactions() {
        return transactions;
    }
}
