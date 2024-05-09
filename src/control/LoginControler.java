package control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Dangkitaikhoan;
import view.Login;

public class LoginControler implements ActionListener{
private Login lg;
private Dangkitaikhoan dk;
	public LoginControler(Login lg) {
	super();
	this.lg = lg;
}
	
	public LoginControler(Dangkitaikhoan dk) {
		super();
		this.dk = dk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String laydulieu = e.getActionCommand();
		if(laydulieu.equalsIgnoreCase("đăng nhập")) {
			this.lg.thucHienDangNhap();
		}if(laydulieu.equalsIgnoreCase("đăng kí"))
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						lg.dispose(); 
						Dangkitaikhoan frame = new Dangkitaikhoan();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			if(this.dk.thucHienDangKi()==true) {
				dk.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login frame = new Login();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
	}

}
