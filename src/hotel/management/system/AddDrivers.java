package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

public class AddDrivers extends JFrame {

    JTextField driverNameField, driverFatherNameField, birthDateField, driverLocationField, driverPriceField;
    JComboBox carModelBox, statusBox, driverGenderBox;
    JButton addDriverButton, cancelButton;

    AddDrivers() {
        
        super("Add Driver");
        
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setBounds(400, 150, 900, 600);
        
        JLabel headingLabel = new JLabel("Add Driver");
        headingLabel.setBounds(150, 30, 150, 30);
        headingLabel.setFont(new Font("Algerian", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLUE);
        add(headingLabel);

        JLabel driverNameLabel = new JLabel("Driver Name");
        driverNameLabel.setBounds(60, 80, 100, 30);
        driverNameLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(driverNameLabel);

        driverNameField = new JTextField();
        driverNameField.setBounds(200, 80, 200, 30);
        driverNameField.addKeyListener(new enterButton());
        add(driverNameField);
        
        JLabel driverFatherNameLabel = new JLabel("Father Name");
        driverFatherNameLabel.setBounds(60, 130, 100, 30);
        driverFatherNameLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(driverFatherNameLabel);

        driverFatherNameField = new JTextField();
        driverFatherNameField.setBounds(200, 130, 200, 30);
        driverFatherNameField.addKeyListener(new enterButton());
        add(driverFatherNameField);
        
        JLabel birthDateLabel = new JLabel("Birth Date(Y-M-D)");
        birthDateLabel.setBounds(50, 180, 120, 30);
        birthDateLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(birthDateLabel);

        birthDateField = new JTextField();
        birthDateField.setBounds(200, 180, 200, 30);
        birthDateField.addKeyListener(new enterButton());
        add(birthDateField);

        JLabel driverGenderLabel = new JLabel("Gender");
        driverGenderLabel.setBounds(60, 230, 100, 30);
        driverGenderLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(driverGenderLabel);

        String[] driverGenderList = {"Male", "Female"};
        driverGenderBox = new JComboBox(driverGenderList);
        driverGenderBox.setBackground(Color.WHITE);
        driverGenderBox.setBounds(200, 230, 200, 30);
        driverGenderBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        driverGenderBox.addKeyListener(new enterButton());
        add(driverGenderBox);

        JLabel carModelLabel = new JLabel("Car Model");
        carModelLabel.setBounds(60, 280, 100, 30);
        carModelLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(carModelLabel);

        String[] carModelList = {"Suzuki Dzires", "Land cruiser", "Ford", "Corolla", "Toyota Yaris", "Toyota Mini-Bus", "Toyota Rav4", "Nissan", "Hyundai", "Chevrolet", "Toyota Hilux", "V8(for presidential suite only)"};
        carModelBox = new JComboBox(carModelList);
        carModelBox.setBackground(Color.WHITE);
        carModelBox.setBounds(200, 280, 200, 30);
        carModelBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        carModelBox.addKeyListener(new enterButton());
        add(carModelBox);
        
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(60, 330, 100, 30);
        statusLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(statusLabel);

        String[] statusList = {"Available", "Occupied"};
        statusBox = new JComboBox(statusList);
        statusBox.setBackground(Color.WHITE);
        statusBox.setBounds(200, 330, 200, 30);
        statusBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        statusBox.addKeyListener(new enterButton());
        add(statusBox);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(60, 380, 100, 30);
        locationLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(locationLabel);

        driverLocationField = new JTextField();
        driverLocationField.setBounds(200, 380, 200, 30);
        driverLocationField.addKeyListener(new enterButton());
        add(driverLocationField);
        
        JLabel driverPriceLabel = new JLabel("Price");
        driverPriceLabel.setBounds(60, 430, 100, 30);
        driverPriceLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(driverPriceLabel);

        driverPriceField = new JTextField();
        driverPriceField.setBounds(200, 430, 200, 30);
        driverPriceField.addKeyListener(new enterButton());
        add(driverPriceField);

        addDriverButton = new JButton("Add Driver");
        addDriverButton.setBackground(Color.BLACK);
        addDriverButton.setForeground(Color.WHITE);
        addDriverButton.setBounds(60, 480, 120, 30);
        addDriverButton.setFont(new Font("Cambria", Font.PLAIN, 14));
        addDriverButton.addActionListener(new ListenerForAddRoomandCancelButton());
        add(addDriverButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(200, 480, 100, 30);
        cancelButton.setFont(new Font("Cambria", Font.PLAIN, 14));
        cancelButton.addActionListener(new ListenerForAddRoomandCancelButton());
        add(cancelButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/driver.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 150, 300, 200);
        add(image);

        setVisible(true);

    }
    
    private class ListenerForAddRoomandCancelButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == addDriverButton) {
                String driveName = driverNameField.getText();
                String driverFatherName = driverFatherNameField.getText();
                String birthdate = birthDateField.getText();
                String driverGender = (String )driverGenderBox.getSelectedItem();
                String carModel = (String )carModelBox.getSelectedItem();
                String status = (String) statusBox.getSelectedItem();
                String driverLocation = driverLocationField.getText();
                String driverPrice = driverPriceField.getText();
                double price;
                int age;
                LocalDate birthDate;
                
                if (driveName.equals("") || birthdate.equals("") || driverLocation.equals("") || driverPrice.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }
                
                try {
                    birthDate = LocalDate.parse(birthdate);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Age should be number!!");
                    return;
                }
                
                try {
                    price = Double.parseDouble(driverPrice);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Price should be Number!!");
                    return;
                }
                
                LocalDate today = LocalDate.now();
                age = Period.between(birthDate, today).getYears();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                
                    String query = "insert into driver_table values ('" + driveName + " " + driverFatherName + "', '" + age + "', '" + driverGender + "', '" + carModel + "', '" + status + "', '" + driverLocation + "', '" + driverPrice + "')";
                
                    connection.s.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                    
                    setVisible(false);
                    new DashBoard();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                
                setVisible(false);
                
            }else {
                setVisible(false);
                new DashBoard();
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
                String driveName = driverNameField.getText();
                String driverFatherName = driverFatherNameField.getText();
                String birthdate = birthDateField.getText();
                String driverGender = (String )driverGenderBox.getSelectedItem();
                String carModel = (String )carModelBox.getSelectedItem();
                String status = (String) statusBox.getSelectedItem();
                String driverLocation = driverLocationField.getText();
                String driverPrice = driverPriceField.getText();
                double price;
                int age;
                LocalDate birthDate;
                
                if (driveName.equals("") || birthdate.equals("") || driverLocation.equals("") || driverPrice.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }
                
                try {
                    birthDate = LocalDate.parse(birthdate);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Age should be number!!");
                    return;
                }
                
                try {
                    price = Double.parseDouble(driverPrice);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Price should be Number!!");
                    return;
                }
                
                LocalDate today = LocalDate.now();
                age = Period.between(birthDate, today).getYears();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                
                    String query = "insert into driver_table values ('" + driveName + " " + driverFatherName + "', '" + age + "', '" + driverGender + "', '" + carModel + "', '" + status + "', '" + driverLocation + "', '" + driverPrice + "')";
                
                    connection.s.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                    
                    setVisible(false);
                    new DashBoard();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                
                setVisible(false);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
