import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;



public class Login_GUI {
    JFrame frame; 
    JTextField username1;
    JPasswordField password1;
    JLabel m;
    JButton loginbutton;
    JButton signupButton1;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;



    
  
        
    
    public Login_GUI(){
        Font titelfont = new Font("Arial", Font.BOLD, 25);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font inputFont = new Font("Arial", Font.PLAIN, 16);

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

       
        
       
   

        m = new JLabel("Test");
        m.setFont(titelfont);
        m.setForeground(fgColor);

   


        
        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(fgColor);
        usernameLabel.setFont(labelFont);


        username1 = new JTextField();
        username1.setColumns(20);
        username1.setFont(inputFont);

        

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(fgColor);;
        passwordLabel.setFont(labelFont);


        password1 = new JPasswordField();
        password1.setColumns(20);
        password1.setEchoChar('\u2022');
        password1.setFont(inputFont);;

        //Method so when you over entering password you can click enter instead of having to click the button
        password1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginbutton.doClick();
                }
            }
        });





        signupButton1 = new JButton("Sign Up");
        signupButton1.setBackground(btnColor);
        signupButton1.setForeground(fgColor);
        signupButton1.setFocusPainted(false);

        loginbutton = new JButton("Login");
        loginbutton = new JButton("Login");
        loginbutton.setBackground(btnColor);
        loginbutton.setForeground(fgColor);
        loginbutton.setFont(inputFont);


        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username1.getText();

                char[] passwordChars = password1.getPassword();
                String password = new String(passwordChars);
            
                UserCredentials retrievedUserCredentials = userDataFile.getUserCredentials(username);
                
                if (retrievedUserCredentials != null){
                    if (retrievedUserCredentials.getPassword().equals(password)) {
                        System.out.println("Login successful!");
                        System.exit(1);
                    }else{
                        System.out.println("Invalid password");
                    } 
                }else{
                    System.out.println("User credentials not found for user: " + username);

                }
                



            }
        });



        
        signupButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               signup_GUI user = new signup_GUI();
               Window window = SwingUtilities.windowForComponent((Component) e.getSource());
               window.dispose(); 
              // frame.dispose();      
            }
        });
        
      

        // Panel
        panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(20, 30, 30, 20);
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
       panel.add(loginbutton,c);
       c.gridx = 1;
       c.gridy = 3;
       c.gridwidth = 3;
       panel.add(signupButton1, c);
       
      
 

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
    

}
