package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CustomerForm extends JFrame{
    
    JComboBox customerIdBox, customerGenderBox;
    JTextField customerIdNumberField, customerNameField, customerCountryField, customerDepositField, customerPhoneNumberField, checkinDateField;
    Choice roomNumberChoice;
    JButton addCustomerButton, backButton, checkButton;
    JComboBox bedTypeBox;
    
    CustomerForm() {
        
        super("Customer Form");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300, 100, 800, 650);
        
        JLabel customerFormHeading = new JLabel("New Customer Form");
        customerFormHeading.setFont(new Font("Algerian", Font.PLAIN, 20));
        customerFormHeading.setBounds(200, 30, 300, 30);
        add(customerFormHeading);
        
        JLabel customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setBounds(60, 80, 100, 30);
        customerIdLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerIdLabel);
        
        String[] customerIDTypeList = {"Government ID", "University ID", "Driving License", "Passport"};
        customerIdBox = new JComboBox(customerIDTypeList);
        customerIdBox.setBounds(200, 80, 200, 30);
        customerIdBox.setBackground(Color.WHITE);
        customerIdBox.addKeyListener(new enterButton());
        add(customerIdBox);
        
        JLabel customerIdNumberLabel = new JLabel("ID Number");
        customerIdNumberLabel.setBounds(60, 120, 100, 30);
        customerIdNumberLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerIdNumberLabel);
        
        customerIdNumberField = new JTextField();
        customerIdNumberField.setBounds(200, 120, 200, 30);
        customerIdNumberField.addKeyListener(new enterButton());
        add(customerIdNumberField);
        
        JLabel customerNameLabel = new JLabel("Customer Name");
        customerNameLabel.setBounds(60, 160, 150, 30);
        customerNameLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerNameLabel);
        
        customerNameField = new JTextField();
        customerNameField.setBounds(200, 160, 200, 30);
        customerNameField.addKeyListener(new enterButton());
        add(customerNameField);
        
        JLabel customerGenderField = new JLabel("Gender");
        customerGenderField.setBounds(60, 200, 100, 30);
        customerGenderField.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerGenderField);
        
        String[] genderList = {"Male", "Female"};
        customerGenderBox = new JComboBox(genderList);
        customerGenderBox.setBounds(200, 200, 200, 30);
        customerGenderBox.setBackground(Color.WHITE);
        customerGenderBox.addKeyListener(new enterButton());
        add(customerGenderBox);
        
        JLabel customerCountryLabel = new JLabel("Country");
        customerCountryLabel.setBounds(60, 240, 100, 30);
        customerCountryLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerCountryLabel);
        
        customerCountryField = new JTextField();
        customerCountryField.setBounds(200, 240, 200, 30);
        customerCountryField.addKeyListener(new enterButton());
        add(customerCountryField);
        
        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setBounds(60, 280, 100, 30);
        bedTypeLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(bedTypeLabel);
        
        String[] bedTypeList = {"Single Bed", "Double bed", "Family Room", "Sweet Room", "Presidential Room", "Connecting Room", "Disabled Room"};
        bedTypeBox = new JComboBox(bedTypeList);
        bedTypeBox.setBackground(Color.WHITE);
        bedTypeBox.setBounds(200, 280, 200, 30);
        bedTypeBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        bedTypeBox.addKeyListener(new enterButton());
        add(bedTypeBox);
        
        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(60, 320, 100, 30);
        roomNumberLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(roomNumberLabel);
        
        roomNumberChoice = new Choice();
        roomNumberChoice.setBounds(200, 320, 200, 30);
        roomNumberChoice.addKeyListener(new enterButton());
        add(roomNumberChoice);
        
        JLabel checkinTimeLable = new JLabel("Checkin Time");
        checkinTimeLable.setBounds(60, 360, 100, 30);
        checkinTimeLable.setFont(new Font("Cambria", Font.BOLD, 14));
        add(checkinTimeLable);
        
        Date localDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-dd");
        String checkinDate = formatDate.format(localDate);
        
        checkinDateField = new JTextField();
        checkinDateField.setText(checkinDate);
        checkinDateField.setBounds(200, 360, 220, 30);
        checkinDateField.setFont(new Font("Cambria", Font.BOLD, 14));
        checkinDateField.setEditable(false);
        checkinDateField.addKeyListener(new enterButton());
        add(checkinDateField);
        
        JLabel customerDepositLabel = new JLabel("Deposit");
        customerDepositLabel.setBounds(60, 400, 100, 30);
        customerDepositLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerDepositLabel);
        
        customerDepositField = new JTextField();
        customerDepositField.setBounds(200, 400, 200, 30);
        customerDepositField.addKeyListener(new enterButton());
        add(customerDepositField);
        
        JLabel customerPhoneNumberLabel = new JLabel("Phone Number");
        customerPhoneNumberLabel.setBounds(60, 440, 100, 30);
        customerPhoneNumberLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(customerPhoneNumberLabel);
        
        customerPhoneNumberField = new JTextField();
        customerPhoneNumberField.setBounds(200, 440, 200, 30);
        customerPhoneNumberField.addKeyListener(new enterButton());
        add(customerPhoneNumberField);
        
        checkButton = new JButton("Check");
        checkButton.setBackground(Color.BLACK);
        checkButton.setForeground(Color.WHITE);
        checkButton.setBounds(60, 500, 120, 30);
        checkButton.addActionListener(new ListenerForAddCustomerandBackButton());
        add(checkButton);
        
        addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setBackground(Color.BLACK);
        addCustomerButton.setForeground(Color.WHITE);
        addCustomerButton.setBounds(200, 500, 120, 30);
        addCustomerButton.addActionListener(new ListenerForAddCustomerandBackButton());
        add(addCustomerButton);
        
        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(350, 500, 100, 30);
        backButton.addActionListener(new ListenerForAddCustomerandBackButton());
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/HOTEL.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 60, 400, 400);
        add(image);
        
        setVisible(true);
    }
    
    private class ListenerForAddCustomerandBackButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == checkButton) {
                String bedType = (String) bedTypeBox.getSelectedItem();
                String query = "select * from room_tables where bed_type = '" + bedType + "' AND availability_status = 'Available'";
                
                try {
                   ConnectionWithSQL connection = new ConnectionWithSQL();
                   ResultSet resultSet = connection.s.executeQuery(query);
                   
                   roomNumberChoice.removeAll();
                   while (resultSet.next()) {
                       roomNumberChoice.add(resultSet.getString("room_Number"));
                   }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == addCustomerButton) {
                String customerId = (String) customerIdBox.getSelectedItem();
                String customerIdNumber = customerIdNumberField.getText();
                String customerName = customerNameField.getText();
                String customerGender = (String) customerGenderBox.getSelectedItem();
                String customerCountry = customerCountryField.getText();
                String customerRoomNumber = roomNumberChoice.getSelectedItem();
                String checkInTime = checkinDateField.getText();
                String customerDeposit = customerDepositField.getText();
                String customerPhoneNumber = customerPhoneNumberField.getText();
                int phoneNumber;
                double deposit;
                
                if (customerIdNumber.equals("") || customerName.equals("") || customerCountry.equals("") || customerRoomNumber.equals("") || checkInTime.equals("") || customerDeposit.equals("") || customerPhoneNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }
                
                try {
                    phoneNumber = Integer.parseInt(customerPhoneNumber);
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number !!!");
                    return;
                }
                
                try {
                    deposit = Double.parseDouble(customerDeposit);
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Deposit !!!");
                    return;
                }
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    
                    String query1 = "insert into customer_information values('"+customerId+"', '"+customerIdNumber+"', '"+customerName+"', '"+customerGender+"', '"+customerCountry+"', '"+customerRoomNumber+"', '"+checkInTime+"', '"+customerDeposit+"', '"+customerPhoneNumber+"')";
                    String query2 = "update room_tables set availability_status = 'Occupied' where room_Number = '" + customerRoomNumber + "'";
                    
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Customer Add Successfully");
                    
                    setVisible(false);
                    new Reception();
                    
                }catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }else {
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
                String customerId = (String) customerIdBox.getSelectedItem();
                String customerIdNumber = customerIdNumberField.getText();
                String customerName = customerNameField.getText();
                String customerGender = (String) customerGenderBox.getSelectedItem();
                String customerCountry = customerCountryField.getText();
                String customerRoomNumber = roomNumberChoice.getSelectedItem();
                String checkInTime = checkinDateField.getText();
                String customerDeposit = customerDepositField.getText();
                String customerPhoneNumber = customerPhoneNumberField.getText();
                int phoneNumber;
                double deposit;
                
                if (customerIdNumber.equals("") || customerName.equals("") || customerCountry.equals("") || customerRoomNumber.equals("") || checkInTime.equals("") || customerDeposit.equals("") || customerPhoneNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }
                
                try {
                    phoneNumber = Integer.parseInt(customerPhoneNumber);
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number !!!");
                    return;
                }
                
                try {
                    deposit = Double.parseDouble(customerDeposit);
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Deposit !!!");
                    return;
                }
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    
                    String query1 = "insert into customer_information values('"+customerId+"', '"+customerIdNumber+"', '"+customerName+"', '"+customerGender+"', '"+customerCountry+"', '"+customerRoomNumber+"', '"+checkInTime+"', '"+customerDeposit+"', '"+customerPhoneNumber+"')";
                    String query2 = "update room_tables set availability_status = 'Occupied' where room_Number = '" + customerRoomNumber + "'";
                    
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Customer Add Successfully");
                    
                    setVisible(false);
                    new Reception();
                    
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
        new CustomerForm();
    }
}
