import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    // creates global JButton
    static JButton button = new JButton();

    // creates actionPerformed method
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.out.print("test");
        }
    }

    public static void main(String[] args) {
        // Creates a GUI window
        JFrame frame = new JFrame();
        frame.setTitle("Racist Terminology Remover"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits frame when closed
        frame.setSize(2000, 1000); // sets size of frame
        frame.setVisible(true); // makes frame visible

        // creates image icon
        // border needs fixing
        ImageIcon logo = new ImageIcon("logo.png");
        Border labelBorder = BorderFactory.createLineBorder(Color.black, 3);
        frame.setIconImage(logo.getImage());

        // sets size of button 
        button.setBounds(1200, 0, 100, 50);
        button.addActionListener(ActionListener);
        frame.add(button);


        // creates gray title panel
        JPanel panel = new JPanel(); //creates a panel
        panel.setBackground(Color.gray); //sets the color to gray
        frame.setLayout(new BorderLayout()); // creates a BorderLayout
        panel.setPreferredSize(new Dimension(2000, 100)); // sets the size of the panel
        frame.add(panel, BorderLayout.NORTH); // puts the border at the top
        JLabel titlelabel = new JLabel("Racist Terminology Remover");
        titlelabel.setFont(new Font("Verdana", 1, 30));
        panel.add(titlelabel);
        frame.setVisible(true);


        // // creates dialogue boxes
        // // this should be inserted into a conditional statement
        // JOptionPane.showMessageDialog(null, "insert message",
        // "A word has been flagged", JOptionPane.WARNING_MESSAGE);


    }
}

// test code- KeyListener
// public class MyFrame extends JFrame implements KeyListener {

//     public Myrame(){
//         this.addKeyListener(this);
//     }

// // Checks if the space bar is pressed.
// public void keyTyped(KeyEvent event) {
//     switch(event.getKeyChar()) {
//         case ' ': ;
//     }
//     }
// }
