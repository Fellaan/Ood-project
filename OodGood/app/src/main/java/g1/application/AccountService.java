package g1.application;

import g1.domain.Account;
import g1.infrastructure.AccountRepository;

public class AccountService {
AccountRepository repo;
String username;
String password;
Account account;


public AccountService(AccountRepository repo){
    this.repo = repo;
}

public boolean login(String user, String pass){


    try {
          account = repo.findByName(user);
   return pass.equals(account.getPassword());
        
    } catch (Exception e) {
        return false;
    }
    
}

public boolean accessAuth(String user){
    account = repo.findByName(user);
    return account.getAccess();
}

public boolean checkUsername(String name){
    return repo.findByName(name) != null;

}

public void createAccount(AccountRecord rec){

repo.add(new Account(rec.username(), rec.password(), rec.adminAccess()));
try {
    repo.save();
    
} catch (Exception e) {
    System.out.println(e);
}
    
}

public void removeAccount(String user){

    account = repo.findByName(user);

    repo.remove(account);

    try {
    repo.save();
    
} catch (Exception e) {
    System.out.println(e);
}
    

}



}










