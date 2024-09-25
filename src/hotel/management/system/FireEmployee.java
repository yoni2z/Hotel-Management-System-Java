package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FireEmployee extends JFrame {
    
    // declaring all the required fields, buttons and combobox
    JTextField employeeNameField, genderField, ageField, phoneNumberField, emailField, jobField, salaryField, uniqueIDField, reasonField;
    JButton checkButton, submitButton, cancelButton;
    
    // creating constructor 
    FireEmployee() {
        
        super("Fire Employee");
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
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(60, 80, 100, 30);
        genderLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(genderLabel);
        
        genderField = new JTextField();
        genderField.setBackground(Color.WHITE);
        genderField.setBounds(200, 80, 200, 30);
        genderField.setEditable(false);
        add(genderField);
        
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(60, 130, 100, 30);
        ageLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(ageLabel);
        
        ageField = new JTextField();
        ageField.setBounds(200, 130, 200, 30);
        ageField.setEditable(false);
        add(ageField);
        
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(60, 180, 120, 30);
        phoneNumberLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(phoneNumberLabel);
        
        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(200, 180, 200, 30);
        phoneNumberField.setEditable(false);
        add(phoneNumberField);
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(60, 230, 100, 30);
        emailLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(emailLabel);
        
        emailField = new JTextField();
        emailField.setBounds(200, 230, 200, 30);
        emailField.setEditable(false);
        add(emailField);
        
        JLabel jobLabel = new JLabel("Job");
        jobLabel.setBounds(60, 280, 100, 30);
        jobLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(jobLabel);
        
        jobField = new JTextField();
        jobField.setBackground(Color.WHITE);
        jobField.setBounds(200, 280, 200, 30);
        jobField.setEditable(false);
        add(jobField);
        
        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(60, 330, 100, 30);
        salaryLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(salaryLabel);
        
        salaryField = new JTextField();
        salaryField.setBounds(200, 330, 200, 30);
        salaryField.setEditable(false);
        add(salaryField);
        
        JLabel uniqueIDLabel = new JLabel("ID number");
        uniqueIDLabel.setBounds(60, 380, 100, 30);
        uniqueIDLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(uniqueIDLabel);
        
        uniqueIDField = new JTextField();
        uniqueIDField.setBounds(200, 380, 200, 30);
        uniqueIDField.setEditable(false);
        add(uniqueIDField);
        
        JLabel reasonLabel = new JLabel("Reason");
        reasonLabel.setBounds(60, 430, 100, 30);
        reasonLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
        add(reasonLabel);
        
        reasonField = new JTextField();
        reasonField.setBounds(200, 430, 200, 30);
        reasonField.addKeyListener(new enterButton());
        add(reasonField);
        
        checkButton = new JButton("Check");
        checkButton.setBounds(60, 480, 100, 30);
        checkButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        checkButton.setBackground(Color.BLACK);
        checkButton.setForeground(Color.WHITE);
        checkButton.addActionListener(new listenerForSubmitButton());
        add(checkButton);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(180, 480, 100, 30);
        submitButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new listenerForSubmitButton()); // connecting the submit button with the actionlistener to give response
        add(submitButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 480, 100, 30);
        cancelButton.setFont(new Font("Cambria", Font.PLAIN, 12));
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
            if (ae.getSource() == checkButton) {
                String name = employeeNameField.getText();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query1 = "select * from employeeInformation where name = '" +name+ "'";
                    ResultSet resultSet1 = connection.s.executeQuery(query1);
                    
                    while (resultSet1.next()) {
                        genderField.setText(resultSet1.getString("gender"));
                        ageField.setText(resultSet1.getString("age"));
                        phoneNumberField.setText(resultSet1.getString("phoneNumber"));
                        emailField.setText(resultSet1.getString("email"));
                        jobField.setText(resultSet1.getString("job"));
                        salaryField.setText(resultSet1.getString("salary"));
                        uniqueIDField.setText(resultSet1.getString("uniqueID"));
                    }    
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == submitButton) {
                String employeeName = employeeNameField.getText();
                String gender = genderField.getText();
                String employeeAge = ageField.getText();
                String employeePhoneNumber = phoneNumberField.getText();
                String email = emailField.getText();
                String job = jobField.getText();
                String employeeSalary = salaryField.getText();
                String uniqueID = uniqueIDField.getText();
                String reason = reasonField.getText();
                int age, phoneNumber, uniqueId;
                double salary;

                // if any empty field occurred
                if (employeeName.equals("") || gender.equals("") || employeeAge.equals("") || employeePhoneNumber.equals("") || email.equals("") || job.equals("") || employeeSalary.equals("") || uniqueID.equals("") || reason.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }

                // storing all the values on the database table we created
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();

                    String query1 = "delete from employeeInformation where name = '"+ employeeName +"'" ;
                    String query2 = "insert into fired_employee_information values ('" + employeeName + "', '" + gender + "', '" + employeeAge + "', '" + employeePhoneNumber + "', '" + email + "', '" + job + "', '" + employeeSalary + "', '" + uniqueID + "', '" + reason + "')";
                    
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Employee Fired Successfully");

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
                String gender = genderField.getText();
                String employeeAge = ageField.getText();
                String employeePhoneNumber = phoneNumberField.getText();
                String email = emailField.getText();
                String job = jobField.getText();
                String employeeSalary = salaryField.getText();
                String uniqueID = uniqueIDField.getText();
                String reason = reasonField.getText();
                int age, phoneNumber, uniqueId;
                double salary;

                // if any empty field occurred
                if (employeeName.equals("") || gender.equals("") || employeeAge.equals("") || employeePhoneNumber.equals("") || email.equals("") || job.equals("") || employeeSalary.equals("") || uniqueID.equals("") || reason.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }

                // storing all the values on the database table we created
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();

                    String query1 = "delete from employeeInformation where name = '"+ employeeName +"'" ;
                    String query2 = "insert into fired_employee_information values ('" + employeeName + "', '" + gender + "', '" + employeeAge + "', '" + employeePhoneNumber + "', '" + email + "', '" + job + "', '" + employeeSalary + "', '" + uniqueID + "', '" + reason + "')";
                    
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Employee Fired Successfully");

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
        new FireEmployee();
    }
}
