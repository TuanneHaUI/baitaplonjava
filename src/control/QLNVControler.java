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
		JOptionPane.showMessageDialog(gd,"Bạn vừa ấn vô nút "+ lay_du_lieu);
		if(lay_du_lieu.equalsIgnoreCase("thêm")) {
			this.gd.xoaForm();
			this.gd.qlnv.setLuachon("Thêm");
		}if(lay_du_lieu.equalsIgnoreCase("Lưu")) {
			try {
				//Lấy dữ liệu
				int manhanvien = Integer.valueOf(this.gd.textField_Ma_nv.getText());
				String tennhanvien = this.gd.textField_Ho_va_ten.getText();
				String email = this.gd.textField_Email.getText();
				int quequan = this.gd.comboBox_QueQuan1.getSelectedIndex();
				Tinh tinh = Tinh.getTinhById(quequan);
				int sodienthoai = Integer.valueOf(this.gd.textField_So_Dien_Thoai.getText());
				int luong = Integer.valueOf(this.gd.textField_Luong.getText());
				int chucvu = this.gd.comboBox_Chuc_Vu.getSelectedIndex();
				Chucvu cv = Chucvu.getChucVuById(chucvu);
				String chongioitinh = this.gd.btn_gioitinh.getSelection()+"";
				boolean gioitinh = true;
				if(chongioitinh.equalsIgnoreCase("nam")) {
					gioitinh = true;
				}else if(chongioitinh.equalsIgnoreCase("nữ")) {
					gioitinh = false;
				}
				
				nhanvien nv = new nhanvien(tennhanvien,gioitinh,cv,sodienthoai,email,tinh,manhanvien,luong);
				String luachon = this.gd.qlnv.getLuachon();
				if (luachon == null || luachon.equalsIgnoreCase("") || luachon.equalsIgnoreCase("Thêm")) {
					this.gd.themNhanVien(nv);
					System.out.println("đã vào đây thêm");
				} else if (luachon.equalsIgnoreCase("Cập nhật")) {
					this.gd.capNhatNhanVien(nv);
				} 
			} catch (Exception e1) {
				 e1.printStackTrace();
			}
		}
		
	}

}
