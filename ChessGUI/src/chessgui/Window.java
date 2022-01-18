package chessgui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;

public class Window extends JFrame {
    public Component component;
    public Window()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("2-Player Chess");
        this.setResizable(false);
        component = new Board();
        this.add(component, BorderLayout.CENTER);
        
        this.setLocation(700, 300);
        this.pack();
        this.setVisible(true);
    }
}
