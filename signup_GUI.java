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
    JButton logiButton;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;



    
  
        
    
    public signup_GUI(){
        Font labelFont = new Font("Arial", Font.BOLD, 25);


        //Frame
        frame = new JFrame("Sign Up GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,350);

        frame.setLayout(new BorderLayout());

       
        
       
   

        m = new JLabel("Test");
        m.setFont(labelFont);

   


        
        usernameLabel = new JLabel("Please enter a username:");

        username1 = new JTextField();
        username1.setColumns(20);
        

        passwordLabel = new JLabel("Please create a password:");
        password1 = new JPasswordField();
        password1.setColumns(20);
        password1.setEchoChar('\u2022');

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






        logiButton = new JButton("Login");

        logiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Login_GUI user = new Login_GUI();
               Window window = SwingUtilities.windowForComponent((Component) e.getSource());
               window.dispose();       
                    }
        });


        signupButton = new JButton("Sign Up");


        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username1.getText();
                char[] passwordChars = password1.getPassword();
                String password = new String(passwordChars); 
                
                
                UserCredentials userCredentials = new UserCredentials(username, password);

                userDataFile.saveUserCredentials(userCredentials);

                UserCredentials retrievedUserCredentials = userDataFile.getUserCredentials(username);

                System.out.println("Retrieved user credentials: " + retrievedUserCredentials.getUsername() + "," + retrievedUserCredentials.getPassword());




                    }
        });


        // Panel
        panel = new JPanel();
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
        c.gridwidth = 2;
       panel.add(signupButton,c);
       c.gridx=1;
       c.gridy = 3;
       c.gridwidth = 2;
       panel.add(logiButton,c);
       
      
 

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
    



}


