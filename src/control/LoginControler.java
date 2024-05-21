package control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Dangkitaikhoan;
import view.Giaodien;
import view.Login;
import view.Quanlitaikhoan;
import view.SlidingMenuDemo;

public class LoginControler implements ActionListener {
    private Login lg;
    private Dangkitaikhoan dk;
    private SlidingMenuDemo sd;
    private Quanlitaikhoan ql;
    public LoginControler(Quanlitaikhoan ql) {
		super();
		this.ql = ql;
	}

	public LoginControler(SlidingMenuDemo sd) {
        super();
        this.sd = sd;
    }

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
        if (laydulieu.equalsIgnoreCase("đăng nhập")) {
            this.lg.thucHienDangNhap();
        } else if (laydulieu.equalsIgnoreCase("đăng kí")) {
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
        } else if (this.dk != null && this.dk.thucHienDangKi() == true) {
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
        } else if (laydulieu.equalsIgnoreCase("Quản lí nhân viên")) {
            sd.dispose();
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
        }else if(laydulieu.equalsIgnoreCase("Đăng xuất")) {
        	int luaChon = JOptionPane.showConfirmDialog(sd, "Bạn có chắc chắn muốn đăng xuất chương trình không?",
    				"Đăng xuất", JOptionPane.YES_NO_OPTION);
        	if(luaChon == JOptionPane.YES_OPTION) {
        		sd.dispose();// đóng cửa sổ hiện tại
        		 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             Login lg = new Login();
                             lg.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
        	}
        	
        }else if(laydulieu.equalsIgnoreCase("quản lí tài khoản")) {
        	sd.dispose();// đóng cửa sổ hiện tại
        	 EventQueue.invokeLater(new Runnable() {
                 public void run() {
                     try {
                         Quanlitaikhoan frame = new Quanlitaikhoan();
                         frame.setVisible(true);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                 }
             });
        }else if(laydulieu.equalsIgnoreCase("Quay lại")) {
        	ql.dispose();// đóng cửa sổ hiện tại
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
        }
    }
}
