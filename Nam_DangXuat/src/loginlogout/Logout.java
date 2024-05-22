package loginlogout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends JFrame {
	private JButton logoutButton;
	private JButton cancelButton;
	
	public Logout() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Logout");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 100);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
       
        JLabel a = new JLabel("Bạn chắc chứ");
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(a, constraints);

        logoutButton = new JButton("Logout");
        logoutButton.setEnabled(true);
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(logoutButton, constraints);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(true);
        constraints.gridx = 4;
        constraints.gridy = 3;
        add(cancelButton, constraints);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout logic here
                logout();
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout logic here
                cancel();
            }
        });
    }

    private void logout() {

        // Show another screen (e.g., MainScreen)
        Login login = new Login();
        login.setVisible(true);
    }
    
    private void cancel() {
    	MainScreen m = new MainScreen();
    	m.setVisible(true);
    }
}
