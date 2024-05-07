package model;

public class Nhanvien {
private String MaNhanVien;
private String HovaTen, Email;
private Chucvu ChucVu;
private int SoDienThoai;
Tinh QueQuan;
private boolean gioiTinh;
private float Luong;
public Nhanvien(String hovaTen, Boolean gioiTinh, Chucvu ChucVu, int sodienthoai, String email, Tinh queQuan, String MaNhanVien, float Luong) {
	super();
	this.HovaTen = hovaTen;
	this.gioiTinh = gioiTinh;
	this.ChucVu = ChucVu;
	this.SoDienThoai = sodienthoai;
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
public Nhanvien() {
 
}

public Nhanvien(String maNhanVien) {
	super();
	MaNhanVien = maNhanVien;
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
public float getLuong() {
	return Luong;
}
public void setLuong(float luong) {
	Luong = luong;
}


}
