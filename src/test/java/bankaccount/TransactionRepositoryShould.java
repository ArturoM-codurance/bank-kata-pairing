package bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionRepositoryShould {

    @Test
    void create_and_store_a_deposit_transaction(){
        //Arrange
        CustomClock customClock = mock(CustomClock.class);
        when(customClock.dateAsString()).thenReturn("12/06/2023");
        Transaction transactionToStore = new Transaction("12/06/2023", 100);
        TransactionRepository transactionRepository = new TransactionRepository(customClock);
        //Act
        transactionRepository.store(100);
        //Assert
        assertTrue(transactionRepository.allTransactions().contains(transactionToStore));
        assertEquals(1, transactionRepository.allTransactions().size());
    }

}