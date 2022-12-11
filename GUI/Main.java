import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Main {
    
    public static void main(String[] args) {
        // Creates a GUI window
        JFrame frame = new JFrame();
        frame.setTitle("Racist Terminology Remover"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits frame when closed
        frame.setSize(2000,1000); // sets size of frame
        frame.setVisible(true); // makes frame visible

        // creates image icon
        ImageIcon logo = new ImageIcon("logo.png");
        Border labelBorder = BorderFactory.createLineBorder(Color.black, 3);
        frame.setIconImage(logo.getImage());
        
        // creates gray title panel
        JPanel panel = new JPanel(); //creates a panel
        panel.setBackground(Color.gray); //sets the color to gray
        frame.setLayout(new BorderLayout()); // creates a BorderLayout
        panel.setPreferredSize(new Dimension(2000, 100)); // sets the size of the panel
        frame.add(panel,BorderLayout.NORTH); // puts the border at the top

        // adds text to the title panel
        JLabel titlelabel = new JLabel("Racist Terminology Remover");
        frame.add(titlelabel);
        titlelabel.setHorizontalTextPosition(JLabel.RIGHT);
        titlelabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        titlelabel.setIcon(logo);
        titlelabel.setBackground(Color.lightGray);
        titlelabel.setOpaque(true);
        titlelabel.setBorder(labelBorder);
        titlelabel.setVerticalAlignment(JLabel.TOP);
        titlelabel.setHorizontalAlignment(JLabel.CENTER);
    
        
        // creates button that should be pressed once completed
        JButton button = new JButton();
        button.setBounds(200, 100, 100, 50);
        frame.add(button);


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