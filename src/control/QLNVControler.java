package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Chucvu;
import model.Tinh;
import model.Nhanvien;
import view.Giaodien;

public class QLNVControler implements ActionListener{
private Giaodien gd;
	public QLNVControler(Giaodien gd) {
	this.gd = gd;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String lay_du_lieu = e.getActionCommand();
//		JOptionPane.showMessageDialog(gd,"Bạn vừa ấn vô nút "+ lay_du_lieu);
		if(lay_du_lieu.equalsIgnoreCase("Thêm")) {
			try {
				//Lấy dữ liệu và quăng vô setter
				String manhanvien = this.gd.textField_Ma_nv.getText();
				String tennhanvien = this.gd.textField_Ho_va_ten.getText();
				String email = this.gd.textField_Email.getText();
				int quequan = this.gd.comboBox_QueQuan1.getSelectedIndex();
				Tinh tinh = Tinh.getTinhById(quequan);
				// bắt lỗi định dạng số điện thoại
				int sodienthoai = 0;
				try {
					sodienthoai = Integer.valueOf( this.gd.textField_So_Dien_Thoai.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(gd,"Lỗi định dạng số điện thoại");
					e1.printStackTrace();
				}
				// bắt lỗi định dạng lương
				float luong = 0;
				try {
					luong = Float.valueOf(this.gd.textField_Luong.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(gd,"Lỗi định dạng lương");
					e1.printStackTrace();
				}
				int chucvu = this.gd.comboBox_Chuc_Vu.getSelectedIndex();
				Chucvu cv = Chucvu.getChucVuById(chucvu);
				boolean gioitinh = true;
				if(this.gd.Radio_Nam.isSelected()) {
					gioitinh = true;
				}else if(this.gd.Radio_Nu.isSelected()) {
					gioitinh = false;
				}
				// bắt lỗi định dạng nếu 1 trong hai mà lỗi thì không cho in vô table
				if(luong == 0.0 || sodienthoai==0) {
					// không làm gì cả
				}else {
					Nhanvien nv = new Nhanvien(tennhanvien,gioitinh,cv,sodienthoai,email,tinh,manhanvien,luong);
					this.gd.themofcapnhatNhanVien(nv);
				}
				
			} catch (Exception e1) {
				 e1.printStackTrace();
			}
			this.gd.xoaForm();
//			this.gd.qlnv.setLuachon("Thêm");
		}else if(lay_du_lieu.equalsIgnoreCase("Lưu")) {
		
		}else if(lay_du_lieu.equalsIgnoreCase("Cập nhật")) {
			this.gd.hienThiThongTinNhanVien();
			
		}else if(lay_du_lieu.equalsIgnoreCase("xóa")) {
			this.gd.thucHienXoa();
		}else if(lay_du_lieu.equalsIgnoreCase("tìm")) {
			this.gd.thucHienTim();
		}else if(lay_du_lieu.equalsIgnoreCase("hủy tìm")) {
			this.gd.thucHienHuyTim();
		}else if(lay_du_lieu.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		
	}

}
