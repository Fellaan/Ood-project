package g1.application;
import java.util.ArrayList;

import g1.domain.Account;

import g1.infrastructure.AccountRepository;

public class AccountService {
AccountRepository repo;
String username;
String password;
ArrayList<Account> accounts = new ArrayList<Account>();





public AccountService(AccountRepository repo){
    this.repo = repo;

    Account account = new Account("admin", "admin", true);

    accounts.add(account);

    Account account1 = new Account("user", "user", false);

    accounts.add(account1);





}

public boolean login(String user, String pass){


    for(Account acc : accounts){
        
        
            if (acc.getUsername().equals(user) && acc.getPassword().equals(pass)) {
                
                        return true;
                    }
            }
    return false;
}

public boolean accessAuth(String user){
    for(Account acc : accounts){
        if (acc.getUsername().equals(user)){
            return acc.getAccess();
        }
    }
return false;
}










}
