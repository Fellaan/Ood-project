package g1.infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import g1.application.LoadErrorException;
import g1.application.Repository;
import g1.application.SaveErrorException;
import g1.domain.Account;

public class AccountRepository implements Repository<Account>, Serializable {
    private ArrayList<Account> accounts;

    String filename = "accounts";

    @Override
    public void save() throws IOException, SaveErrorException {
        
        try (FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(accounts);   // write the entire list
            out.close();
            fileOut.close();
    } catch (IOException e) {
        throw new SaveErrorException("Failed to save to file.");
    }
}

    @SuppressWarnings("unchecked")
    @Override
    public void loadFromFile() throws IOException, ClassNotFoundException, LoadErrorException, SaveErrorException {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("No file found, creating default admin account");
            accounts = new ArrayList<>();
            accounts.add(new Account("admin", "admin", true));
        // IMPORTANT: save the newly created admin account list
            save();
        return;}

        try (FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            accounts = (ArrayList<Account>) in.readObject();}
}

    @Override
    public Account findByName(String name){
        return accounts.stream()
                .filter(a -> a.getUsername()
                .equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ArrayList<Account> findAll(){
        return accounts;
    }

    @Override
    public void add(Account account){
        accounts.add(account);
    }

    public void remove(Account account){
        accounts.remove(account);
    }
}