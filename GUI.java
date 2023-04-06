import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JFrame frame; 
    JTextField textField;
    JButton b;
    JPanel panel;

    //Basic GUI 
    GUI(){
        frame = new JFrame("Menu GUI");

        textField = new JTextField();
        
        b = new JButton("test");

        // Panel
        panel = new JPanel(new GridLayout(4,4));

        panel.add(b);

        




        //Frame
        frame.setLayout(new BorderLayout());

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setTitle("Menu GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
