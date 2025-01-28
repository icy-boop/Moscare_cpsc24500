import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SplatPanel extends JPanel {
    private ArrayList<Circle> circles; // Changed to store multiple circles

    public SplatPanel() {
        circles = new ArrayList<>();
        setPreferredSize(new Dimension(300, 200));
        setBackground(Color.black);
    }

    //-----------------------------------------------------------------
    //  Allows user to add circles based on input
    //-----------------------------------------------------------------
    public void addCirclesFromUserInput() {
        String input;
        do {
            input = JOptionPane.showInputDialog("Enter circle diameter, color (red, green, blue), x and y coordinates separated by spaces (or 'exit' to finish):");

            if (input != null && !input.equalsIgnoreCase("exit")) {
                try {
                    String[] parts = input.split(" ");
                    int diameter = Integer.parseInt(parts[0]);
                    Color color = Color.decode(parts[1]);
                    int x = Integer.parseInt(parts[2]);
                    int y = Integer.parseInt(parts[3]);

                    // Create and add the circle
                    circles.add(new Circle(diameter, color, x, y));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid values.");
                }
            }
        } while (input != null && !input.equalsIgnoreCase("exit"));
    }

    //-----------------------------------------------------------------
    //  Draws this panel by requesting that each circle draw itself.
    //-----------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        for (Circle circle : circles) {
            circle.draw(page);      
        }
    }
}
