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
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // center the frame on the screen
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(255, 165, 0));

        p = new JLabel("Welcome to our app");
        p.setFont(labelFont);
        p.setForeground(new Color(235, 52, 88));
        p.setHorizontalAlignment(JLabel.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));

        login = new JButton("Login");
        login.setPreferredSize(new Dimension(150, 50));
        login.setFont(new Font("Arial", Font.BOLD, 20));
        login.setBackground(new Color(235, 52, 88));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        login.setFocusPainted(false);

        signup = new JButton("Sign Up");
        signup.setPreferredSize(new Dimension(150, 50));
        signup.setFont(new Font("Arial", Font.BOLD, 20));
        signup.setBackground(new Color(235, 52, 88));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        signup.setFocusPainted(false);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_GUI user = new Login_GUI();
               // frame.dispose();
               Window window = SwingUtilities.windowForComponent((Component) e.getSource());
               window.dispose(); 
            }
        });

        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup_GUI user = new signup_GUI();
                //frame.dispose();
                Window window = SwingUtilities.windowForComponent((Component) e.getSource());
                window.dispose(); 
            }
        });

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.insets= new Insets(0, 0, 50, 0);
        panel.add(p, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets= new Insets(0, 0, 10, 0);
        panel.add(login, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(signup, c);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
