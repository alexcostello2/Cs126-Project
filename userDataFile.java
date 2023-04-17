import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class userDataFile {
 
    // File path to store user credentials
    private static final String CREDENTIALS_FILE_PATH = "user_data.txt";
 
    // Method to store user credentials to a file
    public static void saveUserCredentials(UserCredentials userCredentials) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CREDENTIALS_FILE_PATH, true))) {
            writer.write(userCredentials.getUsername() + "," + userCredentials.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    // Method to retrieve user credentials from a file
    public static UserCredentials getUserCredentials(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
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