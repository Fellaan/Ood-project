package g1.application;
import g1.infrastructure.AccountRepository;

public class AccountService {
AccountRepository repo;





public AccountService(AccountRepository repo){
    this.repo = repo;
}
}
