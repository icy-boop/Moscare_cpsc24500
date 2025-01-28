import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Splat {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Splat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Get circle details from the user
        SplatPanel panel = new SplatPanel();
        panel.addCirclesFromUserInput();
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
