package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInformation extends JFrame{
    
    JTable customerInformationTable;
    JButton backButton, searchButton;
    JTextField nameField, roomField;
    
    CustomerInformation() {
        
        super("Customer Information");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setBounds(50, 50, 1400, 700);
        
        JLabel employeeInformationLabel = new JLabel("Customer Information");
        employeeInformationLabel.setBounds(100, 20, 200, 30);
        employeeInformationLabel.setFont(new Font("Algerian", Font.BOLD, 16));
        employeeInformationLabel.setForeground(Color.BLUE);
        add(employeeInformationLabel);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 50, 50, 30);
        nameLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(110, 50, 200, 25);
        nameField.setFont(new Font("Cambria", Font.BOLD, 12));
        nameField.addKeyListener(new enterButton());
        add(nameField);
        
        JLabel roomLabel = new JLabel("Room");
        roomLabel.setBounds(350, 50, 50, 25);
        roomLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(roomLabel);
        
        roomField = new JTextField();
        roomField.setBounds(410, 50, 80, 25);
        roomField.setFont(new Font("Cambria", Font.BOLD, 12));
        roomField.addKeyListener(new enterButton());
        add(roomField);
        
        JLabel customerIdLabel = new JLabel(" Customer ID");
        customerIdLabel.setBounds(10, 100, 100, 30);
        customerIdLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(customerIdLabel);
        
        JLabel idNumberLabel = new JLabel("ID Number");
        idNumberLabel.setBounds(135, 100, 100, 30);
        idNumberLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(idNumberLabel);
        
        JLabel customerNameLabel = new JLabel("Customer Name");
        customerNameLabel.setBounds(260, 100, 100, 30);
        customerNameLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(customerNameLabel);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(385, 100, 100, 30);
        genderLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(genderLabel);
        
        JLabel countryLabel = new JLabel("Country");
        countryLabel.setBounds(510, 100, 100, 30);
        countryLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(countryLabel);
        
        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(635, 100, 100, 30);
        roomNumberLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(roomNumberLabel);
        
        JLabel checkInTimeLabel = new JLabel("Checkin Time");
        checkInTimeLabel.setBounds(760, 100, 100, 30);
        checkInTimeLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(checkInTimeLabel);
        
        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(885, 100, 100, 30);
        depositLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(depositLabel);
        
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(1010, 100, 100, 30);
        phoneNumberLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(phoneNumberLabel);
        
        customerInformationTable = new JTable();
        customerInformationTable.setBounds(10, 130, 1100, 400);
        add(customerInformationTable); 
        
        try {
            ConnectionWithSQL connection = new ConnectionWithSQL();
            String query = "select * from customer_information";
            
            ResultSet resultSet = connection.s.executeQuery(query);
            customerInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        searchButton = new JButton("Search");
        searchButton.setBounds(200, 600, 100, 30);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(new ListenerForBackButton());
        add(searchButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(350, 600, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ListenerForBackButton());
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(1150, 200, 200, 200);
        add(image);
        
        
        setVisible(true);
        
    }
    
    private class ListenerForBackButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == searchButton) {
                String name = nameField.getText();
                String room = roomField.getText();
                
                try {
                   ConnectionWithSQL connection = new  ConnectionWithSQL();
                   ResultSet resultSet;
                   
                   String query1 = "select * from customer_information where Customer_Name LIKE '%" + name + "%'";
                   String query2 = "select * from customer_information where Room_Number = '" + room + "'";
                   String query3 = "select * from customer_information";
                   String query4 = "select * from customer_information where Customer_Name LIKE '%" + name + "%' AND Room_Number = '" + room + "'";
                   
                   if (room.equals("") && name.equals("")) {
                       resultSet = connection.s.executeQuery(query3);
                   }else if (name.equals("")) {
                       resultSet = connection.s.executeQuery(query2);
                   }else if (room.equals("")) {
                       resultSet = connection.s.executeQuery(query1);
                   } else {
                       resultSet = connection.s.executeQuery(query4);
                   }
                   
                   customerInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == backButton) {
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
                String name = nameField.getText();
                String room = roomField.getText();
                
                try {
                   ConnectionWithSQL connection = new  ConnectionWithSQL();
                   ResultSet resultSet;
                   
                   String query1 = "select * from customer_information where Customer_Name LIKE '%" + name + "%'";
                   String query2 = "select * from customer_information where Room_Number = '" + room + "'";
                   String query3 = "select * from customer_information";
                   String query4 = "select * from customer_information where Customer_Name LIKE '%" + name + "%' AND Room_Number = '" + room + "'";
                   
                   if (room.equals("") && name.equals("")) {
                       resultSet = connection.s.executeQuery(query3);
                   }else if (name.equals("")) {
                       resultSet = connection.s.executeQuery(query2);
                   }else if (room.equals("")) {
                       resultSet = connection.s.executeQuery(query1);
                   } else {
                       resultSet = connection.s.executeQuery(query4);
                   }
                   
                   customerInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
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
        new CustomerInformation();
    }
}
