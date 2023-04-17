import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;



public class signup_GUI {
    JFrame frame; 
    JTextField username1;
    JPasswordField password1;
    JLabel m;
    

    JButton signupButton;
    JButton loginButton;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;



    
  
        
    
    public signup_GUI(){
        // Set up fonts and colors
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font inputFont = new Font("Arial", Font.PLAIN, 16);
        Color backgroundColor = new Color(220, 220, 220);
        Color buttonColor = new Color(0, 128, 255);
        Color buttonTextColor = Color.WHITE;


        //Frame
        frame = new JFrame("Sign Up GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,350);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setLocationRelativeTo(null); // center the frame on the screen
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

       
        
       
   

        m = new JLabel("Login");
        m.setFont(labelFont);

   


        
        usernameLabel = new JLabel("Please enter a username:");
        usernameLabel.setFont(labelFont);

        username1 = new JTextField();
        username1.setColumns(20);
        username1.setFont(inputFont);

        

        passwordLabel = new JLabel("Please create a password:");
        passwordLabel.setFont(labelFont);


        password1 = new JPasswordField();
        password1.setColumns(20);
        password1.setEchoChar('\u2022');
        password1.setFont(inputFont);


        //Method so when you over entering password you can click enter instead of having to click the button
        password1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    signupButton.doClick();
                }
            }
        });

        loginButton = new JButton("Login");
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(buttonTextColor);
        loginButton.setFocusPainted(false);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Login_GUI user = new Login_GUI();
              //frame.dispose(); 
              Window window = SwingUtilities.windowForComponent((Component) e.getSource());
              window.dispose();     
                    }
        });


        signupButton = new JButton("Sign Up");
        signupButton.setBackground(buttonColor);
        signupButton.setForeground(buttonTextColor);
        signupButton.setFocusPainted(false);


        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username1.getText();
                char[] passwordChars = password1.getPassword();
                String password = new String(passwordChars); 
                
                
                UserCredentials userCredentials = new UserCredentials(username, password);

                userDataFile.saveUserCredentials(userCredentials);

                UserCredentials retrievedUserCredentials = userDataFile.getUserCredentials(username);

              Login_GUI u = new Login_GUI();
                
              Window window = SwingUtilities.windowForComponent((Component) e.getSource());
              window.dispose(); 

                    }
        });


        // Panel
        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(20, 20, 20, 20);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(m,c);
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
       panel.add(signupButton,c);
       c.gridx=1;
       c.gridy = 3;
       c.gridwidth = 3;
       panel.add(loginButton,c);
       
      
 

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
    



}


