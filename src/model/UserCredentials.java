package model;
import gui.Breakfast;
import gui.Lunch;
import gui.Dinner;
import model.UserCredentials;
import model.userDataFile;

// This file will store the usernames and passwords

public class UserCredentials {
    private String username;
    private String password;

    public UserCredentials(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    } 

    public String getPassword(){
        return password;
    }


}
