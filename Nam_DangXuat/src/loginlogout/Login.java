package loginlogout;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Đăng nhập", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }
}
