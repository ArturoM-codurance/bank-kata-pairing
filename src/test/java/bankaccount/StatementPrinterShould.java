package bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

    @Mock
    Console console;

    @Test
    void always_print_the_header(){
        //Arrange
        StatementPrinter statementPrinter = new StatementPrinter(console);
        List<Transaction> transactions = List.of();
        //Act
        statementPrinter.print(transactions);

        //Assert
        verify(console, times(1)).printLine(" Date || Amount || Balance");
    }

    @Test
    void print_transactions_in_chronological_order(){
        //Arrange
        StatementPrinter statementPrinter = new StatementPrinter(console);
        Transaction firstDeposit = new Transaction("10/01/2012", 1000);
        Transaction secondDeposit = new Transaction("13/01/2012", 2000);
        Transaction withdraw = new Transaction("14/01/2012", -500);
        List<Transaction> transactions = List.of(firstDeposit, secondDeposit, withdraw);
        //Act
        statementPrinter.print(transactions);

        //Assert
        InOrder inOrder = inOrder(console);
        inOrder.verify(console, times(1)).printLine(" Date || Amount || Balance");
        inOrder.verify(console, times(1)).printLine(" 14/01/2012 || -500 || 2500");
        inOrder.verify(console, times(1)).printLine(" 13/01/2012 || 2000 || 3000");
        inOrder.verify(console, times(1)).printLine(" 10/01/2012 || 1000 || 1000");
    }

}