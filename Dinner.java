import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dinner extends JFrame implements ActionListener {
    // Declare the menu items and prices
    private JCheckBox[] menuItems;
    private double[] menuPrices = {14.99, 16.99, 18.99, 10.99, 8.99};
    
    // Declare the GUI components
    private JLabel titleLabel;
    private JPanel menuPanel;
    private JLabel totalPriceLabel;
    private JButton checkoutButton;

    // Constructor
    public Dinner() {
        // Set the window title
        setTitle("Dinner Menu");
        
        // Set the size of the window
        setSize(400, 300);
        
        // Set the layout of the frame
        setLayout(new BorderLayout());
        
        // Create the title label
        titleLabel = new JLabel("Please select your items:");
        add(titleLabel, BorderLayout.NORTH);
        
        // Create the menu panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        add(menuPanel, BorderLayout.CENTER);
        
        // Create the menu items
        String[] menuItemNames = {"Steak", "Fish", "Chicken", "Pasta", "Soup"};
        menuItems = new JCheckBox[menuItemNames.length];
        for (int i = 0; i < menuItemNames.length; i++) {
            menuItems[i] = new JCheckBox(menuItemNames[i] + " - $" + menuPrices[i]);
            menuItems[i].addActionListener(this);
            menuPanel.add(menuItems[i]);
        }
        
        // Create the total price label
        totalPriceLabel = new JLabel("Total Price: $0.00");
        add(totalPriceLabel, BorderLayout.SOUTH);
        
        // Create the checkout button
        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a message box with the total price
                JOptionPane.showMessageDialog(Dinner.this, "Your total price is: $" + calculateTotalPrice());
            }
        });
        add(checkoutButton, BorderLayout.EAST);
    }
    
    // Implement the actionPerformed method for the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        // Update the total price label
        double totalPrice = calculateTotalPrice();
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }
    
    // Calculate the total price of the selected menu items
    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i].isSelected()) {
                totalPrice += menuPrices[i];
            }
        }
        return totalPrice;
    }
}
