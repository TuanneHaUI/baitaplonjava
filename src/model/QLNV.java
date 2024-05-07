package model;

import java.util.ArrayList;

public class QLNV {
private ArrayList<Nhanvien> danhsach = new ArrayList<Nhanvien>();
private String luachon;
public QLNV() {
	super();
}

public QLNV(ArrayList<Nhanvien> danhsach) {
	super();
	this.danhsach = danhsach;
	this.luachon="";
}

public String getLuachon() {
	return luachon;
}

public void setLuachon(String luachon) {
	this.luachon = luachon;
}

public ArrayList<Nhanvien> getDanhsach() {
	return danhsach;
}

public void setDanhsach(ArrayList<Nhanvien> danhsach) {
	this.danhsach = danhsach;
}
public void them(Nhanvien nv) {
	this.danhsach.add(nv);
}
public void xoa(Nhanvien nv) {
	this.danhsach.remove(nv);
}
public void capnhat(Nhanvien nv) {
	xoa(nv);
	this.danhsach.add(nv);
}

public boolean kiemTraTonTai(Nhanvien nv) {
    for (Nhanvien nhanVien : danhsach) {
        if (nhanVien.getMaNhanVien().equals(nv.getMaNhanVien())) {
            return true;
        }
    }
    return false;
}


}
