package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LuuFlieTaiKhoan {
private String tenTaiKhoan, tenEmail, matKhau;

public LuuFlieTaiKhoan(String tenTaiKhoan, String tenEmail, String matKhau) {
	super();
	this.tenTaiKhoan = tenTaiKhoan;
	this.tenEmail = tenEmail;
	this.matKhau = matKhau;
}

public LuuFlieTaiKhoan() {
	super();
}

public String getTenTaiKhoan() {
	return tenTaiKhoan;
}

public void setTenTaiKhoan(String tenTaiKhoan) {
	this.tenTaiKhoan = tenTaiKhoan;
}

public String getTenEmail() {
	return tenEmail;
}

public void setTenEmail(String tenEmail) {
	this.tenEmail = tenEmail;
}

public String getMatKhau() {
	return matKhau;
}

public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public static void writeToFile(String username, String email, String password) {
    try {
    	File file = new File("D:\\hihi.txt");
        FileWriter writer = new FileWriter("D:\\hihi.txt", true);
        writer.write("Username: " + username + "\n");
        writer.write("Password: " + password + "\n");
        writer.write("Email: " + email + "\n");
        writer.write("\n");
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
