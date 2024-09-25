package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStatus extends JFrame{
    
    Choice roomNumberChoice;
    JTextField nameField, genderField, customerIdField, depositField, toBePaidField, depositRemainingField;
    JButton checkButton, updateButton, backButton;
    
    UpdateStatus() {
        
        super("Update Status");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setBounds(300, 100, 1000, 500);
        
        JLabel updatestatusLabel = new JLabel("Update Status");
        updatestatusLabel.setBounds(100, 30, 200, 30);
        updatestatusLabel.setFont(new Font("Algerian", Font.BOLD, 20));
        add(updatestatusLabel);
        
        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(30, 80, 100, 30);
        roomNumberLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(roomNumberLabel);
        
        roomNumberChoice = new Choice();
        roomNumberChoice.setBounds(200, 80, 200, 30);
        roomNumberChoice.setBackground(Color.WHITE);
        roomNumberChoice.addKeyListener(new enterButton());
        add(roomNumberChoice);
        
        try {
            ConnectionWithSQL connection = new ConnectionWithSQL();
            String query = "select * from customer_information";
            ResultSet resultSet = connection.s.executeQuery(query);
            
            while (resultSet.next()) {
                roomNumberChoice.add(resultSet.getString("Room_Number"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 120, 100, 30);
        nameLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(200, 120, 200, 30);
        nameField.setFont(new Font("Cambria", Font.PLAIN, 14));
        nameField.setEditable(false);
        add(nameField);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(30, 160, 100, 30);
        genderLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(genderLabel);
        
        genderField = new JTextField();
        genderField.setBounds(200, 160, 200, 30);
        genderField.setFont(new Font("Cambria", Font.PLAIN, 14));
        genderField.setEditable(false);
        add(genderField);
        
        JLabel customerIdLabel = new JLabel("Customer Id");
        customerIdLabel.setBounds(30, 200, 100, 30);
        customerIdLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerIdLabel);
        
        customerIdField = new JTextField();
        customerIdField.setBounds(200, 200, 200, 30);
        customerIdField.setFont(new Font("Cambria", Font.PLAIN, 14));
        customerIdField.setEditable(false);
        add(customerIdField);
        
        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(30, 240, 100, 30);
        depositLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(depositLabel);
        
        depositField = new JTextField();
        depositField.setBounds(200, 240, 200, 30);
        depositField.setFont(new Font("Cambria", Font.PLAIN, 14));
        depositField.setEditable(false);
        add(depositField);

        JLabel toBePaidLabel = new JLabel("To Be Paid");
        toBePaidLabel.setBounds(30, 280, 100, 30);
        toBePaidLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(toBePaidLabel);
        
        toBePaidField = new JTextField();
        toBePaidField.setBounds(200, 280, 200, 30);
        toBePaidField.setFont(new Font("Cambria", Font.PLAIN, 14));
        toBePaidField.setEditable(false);
        add(toBePaidField);
        
        JLabel depositRemainingLabel = new JLabel("Deposit Remaining");
        depositRemainingLabel.setBounds(30, 320, 150, 30);
        depositRemainingLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(depositRemainingLabel);
        
        depositRemainingField = new JTextField();
        depositRemainingField.setBounds(200, 320, 200, 30);
        depositRemainingField.setFont(new Font("Cambria", Font.PLAIN, 14));
        depositRemainingField.setEditable(false);
        add(depositRemainingField);
        
        checkButton = new JButton("Check");
        checkButton.setBounds(60, 380, 100, 30);
        checkButton.setBackground(Color.BLACK);
        checkButton.setForeground(Color.WHITE);
        checkButton.setFont(new Font("Cambira", Font.BOLD, 14));
        checkButton.addActionListener(new ListenerForCheckUpdateBackButtons());
        checkButton.addKeyListener(new enterButton());
        add(checkButton);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(180, 380, 100, 30);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Cambira", Font.BOLD, 14));
        updateButton.addActionListener(new ListenerForCheckUpdateBackButtons());
        add(updateButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(300, 380, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Cambira", Font.BOLD, 14));
        backButton.addActionListener(new ListenerForCheckUpdateBackButtons());
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 80, 400, 300);
        add(image);
        
        setVisible(true);
    }
    
    private class ListenerForCheckUpdateBackButtons implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == checkButton) {
                String roomNumber = roomNumberChoice.getSelectedItem();
                double deposit, amountToBePaid;
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query1 = "select * from customer_information where Room_Number = '" +roomNumber+ "'";
                    ResultSet resultSet1 = connection.s.executeQuery(query1);
                    
                    while (resultSet1.next()) {
                        nameField.setText(resultSet1.getString("Customer_Name"));
                        genderField.setText(resultSet1.getString("Gender"));
                        customerIdField.setText(resultSet1.getString("Customer_ID"));
                        depositField.setText(resultSet1.getString("Deposit"));
                    }
                    
                    deposit = Double.parseDouble(depositField.getText());
                    String query2 = "select * from room_tables where room_Number = '" + roomNumber + "'";
                    ResultSet resultSet2 = connection.s.executeQuery(query2);
                    
                    while (resultSet2.next()) {
                        toBePaidField.setText(resultSet2.getString("price"));
                        amountToBePaid = Double.parseDouble(resultSet2.getString("price"));
                        depositRemainingField.setText("" + (deposit - amountToBePaid));
                    }    
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == updateButton) {
                String roomNumber = roomNumberChoice.getSelectedItem();
                String deposit = depositRemainingField.getText();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query3 = "update customer_information set Deposit = '" + deposit + "' where Room_Number = '" + roomNumber +"'";
                    connection.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    
                    setVisible(false);
                    new Reception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }else if(ae.getSource() == backButton) {
                setVisible(false);
                new Reception();
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
                String roomNumber = roomNumberChoice.getSelectedItem();
                String deposit = depositRemainingField.getText();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query3 = "update customer_information set Deposit = '" + deposit + "' where Room_Number = '" + roomNumber +"'";
                    connection.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    
                    setVisible(false);
                    new Reception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
    
    public static void main(String[] args) {
        new UpdateStatus();
    }
}
