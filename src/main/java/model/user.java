package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class user implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    public user() {
    	
    }
    public user(int id,String username, String password, String email) {
    	this.id=id;
    	this.email=email;
    	this.password=password;
    	this.username=username;
    }

    // getter & setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
