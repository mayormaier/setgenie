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
        // Get an instance of the current UserList class
        currentUserList = new UserList();
        // userList = currentUserList.getUserList();
        // put up theLoginUI window...
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
        } else {
            loginUI.logInButton.setEnabled(false);
        }
    }

    private void addLoginListener(){
        this.loginUI.logInButton.addActionListener(this);
        this.loginUI.createUserButton.addActionListener(this);
    }

    private void addFieldListeners(){
        this.loginUI.passwordField.getDocument().addDocumentListener(this);
        this.loginUI.usernameField.getDocument().addDocumentListener(this);
    }

    //checks if the user exists, if so log in
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginUI.logInButton)){
            String username = loginUI.usernameField.getText();
            String password = loginUI.passwordField.getText();
            System.out.println("username: " + username);
            System.out.println("password: " + password);

            for (User u : currentUserList.getUserList()){
                if (u.getUsername().equals(username) && u.getUserPassword().equals(password)){
                    System.out.println("login success: " + username + " is logged in.");
                    loginUI.dispose();
                    ElementListCtl listCtl = new ElementListCtl();
                } else {
                    loginUI.setError("Login Failure. Please try again.");
                }
            }
        }
        if (e.getSource().equals(loginUI.createUserButton)){
            String username = loginUI.usernameField.getText();
            String password = loginUI.passwordField.getText();

            currentUserList.add(new User(null, null, null, password, username));
            System.out.println("login success: " + username + " is logged in.");
            loginUI.dispose();
            ElementListCtl listCtl = new ElementListCtl();
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
