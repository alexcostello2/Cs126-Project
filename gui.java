import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    JFrame frame;
    JPanel panel;
    JButton signup;
    JButton login;
    JLabel p;

    public gui(){
        Font labelFont = new Font("Arial", Font.BOLD, 32);
        // Frame setup
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // center the frame on the screen
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(255, 165, 0));
        // Welcome Text
        p = new JLabel("Welcome!");
        p.setFont(labelFont);
        p.setForeground(new Color(235, 52, 88));
        p.setHorizontalAlignment(JLabel.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        // Login button setup
        login = new JButton("Login");
        login.setPreferredSize(new Dimension(150, 50));
        login.setFont(new Font("Arial", Font.BOLD, 20));
        login.setBackground(new Color(235, 52, 88));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        login.setFocusPainted(false);
        // Signup button setup
        signup = new JButton("Sign Up");
        signup.setPreferredSize(new Dimension(150, 50));
        signup.setFont(new Font("Arial", Font.BOLD, 20));
        signup.setBackground(new Color(235, 52, 88));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        signup.setFocusPainted(false);

        // When you press the login in button it takes you to login GUI
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new loginGUI();
               Window window = SwingUtilities.windowForComponent((Component) e.getSource());
               window.dispose(); 
            }
        });
        // When you press signup button it takes you to signup GUI
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new signupGUI();
                Window window = SwingUtilities.windowForComponent((Component) e.getSource());
                window.dispose(); 
            }
        });


      
       
    // Create a transparent panel for the button panel
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.setOpaque(false);
    
    // Adding everything
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.insets = new Insets(0, 0, 50, 0);
    panel.add(p, c);

    c.gridx = 0;
    c.gridy = 1;
    c.insets = new Insets(0, 0, 10, 0);
    panel.add(login, c);

    c.gridx = 0;
    c.gridy = 2;
    panel.add(signup, c);

    JPanel transparentPanel = new JPanel(new BorderLayout());
    transparentPanel.setOpaque(false);
    transparentPanel.add(panel);

    // Create the gradient panel with the button panel inside it
    JPanel gradientPanel = new JPanel(new BorderLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            Color color1 = new Color(0, 255, 255, 0);
            Color color2 = new Color(255, 128, 128, 255);
            GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    gradientPanel.add(transparentPanel, BorderLayout.CENTER);

    // Set the gradient panel as the content pane of the JFrame
    frame.setContentPane(gradientPanel);

    // Make the JFrame visible
    frame.setVisible(true);


}  

}

