package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class EmployeeInformation1 extends JFrame{
    
    JTable employeeInformationTable;
    JButton backButton, searchButton;
    JTextField nameField;
    JComboBox jobBox;
    
    EmployeeInformation1() {
        
        super("Employee Information");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setBounds(100, 50, 1300, 700);
        
        JLabel employeeInformationLabel = new JLabel("Employee Information");
        employeeInformationLabel.setBounds(100, 20, 200, 30);
        employeeInformationLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
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
        
        JLabel jobLabel = new JLabel("Job");
        jobLabel.setBounds(350, 50, 50, 25);
        jobLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(jobLabel);
        
        String[] jobArray = {"", "Manager", "Accountant", "Sales and Marketing", "Information Technology", "Engineering & Maintenance", "Reception", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress"};
        jobBox = new JComboBox(jobArray);
        jobBox.setBounds(410, 50, 150, 25);
        jobBox.setBackground(Color.WHITE);
        jobBox.setFont(new Font("Cambria", Font.BOLD, 12));
        jobBox.addKeyListener(new enterButton());
        add(jobBox);
        
        JLabel employeeNameLabel = new JLabel("Employee Name");
        employeeNameLabel.setBounds(10, 100, 100, 30);
        employeeNameLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(employeeNameLabel);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(135, 100, 100, 30);
        genderLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(genderLabel);
        
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(260, 100, 100, 30);
        ageLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(ageLabel);
        
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(385, 100, 100, 30);
        phoneNumberLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(phoneNumberLabel);
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(510, 100, 100, 30);
        emailLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(emailLabel);
        
        JLabel positionLabel = new JLabel("Position");
        positionLabel.setBounds(635, 100, 100, 30);
        positionLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(positionLabel);
        
        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(760, 100, 100, 30);
        salaryLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(salaryLabel);
        
        JLabel uniqueIdLabel = new JLabel("Unique ID");
        uniqueIdLabel.setBounds(885, 100, 100, 30);
        uniqueIdLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(uniqueIdLabel);
        
        employeeInformationTable = new JTable();
        employeeInformationTable.setBounds(10, 130, 1000, 400);
        employeeInformationTable.setFont(new Font("Cambria", Font.PLAIN, 12));
        add(employeeInformationTable); 
        
        try {
            ConnectionWithSQL connection = new ConnectionWithSQL();
            String query = "select * from employeeInformation";
            
            ResultSet resultSet = connection.s.executeQuery(query);
            employeeInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        searchButton = new JButton("Search");
        searchButton.setBounds(200, 600, 100, 30);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Cambria", Font.BOLD, 14));
        searchButton.addActionListener(new ListenerForBackButton());
        add(searchButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(350, 600, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Cambria", Font.BOLD, 14));
        backButton.addActionListener(new ListenerForBackButton());
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/employeeimage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(1050, 50, 200, 200);
        add(image);
        
        
        setVisible(true);
        
    }
    
    private class ListenerForBackButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == searchButton) {
                String name = nameField.getText();
                String job = (String) jobBox.getSelectedItem();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    ResultSet resultSet;
                    
                    String query1 = "select * from employeeInformation";
                    String query2 = "select * from employeeInformation where name = '"+ name +"'";
                    String query3 = "select * from employeeInformation where job = '" + job + "'";
                    String query4 = "select * from employeeInformation where job = '" + job + "' AND name = '" + name + "'";
                    
                    if (name.equals("") && job.equals("")) {
                        resultSet = connection.s.executeQuery(query1);
                    }else if (job.equals("")) {
                        resultSet = connection.s.executeQuery(query2);
                    }else if (name.equals("")) {
                        resultSet = connection.s.executeQuery(query3);
                    } else {
                        resultSet = connection.s.executeQuery(query4);
                    }
                    
                    employeeInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (ae.getSource() == backButton) {
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
                String name = nameField.getText();
                String job = (String) jobBox.getSelectedItem();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    ResultSet resultSet;
                    
                    String query1 = "select * from employeeInformation";
                    String query2 = "select * from employeeInformation where name = '"+ name +"'";
                    String query3 = "select * from employeeInformation where job = '" + job + "'";
                    String query4 = "select * from employeeInformation where job = '" + job + "' AND name = '" + name + "'";
                    
                    if (name.equals("") && job.equals("")) {
                        resultSet = connection.s.executeQuery(query1);
                    }else if (job.equals("")) {
                        resultSet = connection.s.executeQuery(query2);
                    }else if (name.equals("")) {
                        resultSet = connection.s.executeQuery(query3);
                    } else {
                        resultSet = connection.s.executeQuery(query4);
                    }
                    
                    employeeInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
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
        new EmployeeInformation1();
    }
}
