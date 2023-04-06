import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    JFrame frame; 
    JTextField username1;
    JPasswordField password1;
    JButton b;
    JPanel panel;
    JLabel passwordLabel;
    JLabel usernameLabel;

    //Basic GUI git
    Login_GUI(){
        frame = new JFrame("Login GUI");
        
        usernameLabel = new JLabel("Username:");
        username1 = new JTextField();
        
        passwordLabel = new JLabel("Password:");
        password1 = new JPasswordField();
        password1.setEchoChar('\u2022');

        b = new JButton("Login");

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = username1.getText();
                char[] passwordChars = password1.getPassword();
                String password = new String(passwordChars);
                System.out.println("Username: " + username + ", Password: " + password);
            }
        });


        // Panel
        panel = new JPanel(new GridLayout(3,2));

        panel.add(usernameLabel);
        panel.add(username1);
        panel.add(passwordLabel);
        panel.add(password1);
        panel.add(b);

        




        //Frame
        frame.setLayout(new BorderLayout());

        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setTitle("Menu GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
