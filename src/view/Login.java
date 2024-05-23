package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginControler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TaiKhoan;
	private JPasswordField passwordField_MatKhau;
	private JLabel lblNewLabel_Login;
	private JLabel lblNewLabel_TaiKhoan;
	private JLabel lblNewLabel_MatKhau;
	private JButton btnNewButton_DangNhap;
	private JButton btnNewButton_DangKi;
	private Component frame;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		LoginControler ac = new LoginControler(this);
		this.setTitle("Đăng nhập");
		setResizable(false);// cố định cửa số không cho phóng to
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 347);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel_Login = new JLabel("From Login");
		lblNewLabel_Login.setForeground(Color.CYAN);
		lblNewLabel_Login.setBackground(Color.WHITE);
		lblNewLabel_Login.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_Login.setBounds(628, 31, 136, 46);
		contentPane.add(lblNewLabel_Login);

		lblNewLabel_TaiKhoan = new JLabel("Username");
		lblNewLabel_TaiKhoan.setToolTipText("");
		lblNewLabel_TaiKhoan.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblNewLabel_TaiKhoan.setBounds(479, 90, 99, 25);
		contentPane.add(lblNewLabel_TaiKhoan);

		lblNewLabel_MatKhau = new JLabel("Password");
		lblNewLabel_MatKhau.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblNewLabel_MatKhau.setBounds(479, 158, 99, 25);
		contentPane.add(lblNewLabel_MatKhau);

		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setBounds(617, 87, 177, 36);
		contentPane.add(textField_TaiKhoan);
		textField_TaiKhoan.setColumns(10);

		passwordField_MatKhau = new JPasswordField();
		passwordField_MatKhau.setBounds(617, 155, 177, 36);
		contentPane.add(passwordField_MatKhau);

		btnNewButton_DangNhap = new JButton("Login");
		btnNewButton_DangNhap.addActionListener(ac);
		btnNewButton_DangNhap.setBackground(Color.WHITE);
		btnNewButton_DangNhap.setBounds(558, 222, 85, 36);
		contentPane.add(btnNewButton_DangNhap);

		btnNewButton_DangKi = new JButton("Register");
		btnNewButton_DangKi.addActionListener(ac);
		btnNewButton_DangKi.setBackground(Color.WHITE);
		btnNewButton_DangKi.setBounds(729, 222, 85, 36);
		contentPane.add(btnNewButton_DangKi);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 455, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\ảnh đẹp login.png"));
		 URL link = Dangkitaikhoan.class.getResource("ảnh đẹp login.png");
		ImageIcon icon = new ImageIcon(link);
		Image image = icon.getImage().getScaledInstance(455, 310, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(image));

		lblNewLabel.setBounds(0, 0, 455, 310);
		panel.add(lblNewLabel);
	}


	public void thucHienDangNhap() {
	    String tenTaiKhoan = textField_TaiKhoan.getText();
	    String matKhau = passwordField_MatKhau.getText();

	    if (tenTaiKhoan.equals("") || matKhau.equals("")) {
	        JOptionPane.showMessageDialog(this, "Bạn chưa nhập tài khoản hay mật khẩu", "Title Example",
	                JOptionPane.INFORMATION_MESSAGE);
	    } else if (tenTaiKhoan.equals("Lophocjava") && matKhau.equals("Lophocjava")) {
	        JOptionPane.showMessageDialog(this, "Đăng nhập thành công.","Đăng nhập",
	                JOptionPane.INFORMATION_MESSAGE);
	        dispose(); // Đóng cửa sổ đăng nhập
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	 SlidingMenuDemo frame = new SlidingMenuDemo();
	                     frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    } else {
	        boolean loginSuccessful = checkCredentials(tenTaiKhoan, matKhau);
	        if (loginSuccessful) {
	            JOptionPane.showMessageDialog(this, "Đăng nhập thành công.", "Đăng nhập",
	                    JOptionPane.INFORMATION_MESSAGE);
	            dispose(); // Đóng cửa sổ đăng nhập
	            EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                    	 SlidingMenuDemo frame = new SlidingMenuDemo();
	                         frame.setVisible(true);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            });
	        } else {
	            JOptionPane.showMessageDialog(this, "Nhập sai tài khoản hay mật khẩu", "Title Example",
	                    JOptionPane.INFORMATION_MESSAGE);
	            textField_TaiKhoan.setText("");
	            passwordField_MatKhau.setText("");
	        }
	    }
	}

	private boolean checkCredentials(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\hihi.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length >= 2) {
                    String storedUsername = parts[1].trim();
                    if (storedUsername.equals(username)) {
                        // Đọc mật khẩu và so sánh
                        line = reader.readLine();
                        parts = line.split(": ");
                        if (parts.length >= 2) {
                            String storedPassword = parts[1].trim();
                            if (storedPassword.equals(password)) {
                                reader.close();
                                return true;
                            }
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
