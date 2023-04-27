import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Breakfast extends JFrame implements ActionListener {
// Declare the menu items and prices
private JCheckBox[] menuItems;
private double[] menuPrices = {5.99, 3.99, 7.99, 2.99, 4.99};

// Declare the GUI components
private JLabel titleLabel;
private JPanel menuPanel;
private JLabel totalPriceLabel;
private JButton checkoutButton;

// Constructor
public Breakfast() {
    // Set the window title
    setTitle("Breakfast Menu");
    
    // Set the size of the window
    setSize(500, 400);
    setResizable(false);
    
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
    String[] menuItemNames = {"Pancakes", "Waffles", "Omelette", "Toast", "Bagel"};
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
            JOptionPane.showMessageDialog(Breakfast.this, "Your total price is: $" + calculateTotalPrice());
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
