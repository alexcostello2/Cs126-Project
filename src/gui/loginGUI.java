package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import model.UserCredentials;
import model.userDataFile;


public class loginGUI {
    JFrame frame; 
    JTextField username1;
    JPasswordField password1;
    JLabel text;
    JButton loginbutton;
    JButton signupButton1;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;



    
  
        
    //Constructor
    public loginGUI(){
        // Fonts
        Font titelfont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font inputFont = new Font("Arial", Font.BOLD, 14);
        // Colors 
        Color bgColor = new Color(220, 220, 223);
        Color fgColor = new Color(0, 0, 0);
        Color btnColor = new Color(0, 128, 255);

        //Frame
        frame = new JFrame("Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,350);
        frame.setLocationRelativeTo(null); // center the frame on the screen
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(bgColor);

       
        
       
        // Welcome Text
        text = new JLabel("Welcome!");
        text.setFont(titelfont);
        text.setForeground(fgColor);

   


        // Username Label
        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(fgColor);
        usernameLabel.setFont(labelFont);

        // Username text field
        username1 = new JTextField();
        username1.setColumns(20);
        username1.setFont(inputFont);


        username1.setBorder(BorderFactory.createCompoundBorder(
            username1.getBorder(),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        
        // Password Label
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(fgColor);;
        passwordLabel.setFont(labelFont);

        // Password text field
        password1 = new JPasswordField();
        password1.setColumns(20);
        password1.setEchoChar('\u2022'); // sets it so it does no show password when typing it 
        password1.setFont(inputFont);;
        password1.setBorder(BorderFactory.createCompoundBorder(
            password1.getBorder(),
            BorderFactory.createEmptyBorder(10, 10, 10, 10))); 




        //Method so when you over entering password you can click enter instead of having to click the button
        password1.addKeyListener(new KeyListener() {
            
            public void keyTyped(KeyEvent e) {}

            
            public void keyPressed(KeyEvent e) {}

            
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginbutton.doClick();
                }
            }
        });




        // Signup Button
        signupButton1 = new JButton("Sign Up");
        signupButton1.setBackground(btnColor);
        signupButton1.setForeground(fgColor);
        signupButton1.setFocusPainted(false);
        signupButton1.setFont(inputFont);

        // Login Button
        loginbutton = new JButton("Login");
        loginbutton.setBackground(btnColor);
        loginbutton.setForeground(fgColor);
        loginbutton.setFont(inputFont);
        loginbutton.setFocusPainted(false);


        // Adding Action for when you press Login
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username1.getText();

                char[] passwordChars = password1.getPassword();
                String password = new String(passwordChars);


                if(username.equals("Admin") && password.equals("Admin")){  // Used to bypass sign in system for owners
                    System.out.println("You have succesfully logged in as an Admin!");
                    Window window = SwingUtilities.windowForComponent((Component) e.getSource()); // closing frame to open new GUI
                    window.dispose();
                    new RestaurantMenuGUI(); // Call to the main menu GUI 
                }else{
                    UserCredentials retrievedUserCredentials = userDataFile.getUserCredentials(username);  
                
                    if (retrievedUserCredentials != null){
                        if (retrievedUserCredentials.getPassword().equals(password)) {
                            System.out.println("Login successful!");
                            Window window = SwingUtilities.windowForComponent((Component) e.getSource());
                            window.dispose();
                            new RestaurantMenuGUI();
                        }else{
                            System.out.println("Invalid password");
                        } 
                    }else{
                        System.out.println("User credentials not found for user: " + username);
    
                    }
                    
    
    
    




                }
            
            }
        });



        // Action when you press sign up button it takes you to sign up GUI
        signupButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new signupGUI();
               Window window = SwingUtilities.windowForComponent((Component) e.getSource());
               window.dispose(); 
            }
        });
        
      

        // Panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);


        // Adding Everything
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(20, 20, 20, 20);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(text,c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(usernameLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(username1,c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(passwordLabel,c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(password1,c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
       panel.add(loginbutton,c);
       c.gridx = 1;
       c.gridy = 3;
       c.gridwidth = 3;
       panel.add(signupButton1, c);
       
       JPanel transparentPanel = new JPanel(new BorderLayout());
       transparentPanel.setOpaque(false);
       transparentPanel.add(panel);
       
       // Create the gradient panel with the button panel inside it
       JPanel gradientPanel = new JPanel(new BorderLayout()) {
           @Override
           protected void paintComponent(Graphics g) {
               Graphics2D g2d = (Graphics2D) g;
       
               Color color1 = new Color(255, 255, 255, 0);
               Color color2 = new Color(128, 128, 128, 255);
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
