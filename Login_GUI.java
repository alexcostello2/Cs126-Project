import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    JFrame frame; 
    JTextField username1;
    JPasswordField password1;
    JButton loginbutton;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;

    //Basic GUI git
    public Login_GUI(){

        //Frame
        frame = new JFrame("Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,250);
        frame.setLayout(new BorderLayout());

       
        
       
   
   

        
        usernameLabel = new JLabel("Username:");

        username1 = new JTextField();
        username1.setColumns(20);
        

        passwordLabel = new JLabel("Password:");
        password1 = new JPasswordField();
        password1.setColumns(20);
        password1.setEchoChar('\u2022');

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
        c.insets= new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(usernameLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(username1,c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel,c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(password1,c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(loginbutton,c);


        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}
