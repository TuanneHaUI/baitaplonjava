package loginlogout;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Xin chào", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }
}