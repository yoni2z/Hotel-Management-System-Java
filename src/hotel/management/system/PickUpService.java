package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickUpService extends JFrame{
    
    JTable pickUpSeriviceTable;
    JButton searchButton, backButton;
    JComboBox carModelBox;
    
    PickUpService() {
        
        super("Pickup Service");
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setBounds(300, 100, 1200, 700);
        
        JLabel roomInformationLabel = new JLabel("PickUp Services");
        roomInformationLabel.setBounds(100, 20, 200, 30);
        roomInformationLabel.setFont(new Font("Algerian", Font.PLAIN, 20));
        roomInformationLabel.setForeground(Color.BLUE);
        add(roomInformationLabel);
        
        JLabel carModelTypeLabel = new JLabel("Car Model");
        carModelTypeLabel.setBounds(100, 70, 100, 30);
        carModelTypeLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(carModelTypeLabel);
        
        String[] carModelList = {"", "Suzuki Dzires", "Land cruiser", "Ford", "Corolla", "Toyota Yaris", "Toyota Mini-Bus", "Toyota Rav4", "Nissan", "Hyundai", "Chevrolet", "Toyota Hilux", "V8(for presidential suite only)"};
        carModelBox = new JComboBox(carModelList);
        carModelBox.setBackground(Color.WHITE);
        carModelBox.setBounds(200, 70, 200, 30);
        carModelBox.setFont(new Font("Cambria", Font.PLAIN, 14));
        carModelBox.addKeyListener(new enterButton());
        add(carModelBox);
        
        JLabel driverNameLabel = new JLabel("Driver Name");
        driverNameLabel.setBounds(0, 180, 100, 30);
        driverNameLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(driverNameLabel);
        
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(100, 180, 100, 30);
        ageLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(ageLabel);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(200, 180, 100, 30);
        genderLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(genderLabel);
        
        JLabel carModelLabel = new JLabel("Car Model");
        carModelLabel.setBounds(300, 180, 100, 30);
        carModelLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(carModelLabel);
        
        JLabel StatusLabel = new JLabel("Status");
        StatusLabel.setBounds(400, 180, 100, 30);
        StatusLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(StatusLabel);
        
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(500, 180, 100, 30);
        locationLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(locationLabel);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(600, 180, 100, 30);
        priceLabel.setFont(new Font("Cambria", Font.BOLD, 12));
        add(priceLabel);
        
        pickUpSeriviceTable = new JTable();
        pickUpSeriviceTable.setBounds(0, 210, 700, 350);
        pickUpSeriviceTable.setFont(new Font("Cambria", Font.PLAIN, 12));
        add(pickUpSeriviceTable); 
        
        try {
            ConnectionWithSQL connection = new ConnectionWithSQL();
            String query = "select * from driver_table";
            
            ResultSet resultSet = connection.s.executeQuery(query);
            pickUpSeriviceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
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
        backButton.setFont(new Font("Cambria", Font.BOLD, 14));
        backButton.addActionListener(new ListenerForBackButton());
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/pickup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(750, 100, 400, 400);
        add(image);
        
        
        setVisible(true);
        
    }
    
    private class ListenerForBackButton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == searchButton) {
                String carModel = (String) carModelBox.getSelectedItem();
                
                if (carModel.equals("")) {
                    try {
                        ConnectionWithSQL connection = new ConnectionWithSQL();
                        String query = "select * from driver_table";

                        ResultSet resultSet = connection.s.executeQuery(query);
                        pickUpSeriviceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        ConnectionWithSQL connection = new ConnectionWithSQL();

                        int number;

                        String query = "select * from driver_table where Car_Model = '" + carModel + "'";

                        ResultSet resultSet = connection.s.executeQuery(query);

                        pickUpSeriviceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
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
                String carModel = (String) carModelBox.getSelectedItem();
                
                if (carModel.equals("")) {
                    try {
                        ConnectionWithSQL connection = new ConnectionWithSQL();
                        String query = "select * from driver_table";

                        ResultSet resultSet = connection.s.executeQuery(query);
                        pickUpSeriviceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        ConnectionWithSQL connection = new ConnectionWithSQL();

                        int number;

                        String query = "select * from driver_table where Car_Model = '" + carModel + "'";

                        ResultSet resultSet = connection.s.executeQuery(query);

                        pickUpSeriviceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        
    }
    
    public static void main(String[] args) {
        new PickUpService();
    }
}
