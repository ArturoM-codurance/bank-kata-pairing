package bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceShould {

    @Test
    void store_transactions(){
        //Arrange
        int amountToStore = 100;
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        AccountService accountService = new AccountService(transactionRepository);

        //Act
        accountService.deposit(amountToStore);

        //Assert
        verify(transactionRepository, times(1)).store(amountToStore);
    }

}