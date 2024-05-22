package loginlogout;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Logout logout = new Logout();
                logout.setVisible(true);
            }
        });
    }
}
