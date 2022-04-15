package setgenie.view;

import javax.swing.*;

public class LoginUI extends JFrame{
    private JPanel panel1;
    public JTextField usernameField;
    public JTextField passwordField;
    public JButton logInButton;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passLabel;
    private JLabel loginStatus;
    public JButton createUserButton;

    public LoginUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 300);
        add(panel1);
    }

    public void setError(String m){
        loginStatus.setText(m);
    }

}
