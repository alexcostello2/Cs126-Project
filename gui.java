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
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,250);
        frame.setLayout(new BorderLayout());

        p = new JLabel("                                               Would you like to Login or Sign Up?");
        p.setFont(labelFont);

        login = new JButton("Login");
        signup = new JButton("Sign Up");

        
        
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Login_GUI user = new Login_GUI();
               Window window = SwingUtilities.windowForComponent((Component) e.getSource());
               window.dispose();
            }
        });

        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.out.println("To be made");
               System.exit(1);
            }
        });



        panel = new JPanel();


        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(10, 0, 0, 20);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(p,c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(login, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(signup,c);
      
        
        














        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);






    }












    public static void main(String[] args){
        gui g = new gui();
    }
}


