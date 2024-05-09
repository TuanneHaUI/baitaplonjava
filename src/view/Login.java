package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginControler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login() {
		LoginControler ac = new LoginControler(this);
		setResizable(false);// cố định cửa số không cho phóng to
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 343);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel_Login = new JLabel("From Login");
		lblNewLabel_Login.setForeground(Color.CYAN);
		lblNewLabel_Login.setBackground(Color.WHITE);
		lblNewLabel_Login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_Login.setBounds(201, 38, 136, 25);
		contentPane.add(lblNewLabel_Login);

		lblNewLabel_TaiKhoan = new JLabel("Username");
		lblNewLabel_TaiKhoan.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblNewLabel_TaiKhoan.setBounds(74, 88, 99, 25);
		contentPane.add(lblNewLabel_TaiKhoan);

		lblNewLabel_MatKhau = new JLabel("Password");
		lblNewLabel_MatKhau.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblNewLabel_MatKhau.setBounds(74, 156, 99, 25);
		contentPane.add(lblNewLabel_MatKhau);

		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setBounds(212, 85, 177, 36);
		contentPane.add(textField_TaiKhoan);
		textField_TaiKhoan.setColumns(10);

		passwordField_MatKhau = new JPasswordField();
		passwordField_MatKhau.setBounds(212, 153, 177, 36);
		contentPane.add(passwordField_MatKhau);

		btnNewButton_DangNhap = new JButton("Đăng nhập");
		btnNewButton_DangNhap.addActionListener(ac);
		btnNewButton_DangNhap.setBackground(Color.WHITE);
		btnNewButton_DangNhap.setBounds(74, 220, 85, 36);
		contentPane.add(btnNewButton_DangNhap);

		btnNewButton_DangKi = new JButton("Đăng kí");
		btnNewButton_DangKi.addActionListener(ac);
		btnNewButton_DangKi.setBackground(Color.WHITE);
		btnNewButton_DangKi.setBounds(324, 220, 85, 36);
		contentPane.add(btnNewButton_DangKi);
	}

//	public void thucHienDangNhap() {
//		String tenTaiKhoan = textField_TaiKhoan.getText();
//		String matKhau = passwordField_MatKhau.getText();
//		
//		if (tenTaiKhoan.equals("") || matKhau.equals("")) {
//			JOptionPane.showMessageDialog(this, "Bạn chưa nhập tài khoản hay mật khẩu", "Title Example",
//					JOptionPane.INFORMATION_MESSAGE);
//		} else if (tenTaiKhoan.equals("Lophocjava") || matKhau.equals("Lophocjava")) {
//			JOptionPane.showMessageDialog(this, "Đăng nhập thành công.","Đăng nhập",
//					JOptionPane.INFORMATION_MESSAGE);
//			dispose(); // đóng của sổ login
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						Giaodien frame = new Giaodien();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}
//		 boolean loginSuccessful = checkCredentials(tenTaiKhoan, matKhau);
//		 if(loginSuccessful) {
//			 JOptionPane.showMessageDialog(this, "Đăng nhập thành công.", "Đăng nhập",
//	                    JOptionPane.INFORMATION_MESSAGE);
//	            dispose(); // Đóng cửa sổ đăng nhập
//	            EventQueue.invokeLater(new Runnable() {
//	                public void run() {
//	                    try {
//	                        Giaodien frame = new Giaodien();
//	                        frame.setVisible(true);
//	                    } catch (Exception e) {
//	                        e.printStackTrace();
//	                    }
//	                }
//	            });
//		 }else {
//				JOptionPane.showMessageDialog(this, "Nhập sai tài khoản hay mật khẩu", "Title Example",
//						JOptionPane.INFORMATION_MESSAGE);
//				textField_TaiKhoan.setText("");
//				passwordField_MatKhau.setText("");
//			}
//
//	}
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
	                    Giaodien frame = new Giaodien();
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
	                        Giaodien frame = new Giaodien();
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
