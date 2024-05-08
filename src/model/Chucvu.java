package model;

import java.util.ArrayList;
import java.util.Objects;

public class Chucvu {
private String tenChucVu;

public Chucvu() {
	super();
}

public Chucvu(String tenChucVu) {
	super();
	this.tenChucVu = tenChucVu;
}

public String getTenChucVu() {
	return tenChucVu;
}

public void setTenChucVu(String tenChucVu) {
	this.tenChucVu = tenChucVu;
}
public static ArrayList getDSChucVu() {
	String[] chucvu = {"Giám đốc","Kế toán","Trưởng Phòng","Nhân viên","Thực tập sinh"};
	ArrayList<Chucvu> cv = new ArrayList<Chucvu>();
	for (String x : chucvu) {
		Chucvu t = new Chucvu(x);
		cv.add(t);
	}
	
	return cv;
	
}

public static Chucvu getChucVuById(int chucvu) {
	
	return (Chucvu) Chucvu.getDSChucVu().get(chucvu-1);
}

public static Chucvu getChucVuByChucVu(String cvv) {
	ArrayList<Chucvu> cv = getDSChucVu();
	for (Chucvu chucvu : cv) {
		if(chucvu.tenChucVu.equals(cvv)) {
			return chucvu;
		}
	}
	return null;
}

@Override
public int hashCode() {
	return Objects.hash(tenChucVu);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Chucvu other = (Chucvu) obj;
	return Objects.equals(tenChucVu, other.tenChucVu);
}

}
