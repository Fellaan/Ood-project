package g1.domain;

import java.io.Serializable;


public class Account implements Serializable {

    private String username;
    private String password;
    private boolean adminAccess;


    public Account(String username, String password, boolean adminAccess){
        this.username = username;
        this.password = password;
        this.adminAccess = adminAccess;

    }

    public String getUsername(){

        return username;
    }

    public String getPassword(){

        return password;
    }

    public boolean getAccess(){

        return adminAccess;
    }
}
