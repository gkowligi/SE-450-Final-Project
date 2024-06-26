package edu.depaul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAuthenticationSystem {
    private List<User> userList;
    private static final String USERS_FILE_PATH = "src/edu/depaul/users.txt";

    public UserAuthenticationSystem() {
        userList = new ArrayList<>();
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    userList.add(new User(username, password));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data from file: " + e.getMessage());
        }
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }

    public void addUser(String username, String password) {
        String userToAdd = '\n' + username + ',' + password;
        try (FileWriter fw = new FileWriter(USERS_FILE_PATH, true)) {
            fw.write(userToAdd);
            System.out.println("New User added successfully!");
        } catch (IOException e) {
            System.err.println("Error adding new user to the file: " + e.getMessage());
        }
    }
}
