package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QLNV implements Serializable{
private ArrayList<Nhanvien> danhsach = new ArrayList<Nhanvien>();
private String luachon;
private String tenFile;
public QLNV() {
	this.tenFile = "";
}

public QLNV(ArrayList<Nhanvien> danhsach) {
	super();
	this.danhsach = danhsach;
	this.luachon="";
	this.tenFile = "";
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

public void sapxepTang() {
	Collections.sort(danhsach,new Comparator<Nhanvien>() {

		@Override
		public int compare(Nhanvien o1, Nhanvien o2) {
			if(o1.getLuong() < o2.getLuong()) {
				return 1;
			}else if(o1.getLuong() > o2.getLuong()) {
				 return -1;
			}
			 return 0;
		}
	});
}
public void sapxepGiam() {
	Collections.sort(danhsach,new Comparator<Nhanvien>() {

		@Override
		public int compare(Nhanvien o1, Nhanvien o2) {
			if(o1.getLuong() > o2.getLuong()) {
				return 1;
			}else if(o1.getLuong() < o2.getLuong()) {
				 return -1;
			}
			 return 0;
		}
	});
}

public String getTenFile() {
	return tenFile;
}

public void setTenFile(String tenFile) {
	this.tenFile = tenFile;
}

}
