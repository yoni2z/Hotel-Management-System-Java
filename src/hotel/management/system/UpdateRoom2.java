package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom2 extends JFrame{
    
    Choice roomNumberChoice;
    JTextField statusField, cleaningStatusField, priceField, updatedPriceField;
    JComboBox statusBox, cleaningStatusBox;
    JButton checkButton, updateButton, backButton;
    
    UpdateRoom2() {
        
        super("Update Room");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setBounds(300, 100, 1000, 500);
        
        JLabel updateRoomStatusLabel = new JLabel("Update Rooms");
        updateRoomStatusLabel.setBounds(100, 30, 200, 30);
        updateRoomStatusLabel.setFont(new Font("Algerian", Font.BOLD, 20));
        add(updateRoomStatusLabel);
        
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
            String query = "select * from room_tables";
            ResultSet resultSet = connection.s.executeQuery(query);
            
            while (resultSet.next()) {
                roomNumberChoice.add(resultSet.getString("Room_Number"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(30, 120, 100, 30);
        statusLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(statusLabel);
        
        statusField = new JTextField();
        statusField.setBounds(200, 120, 100, 30);
        statusField.setFont(new Font("Cambria", Font.PLAIN, 14));
        statusField.setEditable(false);
        add(statusField);
        
        JLabel cleaningStatusLabel = new JLabel("Cleaning Status");
        cleaningStatusLabel.setBounds(30, 160, 150, 30);
        cleaningStatusLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(cleaningStatusLabel);
        
        cleaningStatusField = new JTextField();
        cleaningStatusField.setBounds(200, 160, 100, 30);
        cleaningStatusField.setFont(new Font("Cambria", Font.PLAIN, 14));
        cleaningStatusField.setEditable(false);
        add(cleaningStatusField);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(30, 200, 100, 30);
        priceLabel.setFont(new Font("Cambria", Font.BOLD, 14));
        add(priceLabel);
        
        priceField = new JTextField();
        priceField.setBounds(200, 200, 100, 30);
        priceField.setFont(new Font("Cambria", Font.PLAIN, 14));
        priceField.setEditable(false);
        add(priceField);
        
        updatedPriceField = new JTextField();
        updatedPriceField.setBounds(320, 200, 100, 30);
        updatedPriceField.setFont(new Font("Cambria", Font.PLAIN, 14));
        updatedPriceField.addKeyListener(new enterButton());
        add(updatedPriceField);
        
        checkButton = new JButton("Check");
        checkButton.setBounds(60, 380, 100, 30);
        checkButton.setBackground(Color.BLACK);
        checkButton.setForeground(Color.WHITE);
        checkButton.setFont(new Font("Cambira", Font.BOLD, 14));
        checkButton.addActionListener(new ListenerForCheckUpdateBackButtons());
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
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query1 = "select * from room_tables where room_Number = '" +roomNumber+ "'";
                    ResultSet resultSet1 = connection.s.executeQuery(query1);
                    
                    while (resultSet1.next()) {
                        statusField.setText(resultSet1.getString("availability_status"));
                        cleaningStatusField.setText(resultSet1.getString("cleaning_status"));
                        priceField.setText(resultSet1.getString("price"));
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (ae.getSource() == updateButton) {
                String roomNumber = roomNumberChoice.getSelectedItem();
                String updatedPrice = updatedPriceField.getText();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query4 = "update room_tables set price = '" + updatedPrice + "' where Room_Number = '" + roomNumber +"' ";
                    
                    connection.s.executeUpdate(query4);
                    
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    
                    setVisible(false);
                    new DashBoard();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }else if(ae.getSource() == backButton) {
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
                String roomNumber = roomNumberChoice.getSelectedItem();
                String updatedPrice = updatedPriceField.getText();
                
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    String query4 = "update room_tables set price = '" + updatedPrice + "' where Room_Number = '" + roomNumber +"' ";
                    
                    connection.s.executeUpdate(query4);
                    
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    
                    setVisible(false);
                    new DashBoard();
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
        new UpdateRoom2();
    }
}
