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


     // Declare the tipping percentages
     private JComboBox<String> tipComboBox;
     private double[] tipPercentages = {0, 0.10, 0.15, 0.20};


    // Constructor
    public Breakfast() {
        // Set the window title
        setTitle("Breakfast Menu");

        // Set the size of the window
        setSize(500, 400);
        setResizable(false);

        // Set the layout of the frame
        setLayout(new BorderLayout());
        
        // Set the background color of the frame
        getContentPane().setBackground(new Color(252, 252, 252));

        // Create the title label
        titleLabel = new JLabel("Please select your items:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Create the menu panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(252, 252, 252));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(menuPanel, BorderLayout.CENTER);

        // Create the menu items
        String[] menuItemNames = {"Pancakes", "Waffles", "Omelette", "Toast", "Bagel"};
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
        totalPriceLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(totalPriceLabel, BorderLayout.SOUTH);

        // Create the checkout button
        checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkoutButton.setBackground(new Color(55, 184, 121));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a message box with the total price
                Double price = calculateTotalPrice();
                JOptionPane.showMessageDialog(Breakfast.this, "Your total price is: $" + String.format("%.2f", price));
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
        double tipPercentage = tipPercentages[tipComboBox.getSelectedIndex()];
        double tipAmount = totalPrice * tipPercentage;
        totalPrice += tipAmount;
        return totalPrice;
    }
    
    // Create the main method to run the program
    public static void main(String[] args) {
    // Create a new Breakfast object
    Breakfast breakfast = new Breakfast();

    // Set the behavior of the frame when the user clicks on the close button
    breakfast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Center the window on the screen
    breakfast.setLocationRelativeTo(null);

    // Make the window visible
    breakfast.setVisible(true);
    }
}
