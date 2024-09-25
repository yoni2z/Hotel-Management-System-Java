package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame{
    
    JButton roomInformationButton, addEmployeeButton, addRoomsButton, addDriverButton, logoutButton,allEmployeeButton, fireButton, employeeHistoryButton, updateRoomButton;
    
    DashBoard(){
        
        super ("Manager Board");
        // setting the general size of the board
        setBounds(0,0,1920,1080);
        
        setLayout(null);
        
        // setting up the image background of the board
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/HOTEL_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel dashBoardImage = new JLabel(i3);
        dashBoardImage.setBounds(0, 0, 1920, 1080);
        add(dashBoardImage);
        
        // setting up the welcoming text
        JLabel welcomingText = new JLabel("\" The first rule of management is delegation. Don't try and do everything yourself because you can't \"");
        welcomingText.setBounds(200, 80, 1100, 50);
        welcomingText.setFont(new Font("Cambria", Font.ITALIC, 20));
        welcomingText.setForeground(Color.WHITE);
        dashBoardImage.add(welcomingText);
        
        JLabel welcomintText2 = new JLabel("- Anthea Turner");
        welcomintText2.setBounds(1000, 100, 1000, 50);
        welcomintText2.setFont(new Font("Cambria", Font.ITALIC, 12));
        welcomintText2.setForeground(Color.WHITE);
        dashBoardImage.add(welcomintText2);
        
        addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBounds(200, 300, 150, 150);
        addEmployeeButton.setBackground(Color.WHITE);
        addEmployeeButton.setFont(new Font("Algerian", Font.BOLD, 14));
        addEmployeeButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(addEmployeeButton);
        
        addRoomsButton = new JButton("Add Rooms");
        addRoomsButton.setBounds(380, 300, 150, 150);
        addRoomsButton.setBackground(Color.WHITE);
        addRoomsButton.setFont(new Font("Algerian", Font.BOLD, 14));
        addRoomsButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(addRoomsButton);
        
        addDriverButton = new JButton("Add Driver");
        addDriverButton.setBounds(560, 300, 150, 150);
        addDriverButton.setBackground(Color.WHITE);
        addDriverButton.setFont(new Font("Algerian", Font.BOLD, 14));
        addDriverButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(addDriverButton);
        
        allEmployeeButton = new JButton("All Employee");
        allEmployeeButton.setBounds(740, 300, 150, 150);
        allEmployeeButton.setBackground(Color.WHITE);
        allEmployeeButton.setFont(new Font("Algerian", Font.BOLD, 14));
        allEmployeeButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(allEmployeeButton);
        
        fireButton = new JButton("Fire Employee");
        fireButton.setBounds(920, 300, 150, 150);
        fireButton.setBackground(Color.WHITE);
        fireButton.setFont(new Font("Algerian", Font.BOLD, 14));
        fireButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(fireButton);
        
        employeeHistoryButton = new JButton("History");
        employeeHistoryButton.setBounds(1100, 300, 150, 150);
        employeeHistoryButton.setBackground(Color.WHITE);
        employeeHistoryButton.setFont(new Font("Algerian", Font.BOLD, 14));
        employeeHistoryButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(employeeHistoryButton);
        
        roomInformationButton = new JButton("All Rooms");
        roomInformationButton.setBounds(1280, 300, 150, 150);
        roomInformationButton.setBackground(Color.WHITE);
        roomInformationButton.setFont(new Font("Algerian", Font.BOLD, 14));
        roomInformationButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(roomInformationButton);
        
        updateRoomButton = new JButton("Update Room");
        updateRoomButton.setBounds(600, 500, 200, 30);
        updateRoomButton.setBackground(Color.WHITE);
        updateRoomButton.setFont(new Font("Algerian", Font.BOLD, 14));
        updateRoomButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(updateRoomButton);
        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(850, 500, 100, 30);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setFont(new Font("Algerian", Font.BOLD, 14));
        logoutButton.addActionListener(new ListenerForButtons());
        dashBoardImage.add(logoutButton);
        
        setVisible(true);
    }
    
    private class ListenerForButtons implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == addEmployeeButton) {
                setVisible(false);
                new AddEmployee();
            }else if(ae.getSource() == addRoomsButton) {
                setVisible(false);
                new AddRooms();
            }else if(ae.getSource() == addDriverButton) {
                setVisible(false);
                new AddDrivers();
            } else if(ae.getSource() == fireButton) {
                setVisible(false);
                new FireEmployee();
            }else if(ae.getSource() == logoutButton) {
                setVisible(false);
                new Login();
            } else if(ae.getSource() == allEmployeeButton) {
                setVisible(false);
                new EmployeeInformation1();
            } else if (ae.getSource() == employeeHistoryButton) {
                setVisible(false);
                new History();
            } else if (ae.getSource() == updateRoomButton) {
                setVisible(false);
                new UpdateRoom2();
            } else if(ae.getSource() == roomInformationButton) {
                setVisible(false);
                new RoomInformation1();
            }
        }
    }
    
    public static void main(String[] args) {
        new DashBoard();
    }
}
