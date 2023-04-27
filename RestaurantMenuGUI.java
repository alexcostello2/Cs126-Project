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
        setSize(700, 550);

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

        // Create a transparent panel for the button panel
        JPanel transparentPanel = new JPanel();
        transparentPanel.setOpaque(false);
        transparentPanel.add(buttonPanel);

        // Create the gradient panel with the button panel inside it
        JPanel gradientPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                Color color1 = new Color(255, 255, 255);
                Color color2 = new Color(128, 128, 128);
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.add(transparentPanel, BorderLayout.CENTER);

        // Move the button panel to the middle center of the transparent panel
        transparentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 1;
        transparentPanel.add(buttonPanel, gbc);

        // Set the content pane to the gradient panel
        setContentPane(gradientPanel);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new RestaurantMenuGUI();
    }
}

