import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import g1.domain.Account;

class AccountTest {

    private Account account;


   @BeforeEach void setUp(){
        account = new Account("felix", "12345678", true);
        
   }

   


    @Test void AccountShouldReturnUsername(){
        
        //Act
        String username = account.getUsername();
        //Assert

        assertEquals("felix", username);   
        assertNotNull(username); 

    }


    @Test void AccountShouldReturnPassword(){

        String password = account.getPassword(); 

        assertEquals("12345678", password);
        assertNotNull(password);
    }

    @Test void AccountShouldReturnAdminAccess(){

        boolean adminAccess = account.getAccess();

        assertEquals(true, adminAccess);
        assertNotNull(adminAccess);

    }

 
}
