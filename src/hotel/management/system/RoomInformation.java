package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class RoomInformation extends JFrame{
    
    JTable roomInformationTable;
    JButton searchButton, backButton;
    JComboBox bedTypeBox;
    JTextField roomNumberField;
    
    RoomInformation() {
        
        super("Room Information");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setBounds(300, 100, 1000, 700);
        
        JLabel roomInformationLabel = new JLabel("Room Information");
        roomInformationLabel.setBounds(50, 20, 150, 30);
        roomInformationLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
        roomInformationLabel.setForeground(Color.BLUE);
        add(roomInformationLabel);
        
        JLabel bedTypeChoiceLabel = new JLabel("Bed Type");
        bedTypeChoiceLabel.setBounds(100, 70, 100, 30);
        bedTypeChoiceLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(bedTypeChoiceLabel);
        
        String[] bedTypeList = {"","Single Bed", "Double bed", "Family Room", "Sweet Room", "Presidential Room", "Connecting Room", "Disabled Room"};
        bedTypeBox = new JComboBox(bedTypeList);
        bedTypeBox.setBackground(Color.WHITE);
        bedTypeBox.setBounds(200, 70, 200, 30);
        bedTypeBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        bedTypeBox.addKeyListener(new enterButton());
        add(bedTypeBox);
        
        JLabel roomNumberChoiceLabel = new JLabel("Room Number");
        roomNumberChoiceLabel.setBounds(100, 130, 100, 30);
        roomNumberChoiceLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(roomNumberChoiceLabel);
        
        roomNumberField = new JTextField();
        roomNumberField.setBounds(200, 130, 80, 30);
        roomNumberField.setFont(new Font("Cambria", Font.PLAIN, 12));
        roomNumberField.addKeyListener(new enterButton());
        add(roomNumberField);
        
        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(0, 180, 100, 30);
        roomNumberLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(roomNumberLabel);
        
        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setBounds(100, 180, 100, 30);
        bedTypeLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(bedTypeLabel);
        
        JLabel cleaningStatusLabel = new JLabel("Cleaning Status");
        cleaningStatusLabel.setBounds(200, 180, 100, 30);
        cleaningStatusLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(cleaningStatusLabel);
        
        JLabel availabilityStatusLabel = new JLabel("Status");
        availabilityStatusLabel.setBounds(300, 180, 100, 30);
        availabilityStatusLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(availabilityStatusLabel);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(400, 180, 100, 30);
        priceLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(priceLabel);
        
        roomInformationTable = new JTable();
        roomInformationTable.setBounds(0, 210, 500, 350);
        roomInformationTable.setFont(new Font("Cambria", Font.PLAIN, 12));
        add(roomInformationTable); 
        
        try {
            ConnectionWithSQL connection = new ConnectionWithSQL();
            String query = "select * from room_tables";
            
            ResultSet resultSet = connection.s.executeQuery(query);
            roomInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        searchButton = new JButton("Search");
        searchButton.setBounds(80, 600, 100, 30);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Cambria", Font.BOLD, 14));
        searchButton.addActionListener(new ListenerForBackButton());
        add(searchButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(220, 600, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ListenerForBackButton());
        backButton.setFont(new Font("Cambria", Font.BOLD, 14));
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bedroom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 400, 500);
        add(image);
        
        
        setVisible(true);
        
    }
    
    private class ListenerForBackButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == searchButton) {
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    ResultSet resultSet;
                    
                    String bedType = (String) bedTypeBox.getSelectedItem();
                    String roomNumber = roomNumberField.getText();
                    int number;
                    
                    try {
                        if (roomNumber.equals("")) {
                            number = 0;
                        }else {
                            number = Integer.parseInt(roomNumber);
                        }
                    }catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid Room Number");
                        return;
                    }
                
                    String query1 = "select * from room_tables where bed_type = '" + bedType + "'";
                    String query2 = "select * from room_tables where room_Number = '" +roomNumber+ "' AND bed_type = '" + bedType + "'";
                    String query3 = "select * from room_tables where room_Number = '" + roomNumber + "'";
                    String query4 = "select * from room_tables";
                
                    if (roomNumber.equals("") && bedType.equals("")) {
                        resultSet = connection.s.executeQuery(query4);
                    }else if (bedType.equals("")) {
                        resultSet = connection.s.executeQuery(query3);
                    }else if (roomNumber.equals("")) {
                        resultSet = connection.s.executeQuery(query1);
                    }else {
                        resultSet = connection.s.executeQuery(query2);
                    }
                    
                    roomInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
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
                try {
                    ConnectionWithSQL connection = new ConnectionWithSQL();
                    ResultSet resultSet;
                    
                    String bedType = (String) bedTypeBox.getSelectedItem();
                    String roomNumber = roomNumberField.getText();
                    int number;
                    
                    try {
                        if (roomNumber.equals("")) {
                            number = 0;
                        }else {
                            number = Integer.parseInt(roomNumber);
                        }
                    }catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid Room Number");
                        return;
                    }
                
                    String query1 = "select * from room_tables where bed_type = '" + bedType + "'";
                    String query2 = "select * from room_tables where room_Number = '" +roomNumber+ "' AND bed_type = '" + bedType + "'";
                    String query3 = "select * from room_tables where room_Number = '" + roomNumber + "'";
                    String query4 = "select * from room_tables";
                
                    if (roomNumber.equals("") && bedType.equals("")) {
                        resultSet = connection.s.executeQuery(query4);
                    }else if (bedType.equals("")) {
                        resultSet = connection.s.executeQuery(query3);
                    }else if (roomNumber.equals("")) {
                        resultSet = connection.s.executeQuery(query1);
                    }else {
                        resultSet = connection.s.executeQuery(query2);
                    }
                    
                    roomInformationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
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
        new RoomInformation();
    }
}
