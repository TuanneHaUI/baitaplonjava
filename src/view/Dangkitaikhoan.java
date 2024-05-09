package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginControler;
import model.LuuFlieTaiKhoan;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Dangkitaikhoan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TaiKhoan;
	private JTextField textField_Email;
	private JPasswordField passwordField_MatKhau;
	private JPasswordField passwordField_MatKhau1;
	private LuuFlieTaiKhoan luuFlieTaiKhoan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangkitaikhoan frame = new Dangkitaikhoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dangkitaikhoan() {
		LoginControler ac = new LoginControler(this);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From Register");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(261, 40, 205, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_TaiKhoan = new JLabel("Username");
		lblNewLabel_TaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_TaiKhoan.setBounds(61, 100, 126, 46);
		contentPane.add(lblNewLabel_TaiKhoan);
		
		JLabel lblNewLabel_Email = new JLabel("Email");
		lblNewLabel_Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_Email.setBounds(61, 175, 126, 46);
		contentPane.add(lblNewLabel_Email);
		
		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setBounds(169, 109, 148, 37);
		contentPane.add(textField_TaiKhoan);
		textField_TaiKhoan.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(169, 184, 148, 37);
		contentPane.add(textField_Email);
		
		JLabel lblNewLabel_MatKhau = new JLabel("Password");
		lblNewLabel_MatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_MatKhau.setBounds(381, 100, 126, 46);
		contentPane.add(lblNewLabel_MatKhau);
		
		JLabel lblNewLabel_MatKhau1 = new JLabel("Password");
		lblNewLabel_MatKhau1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_MatKhau1.setBounds(381, 175, 126, 46);
		contentPane.add(lblNewLabel_MatKhau1);
		
		passwordField_MatKhau = new JPasswordField();
		passwordField_MatKhau.setBounds(521, 100, 148, 40);
		contentPane.add(passwordField_MatKhau);
		
		passwordField_MatKhau1 = new JPasswordField();
		passwordField_MatKhau1.setBounds(521, 181, 148, 40);
		contentPane.add(passwordField_MatKhau1);
		
		JButton btnNewButton_DangKi = new JButton("Đăng kí");
		btnNewButton_DangKi.addActionListener(ac);
		btnNewButton_DangKi.setBounds(287, 248, 120, 40);
		contentPane.add(btnNewButton_DangKi);
	}
	public boolean thucHienDangKi() {
		boolean ktra = false;
		String username = textField_TaiKhoan.getText();
        String email = textField_Email.getText();
        String password = new String(passwordField_MatKhau.getPassword());
        String confirmPassword = new String(passwordField_MatKhau1.getPassword());
        if(password.equals(confirmPassword)) {
        	luuFlieTaiKhoan.writeToFile(username, email, confirmPassword);
        	JOptionPane.showMessageDialog(this, "Đăng kí thành công","Đăng kí",
					JOptionPane.INFORMATION_MESSAGE);
        	ktra = true;
        }else {
        	JOptionPane.showMessageDialog(this, "Không đăng kí được","Đăng kí",
					JOptionPane.INFORMATION_MESSAGE);
        }
        return ktra;
	}
	
}
