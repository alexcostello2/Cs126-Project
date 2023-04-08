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
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;



    
    public Login_GUI(){


        Font labelFont = new Font("Arial", Font.BOLD, 25);

        //Frame
        frame = new JFrame("Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,350);
        
    //Basic GUI git
    public Login_GUI(){

        //Frame
        frame = new JFrame("Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,250);

        frame.setLayout(new BorderLayout());

       
        
       
   

        m = new JLabel("Test");
        m.setFont(labelFont);

   


        
        usernameLabel = new JLabel("Username:");

        username1 = new JTextField();
        username1.setColumns(20);
        

        passwordLabel = new JLabel("Password:");
        password1 = new JPasswordField();
        password1.setColumns(20);
        password1.setEchoChar('\u2022');

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







        loginbutton = new JButton("Login");


        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username1.getText();
                char[] passwordChars = password1.getPassword();
                String password = new String(passwordChars);
                if (password.equals("password")){
                    System.out.println("Password accepted");
                    System.exit(1);
                }else{
                    System.out.println("Password Invalid");
                }
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
       panel.add(loginbutton,c);
       
      
 

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

        //Tempory just to test the GUI in this file
     public static void main(String[] args){
        Login_GUI g = new Login_GUI();
    }

}
