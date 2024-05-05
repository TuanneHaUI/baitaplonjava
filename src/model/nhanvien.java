package model;

public class nhanvien {
private int MaNhanVien;
private String HovaTen, Email;
private Chucvu ChucVu;
int SoDienThoai;
Tinh QueQuan;
private boolean gioiTinh;
private int Luong;
public nhanvien(String hovaTen, Boolean gioiTinh, Chucvu ChucVu, int sodienthoai2, String email, Tinh queQuan, int MaNhanVien, int Luong) {
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
public int getMaNhanVien() {
	return MaNhanVien;
}
public void setMaNhanVien(int maNhanVien) {
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
public int getSoDienThoai() {
	return SoDienThoai;
}
public void setSoDienThoai(int soDienThoai) {
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
