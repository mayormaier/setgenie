package setgenie.controller;

import setgenie.model.UserList;
import setgenie.view.LoginUI;
import setgenie.model.User;
import setgenie.controller.ElementListCtl;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginCtl implements ActionListener, DocumentListener {
    private UserList currentUserList;
    private LoginUI loginUI;

    public LoginCtl() {
        currentUserList = new UserList();
        loginUI = new LoginUI();
        loginUI.setVisible(true);
        addLoginListener();
        addFieldListeners();
        validateFields();
    }
    public UserList getUserList(){
        return currentUserList;
    }

    public void validateFields(){
        if (loginUI.usernameField.getText().length() > 0 && loginUI.passwordField.getText().length() > 0){
            loginUI.logInButton.setEnabled(true);
            loginUI.createUserButton.setEnabled(true);
        } else {
            loginUI.logInButton.setEnabled(false);
            loginUI.logInButton.setEnabled(false);
        }
    }

    // adds listeners to enable buttons
    private void addLoginListener(){
        this.loginUI.logInButton.addActionListener(this);
        this.loginUI.createUserButton.addActionListener(this);
    }

    // adds listeners to enable/disable buttons based on form input
    private void addFieldListeners(){
        this.loginUI.passwordField.getDocument().addDocumentListener(this);
        this.loginUI.usernameField.getDocument().addDocumentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //checks if the user exists, if so log in
        if (e.getSource().equals(loginUI.logInButton)){
            String username = loginUI.usernameField.getText();
            String password = loginUI.passwordField.getText();
            System.out.println("username: " + username);
            System.out.println("password: " + password);

            for (User u : currentUserList.getUserList()){
                if (u.getUsername().equals(username) && u.getUserPassword().equals(password)){
                    System.out.println("login success: " + username + " is logged in.");
                    loginUI.dispose();
                    ElementListCtl listCtl = new ElementListCtl(u.getUsername());
                } else {
                    loginUI.setError("Login Failure. Please try again.");
                }
            }
        }
        // creates a new user
        if (e.getSource().equals(loginUI.createUserButton)){
            String username = loginUI.usernameField.getText();
            String password = loginUI.passwordField.getText();

            User toBeCreated = new User(null, null, null, password, username);
            try{
                currentUserList.add(toBeCreated);
                System.out.println("user created: " + username);
                System.out.println("login success: " + username + " is logged in.");
                loginUI.dispose();
                ElementListCtl listCtl = new ElementListCtl(toBeCreated.getUsername());
            } catch (RuntimeException ex){
                loginUI.setError(ex.getMessage());
            }
        }


    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.validateFields();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.validateFields();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.validateFields();
    }
}
