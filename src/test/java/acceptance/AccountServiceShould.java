package acceptance;

import bankaccount.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {
    @Mock
    Console console;

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
        CustomClock customclock = new CustomClock();
        TransactionRepository transactionRepository = new TransactionRepository(customclock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        AccountService accountService = new AccountService(transactionRepository, statementPrinter);

        //When
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);

        //Arrange
        String expectedPrintedOutput = " Date || Amount || Balance\n" +
                                       " 14/01/2012 || -500 || 2500\n" +
                                       " 13/01/2012 || 2000 || 3000\n" +
                                       " 10/01/2012 || 1000 || 1000";
//        assertEquals(expectedPrintedOutput, accountService.printStatement());
        verify(console, times(1)).printLine(" Date || Amount || Balance\n");
        verify(console, times(1)).printLine(" 14/01/2012 || -500 || 2500\n");
        verify(console, times(1)).printLine(" 13/01/2012 || 2000 || 3000\n");
        verify(console, times(1)).printLine(" 10/01/2012 || 1000 || 1000");
    }

}
