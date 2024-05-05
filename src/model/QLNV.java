package model;

import java.util.ArrayList;

public class QLNV {
private ArrayList<nhanvien> danhsach = new ArrayList<nhanvien>();
private String luachon;
public QLNV() {
	super();
}

public QLNV(ArrayList<nhanvien> danhsach) {
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

public ArrayList<nhanvien> getDanhsach() {
	return danhsach;
}

public void setDanhsach(ArrayList<nhanvien> danhsach) {
	this.danhsach = danhsach;
}
public void them(nhanvien nv) {
	this.danhsach.add(nv);
}
public void xoa(nhanvien nv) {
	this.danhsach.remove(nv);
}
public void capnhat(nhanvien nv) {
	this.danhsach.remove(nv);
	this.danhsach.add(nv);
}

public boolean kiemTraTonTai(nhanvien nv) {
    for (nhanvien nhanVien : danhsach) {
        if (nhanVien.getMaNhanVien().equals(nv.getMaNhanVien())) {
            return true;
        }
    }
    return false;
}


}
