// SignUpPage.java
package Hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage {
    private JFrame frame;
    private Index index; // Reference to the Index class

    // Constructor to initialize the reference to the Index class
    public SignUpPage(Index index) {
        this.index = index;
    }

    public void createAndShowGUI() {
        frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(9, 2));

        // Form fields
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        JTextField mobileNumberField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        // Labels
        frame.add(new JLabel("Name:"));
        frame.add(nameField);

        frame.add(new JLabel("Age:"));
        frame.add(ageField);

        frame.add(new JLabel("Gender:"));
        frame.add(genderComboBox);

        frame.add(new JLabel("Mobile Number:"));
        frame.add(mobileNumberField);

        frame.add(new JLabel("Email:"));
        frame.add(emailField);

        frame.add(new JLabel("Username:"));
        frame.add(usernameField);

        frame.add(new JLabel("Password:"));
        frame.add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            // Placeholder method, replace with your registration logic
            registerUser(
                    nameField.getText(),
                    ageField.getText(),
                    (String) genderComboBox.getSelectedItem(),
                    mobileNumberField.getText(),
                    emailField.getText(),
                    usernameField.getText(),
                    new String(passwordField.getPassword())
            );

            // Placeholder method, add logic for successful registration
            registrationSuccess();
        });

        frame.add(new JLabel()); // Empty label for spacing
        frame.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            closeRegistrationPage();
            openLoginForm();
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            closeRegistrationPage();
            index.openLandingPage(); // Call the method in the Index class to open the landing page
        });

        frame.add(loginButton);
        frame.add(backButton);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    // Placeholder method, replace with your registration logic
    private void registerUser(String name, String age, String gender, String mobileNumber, String email, String username, String password) {
        System.out.println("Registration logic goes here...");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    // Placeholder method, add logic for successful registration
    private void registrationSuccess() {
        JOptionPane.showMessageDialog(frame, "Registration successful!");
    }

    private void closeRegistrationPage() {
        frame.dispose();
    }

    private void openLoginForm() {
        // Placeholder method, replace with logic to open the login form
        System.out.println("Opening login form...");
    }
}
