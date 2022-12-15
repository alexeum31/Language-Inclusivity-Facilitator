import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {
    
    public static void main(String[] args) {
        //gets dimensions of screen
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        double width = (double)size.getWidth();
        double height = (double)size.getHeight();
       

        // Creates a GUI window
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout()); // sets to flow layout
        frame.setTitle("Racist Terminology Remover"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits frame when closed
        frame.setSize((int)width, (int)height); // sets size of frame
        frame.setVisible(true); // makes frame visible
        // creates JTextArea
        JTextArea textarea = new JTextArea();
        textarea.setBounds(0,(int)height/10, (int)(width),(int) height);
        textarea.setLineWrap(true);
        frame.add(textarea);

        // creates image icon
        // border needs fixing
        ImageIcon logo = new ImageIcon("logo.png");
        frame.setIconImage(logo.getImage());
        
        // creates actionPerformed method
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //should call string modifier function
            System.out.println(textarea.getText());
            }
        };
        // sets size of button 
        JButton button = new JButton();
        button.setBounds((int)(width/1.5), 0, (int)width/15, (int)height/15);
        button.setText("Click me");
        button.addActionListener(listener);
        frame.add(button);


        // creates gray title panel
        JPanel panel = new JPanel(); //creates a panel
        panel.setBackground(Color.gray); //sets the color to gray
        frame.setLayout(new BorderLayout()); // creates a BorderLayout
        panel.setPreferredSize(new Dimension((int)width, (int) height/10)); // sets the size of the panel
        frame.add(panel, BorderLayout.NORTH); // puts the border at the top
        JLabel titlelabel = new JLabel("Racist Terminology Remover");
        titlelabel.setFont(new Font("Verdana", 1, 30));
        panel.add(titlelabel);
        frame.setVisible(true);
    }
}

