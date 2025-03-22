package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.Breakfast;
import gui.Lunch;
import gui.Dinner;
import model.UserCredentials;
import model.userDataFile;

public class userDataFile {
 
    // File path to store username and password
    private static final String fileName = "user_data.txt";
 
    // Method to store user credentials to a file
    public static void saveUserCredentials(UserCredentials userCredentials) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Write the username and password to the file separated by a comma
            writer.write(userCredentials.getUsername() + "," + userCredentials.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    // Method to retrieve user credentials from a file
    public static UserCredentials getUserCredentials(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into username and password using the comma separator
                String[] credentials = line.split(",");
                if (credentials[0].equals(username)) {
                    return new UserCredentials(credentials[0], credentials[1]);
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }
}
