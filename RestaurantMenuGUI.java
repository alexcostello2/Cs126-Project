import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class RestaurantMenuGUI extends JFrame {
    private JButton breakfastButton;
    private JButton lunchButton;
    private JButton dinnerButton;

    public RestaurantMenuGUI() {
        // Set the title of the JFrame
        setTitle("Restaurant Menu");

        // Set the size of the JFrame
        setSize(400, 300);

        // Set the default close operation of the JFrame to exit on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout of the JFrame to a BorderLayout
        setLayout(new BorderLayout());

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();

        // Create the "Breakfast" button
        breakfastButton = new JButton("Breakfast");

        // Add an ActionListener to the "Breakfast" button
        breakfastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new instance of the Breakfast class
                Breakfast breakfast = new Breakfast();
                // Show the Breakfast GUI
                breakfast.setVisible(true);
            }
        });

        // Add the "Breakfast" button to the button panel
        buttonPanel.add(breakfastButton);

        // Create the "Lunch" button
        lunchButton = new JButton("Lunch");

        // Add an action listener to the lunchButton
        lunchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Lunch frame
                Lunch lunchFrame = new Lunch();
                lunchFrame.setVisible(true);
            }
        });


        // Add the "Lunch" button to the button panel
        buttonPanel.add(lunchButton);

        // Create the "Dinner" button
        dinnerButton = new JButton("Dinner");

        // Add an ActionListener to the "Dinner" button
        dinnerButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // Open the Dinner frame
              Dinner dinnerFrame = new Dinner();
              dinnerFrame.setVisible(true);
          }
      });


        // Add the "Dinner" button to the button panel
        buttonPanel.add(dinnerButton);

        // Add the button panel to the center of the JFrame
        add(buttonPanel, BorderLayout.CENTER);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new RestaurantMenuGUI();
    }
}
