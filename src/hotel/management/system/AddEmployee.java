package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;

public class AddEmployee extends JFrame {
    
    // declaring all the required fields, buttons and combobox
    JTextField employeeNameField,employeeFatherNameField, birthDateField, phoneNumberField, emailField, salaryField, uniqueIDField;
    JButton submitButton, cancelButton;
    JComboBox genderBox, jobListBox;
    
    // creating constructor 
    AddEmployee() {
        
        super("Add Employee");
        setLayout(null);
        
        // setting the background color and size and location
        getContentPane().setBackground(Color.WHITE);
        setBounds(400, 150, 800, 600);
        
        // setting up the label and the declared field, buttons and combobox
        JLabel employeeNameLabel = new JLabel("Name");
        employeeNameLabel.setBounds(60, 30, 100, 30);
        employeeNameLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(employeeNameLabel);
        
        employeeNameField = new JTextField();
        employeeNameField.setBounds(200, 30, 200, 30);
        employeeNameField.addKeyListener(new enterButton());
        add(employeeNameField);
        
        JLabel employeeFatherNameLabel = new JLabel("Father Name");
        employeeFatherNameLabel.setBounds(60, 80, 120, 30);
        employeeFatherNameLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(employeeFatherNameLabel);
        
        employeeFatherNameField = new JTextField();
        employeeFatherNameField.setBounds(200, 80, 200, 30);
        employeeFatherNameField.addKeyListener(new enterButton());
        add(employeeFatherNameField);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(60, 130, 100, 30);
        genderLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(genderLabel);
        
        String[] genderArray = {"Male", "Female", "Other"}; // creating array for the input in the  gender combo box
        genderBox = new JComboBox(genderArray);
        genderBox.setBackground(Color.WHITE);
        genderBox.setBounds(200, 130, 200, 30);
        genderBox.addKeyListener(new enterButton());
        add(genderBox);
        
        JLabel BirthDateLabel = new JLabel("Birth Date (Y-M-D)");
        BirthDateLabel.setBounds(50, 180, 150, 30);
        BirthDateLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(BirthDateLabel);
        
        birthDateField = new JTextField();
        birthDateField.setBounds(200, 180, 200, 30);
        birthDateField.addKeyListener(new enterButton());
        add(birthDateField);
        
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(60, 230, 120, 30);
        phoneNumberLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(phoneNumberLabel);
        
        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(200, 230, 200, 30);
        phoneNumberField.addKeyListener(new enterButton());
        add(phoneNumberField);
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(60, 280, 100, 30);
        emailLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(emailLabel);
        
        emailField = new JTextField();
        emailField.setBounds(200, 280, 200, 30);
        emailField.addKeyListener(new enterButton());
        add(emailField);
        
        JLabel jobLabel = new JLabel("Job");
        jobLabel.setBounds(60, 330, 100, 30);
        jobLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(jobLabel);
        
        // declaring an array of job lists for the input in jobListBox
        String[] jobArray = {"Manager", "Accountant", "Sales and Marketing", "Information Technology", "Engineering & Maintenance", "Reception", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress"};
        jobListBox = new JComboBox(jobArray);
        jobListBox.setBackground(Color.WHITE);
        jobListBox.setBounds(200, 330, 200, 30);
        jobListBox.addKeyListener(new enterButton());
        add(jobListBox);
        
        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(60, 380, 100, 30);
        salaryLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(salaryLabel);
        
        salaryField = new JTextField();
        salaryField.setBounds(200, 380, 200, 30);
        salaryField.addKeyListener(new enterButton());
        add(salaryField);
        
        JLabel uniqueIDLabel = new JLabel("ID number");
        uniqueIDLabel.setBounds(60, 430, 100, 30);
        uniqueIDLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(uniqueIDLabel);
        
        uniqueIDField = new JTextField();
        uniqueIDField.setBounds(200, 430, 200, 30);
        uniqueIDField.addKeyListener(new enterButton());
        add(uniqueIDField);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 480, 100, 30);
        submitButton.setFont(new Font("Broadway", Font.PLAIN, 12));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new listenerForSubmitButton()); // connecting the submit button with the actionlistener to give response
        add(submitButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 480, 100, 30);
        cancelButton.setFont(new Font("Broadway", Font.PLAIN, 12));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(new listenerForSubmitButton());
        add(cancelButton);
        
        // setting the image on the side 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/employeeimage2.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 100, 200, 200);
        add(image);
        
        setVisible(true);
        
    }
    
    // creating a private class which implements the actionListener
    private class listenerForSubmitButton implements ActionListener {
        // overriding the actionperformed method
        public void actionPerformed(ActionEvent ae) {
            // storing all the values from the input
            if (ae.getSource() == submitButton) {
                String employeeName = employeeNameField.getText();
                String employeeFatherName = employeeFatherNameField.getText();
                String gender = (String)genderBox.getSelectedItem();
                String birthdate = birthDateField.getText();
                String employeePhoneNumber = phoneNumberField.getText();
                String email = emailField.getText();
                String job = (String)jobListBox.getSelectedItem();
                String employeeSalary = salaryField.getText();
                String uniqueID = uniqueIDField.getText();
                int age, phoneNumber, uniqueId;
                double salary;
                LocalDate birthDate;

                // if any empty field occurred
                if (employeeName.equals("") || gender.equals("") || birthdate.equals("") || employeePhoneNumber.equals("") || email.equals("") || job.equals("") || employeeSalary.equals("") || uniqueID.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }

                LocalDate today = LocalDate.now();
                // if any incorrect datatypes are inserted
                try {
                    birthDate = LocalDate.parse(birthdate);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Inappropriate Birth Date!!");
                    return;
                }

                try {
                    phoneNumber = Integer.parseInt(employeePhoneNumber);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Incorrect Phone Number");
                    return;
                }

                if (email.contains("@") && email.contains(".com")) {
                    email = email;
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                    return;
                }

                try {
                    salary = Double.parseDouble(employeeSalary);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Salary should be in Number !!");
                    return;
                }

                try {
                    uniqueId = Integer.parseInt(uniqueID);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Unique ID should be in Number !!");
                    return;
                }
                
                
                age = Period.between(birthDate, today).getYears();
                
                // storing all the values on the database table we created
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();

                    String query = "insert into employeeInformation values ('" + employeeName + " " + employeeFatherName + "', '" + gender + "', '" + age + "', '" + employeePhoneNumber + "', '" + email + "', '" + job + "', '" + salary + "', '" + uniqueID + "')";

                    connection.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Employee added Successfully");

                    setVisible(false);
                    new DashBoard();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == cancelButton) {
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
                String employeeName = employeeNameField.getText();
                String employeeFatherName = employeeFatherNameField.getText();
                String gender = (String)genderBox.getSelectedItem();
                String birthdate = birthDateField.getText();
                String employeePhoneNumber = phoneNumberField.getText();
                String email = emailField.getText();
                String job = (String)jobListBox.getSelectedItem();
                String employeeSalary = salaryField.getText();
                String uniqueID = uniqueIDField.getText();
                int age, phoneNumber, uniqueId;
                double salary;
                LocalDate birthDate;

                // if any empty field occurred
                if (employeeName.equals("") || gender.equals("") || birthdate.equals("") || employeePhoneNumber.equals("") || email.equals("") || job.equals("") || employeeSalary.equals("") || uniqueID.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }

                LocalDate today = LocalDate.now();
                // if any incorrect datatypes are inserted
                try {
                    birthDate = LocalDate.parse(birthdate);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Inappropriate Birth Date!!");
                    return;
                }

                try {
                    phoneNumber = Integer.parseInt(employeePhoneNumber);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Incorrect Phone Number");
                    return;
                }

                if (email.contains("@") && email.contains(".com")) {
                    email = email;
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                    return;
                }

                try {
                    salary = Double.parseDouble(employeeSalary);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Salary should be in Number !!");
                    return;
                }

                try {
                    uniqueId = Integer.parseInt(uniqueID);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Unique ID should be in Number !!");
                    return;
                }
                
                
                age = Period.between(birthDate, today).getYears();
                
                // storing all the values on the database table we created
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();

                    String query = "insert into employeeInformation values ('" + employeeName + " " + employeeFatherName + "', '" + gender + "', '" + age + "', '" + employeePhoneNumber + "', '" + email + "', '" + job + "', '" + salary + "', '" + uniqueID + "')";

                    connection.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Employee added Successfully");

                    setVisible(false);
                    new DashBoard();
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
        new AddEmployee();
    }
}
