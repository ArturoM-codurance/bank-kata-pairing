package bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomClockShould {

    @Test
    void return_todays_date_as_a_string(){
        //Arrange
        CustomClock customClock = new TestableClock();

        //Act
        String receivedDate = customClock.dateAsString();

        //Assert
        assertEquals("02/05/2023", receivedDate);
    }

}