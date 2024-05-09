package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Login;

public class LoginControler implements ActionListener{
private Login lg;
	public LoginControler(Login lg) {
	super();
	this.lg = lg;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String laydulieu = e.getActionCommand();
		if(laydulieu.equalsIgnoreCase("đăng nhập")) {
			lg.thucHienDangNhap();
		}
		
	}

}
