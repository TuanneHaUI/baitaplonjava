package model;

public class nhanvien {
private String MaNhanVien;
private String HovaTen, Email;
private Chucvu ChucVu;
private String SoDienThoai;
Tinh QueQuan;
private boolean gioiTinh;
private int Luong;
public nhanvien(String hovaTen, Boolean gioiTinh, Chucvu ChucVu, String sodienthoai2, String email, Tinh queQuan, String MaNhanVien, int Luong) {
	super();
	this.HovaTen = hovaTen;
	this.gioiTinh = gioiTinh;
	this.ChucVu = ChucVu;
	this.SoDienThoai = sodienthoai2;
	this.Email = email;
	this.QueQuan = queQuan;
	this.MaNhanVien = MaNhanVien;
	this.Luong=Luong;
}
public String getMaNhanVien() {
	return MaNhanVien;
}
public void setMaNhanVien(String maNhanVien) {
	MaNhanVien = maNhanVien;
}
public void setGioiTinh(boolean gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public nhanvien() {
 
}

public String getHovaTen() {
	return HovaTen;
}
public void setHovaTen(String hovaTen) {
	HovaTen = hovaTen;
}
public boolean getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(Boolean gioiTinh) {
	gioiTinh = gioiTinh;
}
public Chucvu getChucVu() {
	return ChucVu;
}
public void setChucVu(Chucvu chucVu) {
	ChucVu = chucVu;
}
public String getSoDienThoai() {
	return SoDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	SoDienThoai = soDienThoai;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public Tinh getQueQuan() {
	return QueQuan;
}
public void setQueQuan(Tinh queQuan) {
	QueQuan = queQuan;
}
public int getLuong() {
	return Luong;
}
public void setLuong(int luong) {
	Luong = luong;
}


}
