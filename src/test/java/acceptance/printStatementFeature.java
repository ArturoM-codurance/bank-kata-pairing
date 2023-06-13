package acceptance;

import bankaccount.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class printStatementFeature {
    @Mock
    Console console;

    @Mock
    CustomClock customClock;

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
        TransactionRepository transactionRepository = new TransactionRepository(customClock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        AccountService accountService = new AccountService(transactionRepository, statementPrinter);
        when(customClock.dateAsString()).thenReturn("10/01/2012", "13/01/2012", "14/01/2012");

        //When
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);
        accountService.printStatement();

        //Arrange

        InOrder inOrder = inOrder(console);
        inOrder.verify(console, times(1)).printLine(" Date || Amount || Balance");
        inOrder.verify(console, times(1)).printLine(" 14/01/2012 || -500 || 2500");
        inOrder.verify(console, times(1)).printLine(" 13/01/2012 || 2000 || 3000");
        inOrder.verify(console, times(1)).printLine(" 10/01/2012 || 1000 || 1000");
    }

}
