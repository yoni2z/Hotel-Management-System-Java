package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame{
    
    JButton newCustomerButton, roomsInformationButton, departementButton, allEmployeeButton, customerInformationButton, managerInformationButton, checkOutButton, updateStatusButton, updateRoomStatusButton, pickUpServiceButton, searchRoomButton, logoutButton;
    
    Reception() {
        
        super("Reception");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300, 100, 800, 600);
        
        newCustomerButton = new JButton("New Customer Form");
        newCustomerButton.setBounds(60, 60, 180, 30);
        newCustomerButton.setBackground(Color.BLACK);
        newCustomerButton.setForeground(Color.WHITE);
        newCustomerButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        newCustomerButton.addActionListener(new ListenerForButtons());
        add(newCustomerButton);
        
        roomsInformationButton = new JButton("Rooms Information");
        roomsInformationButton.setBounds(60, 100, 180, 30);
        roomsInformationButton.setBackground(Color.BLACK);
        roomsInformationButton.setForeground(Color.WHITE);
        roomsInformationButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        roomsInformationButton.addActionListener(new ListenerForButtons());
        add(roomsInformationButton);
        
        allEmployeeButton = new JButton("Employee Information");
        allEmployeeButton.setBounds(60, 140, 180, 30);
        allEmployeeButton.setBackground(Color.BLACK);
        allEmployeeButton.setForeground(Color.WHITE);
        allEmployeeButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        allEmployeeButton.addActionListener(new ListenerForButtons());
        add(allEmployeeButton);
        
        customerInformationButton = new JButton("Customer Information");
        customerInformationButton.setBounds(60, 180, 180, 30);
        customerInformationButton.setBackground(Color.BLACK);
        customerInformationButton.setForeground(Color.WHITE);
        customerInformationButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        customerInformationButton.addActionListener(new ListenerForButtons());
        add(customerInformationButton);
        
        checkOutButton = new JButton("Check Out");
        checkOutButton.setBounds(60, 220, 180, 30);
        checkOutButton.setBackground(Color.BLACK);
        checkOutButton.setForeground(Color.WHITE);
        checkOutButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        checkOutButton.addActionListener(new ListenerForButtons());
        add(checkOutButton);
        
        updateStatusButton = new JButton("Update Status");
        updateStatusButton.setBounds(60, 260, 180, 30);
        updateStatusButton.setBackground(Color.BLACK);
        updateStatusButton.setForeground(Color.WHITE);
        updateStatusButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        updateStatusButton.addActionListener(new ListenerForButtons());
        add(updateStatusButton);
        
        updateRoomStatusButton = new JButton("Update Room Status");
        updateRoomStatusButton.setBounds(60, 300, 180, 30);
        updateRoomStatusButton.setBackground(Color.BLACK);
        updateRoomStatusButton.setForeground(Color.WHITE);
        updateRoomStatusButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        updateRoomStatusButton.addActionListener(new ListenerForButtons());
        add(updateRoomStatusButton);
        
        pickUpServiceButton = new JButton("PickUp Services");
        pickUpServiceButton.setBounds(60, 340, 180, 30);
        pickUpServiceButton.setBackground(Color.BLACK);
        pickUpServiceButton.setForeground(Color.WHITE);
        pickUpServiceButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        pickUpServiceButton.addActionListener(new ListenerForButtons());
        add(pickUpServiceButton);
        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(60, 480, 180, 30);
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Cambria", Font.PLAIN, 12));
        logoutButton.addActionListener(new ListenerForButtons());
        add(logoutButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/hotelreception.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(300, 60, 415, 400);
        add(image);
        
        setVisible(true);
    }
    
    private class ListenerForButtons implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() ==  newCustomerButton) {
                setVisible(false);
                new CustomerForm();
            } else if (ae.getSource() == roomsInformationButton) {
                setVisible(false);
                new RoomInformation();
            } else if (ae.getSource() == allEmployeeButton) {
                setVisible(false);
                new EmployeeInformation();
            } else if (ae.getSource() == customerInformationButton) {
                setVisible(false);
                new CustomerInformation();
            }else if (ae.getSource() == checkOutButton) {
                setVisible(false);
                new CheckOut();
            } else if (ae.getSource() == updateStatusButton) {
                setVisible(false);
                new UpdateStatus();
            } else if (ae.getSource() == updateRoomStatusButton) {
                setVisible(false);
                new UpdateRoom();
            } else if (ae.getSource() == pickUpServiceButton) {
                setVisible(false);
                new PickUpService();
            } else if (ae.getSource() ==  logoutButton) {
                setVisible(false);
                new ReceptionLogin();
            }
        }
    }
    
    public static void main(String[] arg) {
        new Reception();
    }
   
}
