package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame {

    JTextField roomNumberField, priceField;
    JComboBox statusBox, bedTypeBox, cleaningStatusBox;
    JButton addRoomButton, cancelButton;

    AddRooms() {
        
        super("Add Rooms");
        
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setBounds(400, 150, 800, 500);
        
        JLabel headingLabel = new JLabel("Add Rooms");
        headingLabel.setBounds(150, 30, 150, 30);
        headingLabel.setFont(new Font("Algerian", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLUE);
        add(headingLabel);

        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(60, 80, 100, 30);
        roomNumberLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(roomNumberLabel);

        roomNumberField = new JTextField();
        roomNumberField.setBounds(200, 80, 200, 30);
        roomNumberField.addKeyListener(new enterButton());
        add(roomNumberField);

        JLabel bedTypeLabel = new JLabel("BedType");
        bedTypeLabel.setBounds(60, 130, 100, 30);
        bedTypeLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(bedTypeLabel);

        String[] bedTypeList = {"Single Bed", "Double bed", "Family Room", "Sweet Room", "Presidential Room", "Connecting Room", "Disabled Room"};
        bedTypeBox = new JComboBox(bedTypeList);
        bedTypeBox.setBackground(Color.WHITE);
        bedTypeBox.setBounds(200, 130, 200, 30);
        bedTypeBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        bedTypeBox.addKeyListener(new enterButton());
        add(bedTypeBox);

        JLabel cleaningStatusLabel = new JLabel("Cleaning Status");
        cleaningStatusLabel.setBounds(60, 180, 100, 30);
        cleaningStatusLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(cleaningStatusLabel);

        String[] cleaningStatusList = {"Cleaned", "Dirty"};
        cleaningStatusBox = new JComboBox(cleaningStatusList);
        cleaningStatusBox.setBackground(Color.WHITE);
        cleaningStatusBox.setBounds(200, 180, 200, 30);
        cleaningStatusBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        cleaningStatusBox.addKeyListener(new enterButton());
        add(cleaningStatusBox);
        
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(60, 230, 100, 30);
        statusLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(statusLabel);

        String[] statusList = {"Available", "Occupied"};
        statusBox = new JComboBox(statusList);
        statusBox.setBackground(Color.WHITE);
        statusBox.setBounds(200, 230, 200, 30);
        statusBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        statusBox.addKeyListener(new enterButton());
        add(statusBox);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(60, 280, 100, 30);
        priceLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(200, 280, 200, 30);
        priceField.addKeyListener(new enterButton());
        add(priceField);

        addRoomButton = new JButton("Add Room");
        addRoomButton.setBackground(Color.BLACK);
        addRoomButton.setForeground(Color.WHITE);
        addRoomButton.setBounds(60, 330, 100, 30);
        addRoomButton.setFont(new Font("Cambria", Font.PLAIN, 14));
        addRoomButton.addActionListener(new ListenerForAddRoomandCancelButton());
        add(addRoomButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(200, 330, 100, 30);
        cancelButton.setFont(new Font("Cambria", Font.PLAIN, 14));
        cancelButton.addActionListener(new ListenerForAddRoomandCancelButton());
        add(cancelButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bed.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 100, 200, 200);
        add(image);

        setVisible(true);

    }
    
    private class ListenerForAddRoomandCancelButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == addRoomButton) {
                String roomNumber = roomNumberField.getText();
                String bedType = (String) bedTypeBox.getSelectedItem();
                String cleaningStatus = (String )cleaningStatusBox.getSelectedItem();
                String availabilityStatus = (String) statusBox.getSelectedItem();
                String roomPrice = priceField.getText();
                double price;
                int roomnumber;
                
                if (roomNumber.equals("") || bedType.equals("") ||cleaningStatus.equals("") ||availabilityStatus.equals("") ||roomPrice.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }
                
                try {
                    roomnumber = Integer.parseInt(roomNumber);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Room Number should be number!!");
                    return;
                }
                
                try {
                    price = Double.parseDouble(roomPrice);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Price should be Number!!");
                    return;
                }
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                
                    String query = "insert into room_tables values ('" + roomNumber + "', '" + bedType + "', '" + cleaningStatus + "', '" + availabilityStatus + "', '" + price + "')";
                
                    connection.s.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                    
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
                String roomNumber = roomNumberField.getText();
                String bedType = (String) bedTypeBox.getSelectedItem();
                String cleaningStatus = (String )cleaningStatusBox.getSelectedItem();
                String availabilityStatus = (String) statusBox.getSelectedItem();
                String roomPrice = priceField.getText();
                double price;
                int roomnumber;
                
                if (roomNumber.equals("") || bedType.equals("") ||cleaningStatus.equals("") ||availabilityStatus.equals("") ||roomPrice.equals("")) {
                    JOptionPane.showMessageDialog(null, "All Fields are Required");
                    return;
                }
                
                try {
                    roomnumber = Integer.parseInt(roomNumber);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Room Number should be number!!");
                    return;
                }
                
                try {
                    price = Double.parseDouble(roomPrice);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Price should be Number!!");
                    return;
                }
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                
                    String query = "insert into room_tables values ('" + roomNumber + "', '" + bedType + "', '" + cleaningStatus + "', '" + availabilityStatus + "', '" + price + "')";
                
                    connection.s.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                    
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
        new AddRooms();
    }
}
