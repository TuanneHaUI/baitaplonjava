package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginControler;
import model.LuuFlieTaiKhoan;
import test.Test;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.net.URI;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 870, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_TaiKhoan = new JLabel("Username");
		lblNewLabel_TaiKhoan.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_TaiKhoan.setBounds(503, 20, 126, 46);
		contentPane.add(lblNewLabel_TaiKhoan);
		
		JLabel lblNewLabel_Email = new JLabel("Email");
		lblNewLabel_Email.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_Email.setBounds(503, 104, 126, 46);
		contentPane.add(lblNewLabel_Email);
		
		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setBounds(503, 57, 253, 37);
		contentPane.add(textField_TaiKhoan);
		textField_TaiKhoan.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(505, 146, 251, 37);
		contentPane.add(textField_Email);
		
		JLabel lblNewLabel_MatKhau = new JLabel("Repeat Password");
		lblNewLabel_MatKhau.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_MatKhau.setBounds(503, 287, 181, 46);
		contentPane.add(lblNewLabel_MatKhau);
		
		JLabel lblNewLabel_MatKhau1 = new JLabel("Password");
		lblNewLabel_MatKhau1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_MatKhau1.setBounds(503, 193, 126, 46);
		contentPane.add(lblNewLabel_MatKhau1);
		
		passwordField_MatKhau = new JPasswordField();
		passwordField_MatKhau.setBounds(503, 325, 253, 40);
		contentPane.add(passwordField_MatKhau);
		
		passwordField_MatKhau1 = new JPasswordField();
		passwordField_MatKhau1.setBounds(503, 237, 253, 40);
		contentPane.add(passwordField_MatKhau1);
		
		JButton btnNewButton_DangKi = new JButton("SignUp");
		btnNewButton_DangKi.setForeground(new Color(255, 0, 0));
		btnNewButton_DangKi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DangKi.addActionListener(ac);
		btnNewButton_DangKi.setBounds(503, 392, 253, 40);
		contentPane.add(btnNewButton_DangKi);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 467, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\ảnh đăng kí.jpg"));
		URL link = Dangkitaikhoan.class.getResource("ảnh đăng kí.jpg");
		ImageIcon icon = new ImageIcon(link);
		Image image = icon.getImage().getScaledInstance(467, 476, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(0, 0, 467, 476);
		panel.add(lblNewLabel);
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
