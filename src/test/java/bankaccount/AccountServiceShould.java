package bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AccountServiceShould {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private StatementPrinter statementPrinter;

    @Test
    void store_deposit_transactions(){
        //Arrange
        int amountToStore = 100;
        AccountService accountService = new AccountService(transactionRepository, statementPrinter);

        //Act
        accountService.deposit(amountToStore);

        //Assert
        verify(transactionRepository, times(1)).store(amountToStore);
    }

    @Test
    void store_withdraw_transactions(){
        int amountToWithdraw = 100;
        AccountService accountService = new AccountService(transactionRepository, statementPrinter);

        accountService.withdraw(100);

        verify(transactionRepository, times(1)).store(-amountToWithdraw);
    }

    @Test
    void print_the_statement(){
        //Arrange
        AccountService accountService = new AccountService(transactionRepository, statementPrinter);
        List<Transaction> transactions = List.of();
        when(transactionRepository.allTransactions()).thenReturn(transactions);
        //Act
        accountService.printStatement();

        //Assert
        verify(statementPrinter, times(1)).print(transactions);
    }

}