import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lunch extends JFrame implements ActionListener {

    // Declare the menu items and prices
    private JCheckBox[] menuItems;
    private double[] menuPrices = {8.99, 10.99, 12.99, 7.99, 6.99};
    
    // Declare the tipping percentages
    private JComboBox<String> tipComboBox;
    private double[] tipPercentages = {0, 0.10, 0.15, 0.20};
    
    // Declare the GUI components
    private JLabel titleLabel;
    private JPanel menuPanel;
    private JLabel totalPriceLabel;
    private JButton checkoutButton;
    
    // Constructor
    public Lunch() {
        // Set the window title
        setTitle("Lunch Menu");
        
        // Set the size of the window
        setSize(500, 400);
        
        // Set the layout of the frame
        setLayout(new BorderLayout());
        
        // Create the title label
        titleLabel = new JLabel("Please select your items:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);
        
        // Create the menu panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(menuPanel, BorderLayout.CENTER);
        
        // Create the menu items
        String[] menuItemNames = {"Burger", "Sandwich", "Salad", "Soup", "Fries"};
        menuItems = new JCheckBox[menuItemNames.length];
        for (int i = 0; i < menuItemNames.length; i++) {
            menuItems[i] = new JCheckBox(menuItemNames[i] + " - $" + menuPrices[i]);
            menuItems[i].setFont(new Font("Arial", Font.PLAIN, 16));
            menuItems[i].addActionListener(this);
            menuPanel.add(menuItems[i]);
        }
        
        // Create the tipping system
        JPanel tipPanel = new JPanel(new FlowLayout());
        JLabel tipLabel = new JLabel("Tip:");
        tipLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        tipPanel.add(tipLabel);
        String[] tipOptions = {"0%", "10%", "15%", "20%"};
        tipComboBox = new JComboBox<>(tipOptions);
        tipComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        tipComboBox.addActionListener(this);
        tipPanel.add(tipComboBox);
        add(tipPanel, BorderLayout.WEST);
        
        // Create the total price label
        totalPriceLabel = new JLabel("Total Price: $0.00");
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalPriceLabel.setHorizontalAlignment(JLabel.CENTER);
        add(totalPriceLabel, BorderLayout.SOUTH);
        
        // Create the checkout button
        checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a message box with the total price
                Double price = calculateTotalPrice();
                JOptionPane.showMessageDialog(Lunch.this, "Your total price is: $" + String.format("%.2f", price));
            }
        });
        add(checkoutButton, BorderLayout.EAST);
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // Make the window visible
        setVisible(true);
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
    double tipPercentage = tipPercentages[tipComboBox.getSelectedIndex()];
    double tipAmount = totalPrice * tipPercentage;
    totalPrice += tipAmount;
    return totalPrice;
}

    
    // Main method to run the program
    public static void main(String[] args) {
        new Lunch();
    }
}
