package acceptance;

import bankaccount.AccountService;
import bankaccount.TransactionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceShould {
    /**
     *
     * public interface AccountService
     * {
     *     void deposit(int amount)
     *     void withdraw(int amount)
     *     void printStatement()
     * }
     *
     * Given a client makes a deposit of 1000 on 10-01-2012
     * And a deposit of 2000 on 13-01-2012
     * And a withdrawal of 500 on 14-01-2012
     * When they print their bank statement
     * Then they would see:
     *
     * Date       || Amount || Balance
     * 14/01/2012 || -500   || 2500
     * 13/01/2012 || 2000   || 3000
     * 10/01/2012 || 1000   || 1000
     */

    @Test
    void print_the_information_of_the_movements_of_the_account(){
        //Given
        TransactionRepository transactionRepository = new TransactionRepository();
        AccountService accountService = new AccountService(transactionRepository);

        //When
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);

        //Arrange
        String expectedPrintedOutput = " Date || Amount || Balance\n" +
                                       " 14/01/2012 || -500 || 2500\n" +
                                       " 13/01/2012 || 2000 || 3000\n" +
                                       " 10/01/2012 || 1000 || 1000";
        assertEquals(expectedPrintedOutput, accountService.printStatement());
    }

}
