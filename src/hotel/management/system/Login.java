package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    
    JLabel userPasswordLabel, userNameLabel;
    JTextField userNameField;
    JPasswordField userPasswordField;
    JButton loginButton, cancelButton;
    

    Login() {
        // setting up the content pane for the login page
        super("Manager Login");
        
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);

        setLayout(null);

        // setting up the username label and username field for the login page
        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(40, 20, 100, 30);
        userNameLabel.setForeground(Color.BLACK);
        add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(150, 20, 200, 30);
        userNameField.addKeyListener(new enterButton());
        add(userNameField);

        // setting up the userpassword label and field for the login page
        userPasswordLabel = new JLabel("Password");
        userPasswordLabel.setBounds(40, 70, 100, 30);
        userPasswordLabel.setForeground(Color.BLACK);
        add(userPasswordLabel);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(150, 70, 200, 30);
        userPasswordField.addKeyListener(new enterButton());
        add(userPasswordField);

        // setting up the login and cancel button for the login page
        loginButton = new JButton("Login");
        loginButton.setBounds(40, 150, 120, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new listenerForLoginandCancel());
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 150, 120, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(new listenerForLoginandCancel());
        add(cancelButton);

        // setting up the picture that will appear in the login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/newlogin.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel loginImage = new JLabel(i3);
        loginImage.setBounds(350, 30, 200, 200);
        add(loginImage);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }
    
    // creating response for the login and cancel buttons 
    private class listenerForLoginandCancel implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == loginButton) {
                try {
                    ConnectionWithSQL c = new ConnectionWithSQL();
                    // storing the values entered in the username and password field
                    String username = userNameField.getText();
                    String password = userPasswordField.getText();
                    
                    // creating the query that mysql will execute
                    String query = "select * from login where username = '" + username + "' and password = '"+password+"'";
                    
                    ResultSet rs = c.s.executeQuery(query);
                    
                    if (rs.next()) {
                        setVisible(false);
                        new DashBoard();
                    }else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                        setVisible(false);
                        new HotelManagementSystem();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == cancelButton) {
                setVisible(false);
                new HotelManagementSystem();
            }
        }
    }
    
    private class enterButton implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent ev) {
            if (ev.getKeyCode() == KeyEvent.VK_ENTER) { 
                try {
                    ConnectionWithSQL c = new ConnectionWithSQL();
                    // storing the values entered in the username and password field
                    String username = userNameField.getText();
                    String password = userPasswordField.getText();
                    
                    // creating the query that mysql will execute
                    String query = "select * from login where username = '" + username + "' and password = '"+password+"'";
                    
                    ResultSet rs = c.s.executeQuery(query);
                    
                    if (rs.next()) {
                        setVisible(false);
                        new DashBoard();
                    }else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                        setVisible(false);
                        new HotelManagementSystem();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }

    public static void main(String[] args) {
        new Login();
    }
}
