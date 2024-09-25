package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame {
    
    JButton managerButton, receptionButton;

    HotelManagementSystem() {
        
        super("Hotel Management");
        
        setBounds(200, 100, 1200, 500); // setting the location for the window pop up
        setLayout(null);

        // selecting image for the background of the pop up screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/11.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1300, 500); // location x, location y, length, breadth
        add(image);

        // setting what text to pop up 
        JLabel text = new JLabel("Thanks for choosing us");
        text.setBounds(20, 400, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Algerian", Font.PLAIN, 50));
        image.add(text);

        // setting the Next button
        managerButton = new JButton("Manager");
        managerButton.setBounds(400, 200, 150, 100);
        managerButton.setBackground(Color.WHITE);
        managerButton.setForeground(Color.BLACK);
        managerButton.setFont(new Font("Algerian", Font.PLAIN, 20));
        managerButton.addActionListener(new listenerForManagerReceptionButton());
        image.add(managerButton);
        
        receptionButton = new JButton("Reception");
        receptionButton.setBounds(600, 200, 150, 100);
        receptionButton.setBackground(Color.WHITE);
        receptionButton.setForeground(Color.BLACK);
        receptionButton.setFont(new Font("Algerian", Font.PLAIN, 20));
        receptionButton.addActionListener(new listenerForManagerReceptionButton());
        image.add(receptionButton);

        setVisible(true);

       
    }

    // implementing the ActionListener method for the Next button
    private class listenerForManagerReceptionButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == managerButton) {
                setVisible(false);
                new Login();
            }else if (ae.getSource() == receptionButton) {
                setVisible(false);
                new ReceptionLogin();
            }
        }
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }

}
