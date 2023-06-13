package bankaccount;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class StatementPrinterShould {

    @Test
    void always_print_the_header(){
        //Arrange
        Console console = mock(Console.class);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        List<Transaction> transactions = List.of();
        //Act
        statementPrinter.print(transactions);

        //Assert
        verify(console, times(1)).printLine(" Date || Amount || Balance\n");
    }
    @Test
    void print_one_transaction(){
        //Arrange
        Console console = mock(Console.class);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        List<Transaction> transactions = List.of();
        //Act
        statementPrinter.print(transactions);

        //Assert
        inOrder()
        verify(console, times(1)).printLine(" Date || Amount || Balance\n");
    }

}