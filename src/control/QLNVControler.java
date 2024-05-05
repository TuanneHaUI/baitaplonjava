package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Chucvu;
import model.Tinh;
import model.nhanvien;
import view.giaodien;

public class QLNVControler implements ActionListener{
private giaodien gd;
	public QLNVControler(giaodien gd) {
	this.gd = gd;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String lay_du_lieu = e.getActionCommand();
//		JOptionPane.showMessageDialog(gd,"Bạn vừa ấn vô nút "+ lay_du_lieu);
		if(lay_du_lieu.equalsIgnoreCase("thêm")) {
			this.gd.xoaForm();
			this.gd.qlnv.setLuachon("Thêm");
		}if(lay_du_lieu.equalsIgnoreCase("Lưu")) {
			try {
				//Lấy dữ liệu
				String manhanvien = this.gd.textField_Ma_nv.getText();
				String tennhanvien = this.gd.textField_Ho_va_ten.getText();
				String email = this.gd.textField_Email.getText();
				int quequan = this.gd.comboBox_QueQuan1.getSelectedIndex();
				Tinh tinh = Tinh.getTinhById(quequan);
				String sodienthoai = this.gd.textField_So_Dien_Thoai.getText();
				int luong = Integer.valueOf(this.gd.textField_Luong.getText());
				int chucvu = this.gd.comboBox_Chuc_Vu.getSelectedIndex();
				Chucvu cv = Chucvu.getChucVuById(chucvu);
				boolean gioitinh = true;
				if(this.gd.Radio_Nam.isSelected()) {
					gioitinh = true;
				}else if(this.gd.Radio_Nu.isSelected()) {
					gioitinh = false;
				}
				
				nhanvien nv = new nhanvien(tennhanvien,gioitinh,cv,sodienthoai,email,tinh,manhanvien,luong);
				this.gd.themofcapnhatNhanVien(nv);
			} catch (Exception e1) {
				 e1.printStackTrace();
			}
		}else if(lay_du_lieu.equals("Cập nhật")) {
			this.gd.hienThiThongTinNhanVien();
		}
		
	}

}
