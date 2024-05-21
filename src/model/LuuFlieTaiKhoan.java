package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public static ArrayList<LuuFlieTaiKhoan> readFromFile() {
    ArrayList<LuuFlieTaiKhoan> accounts = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("D:\\hihi.txt"))) {
        String line;
        String username = null, password = null, email = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Username: ")) {
                username = line.substring(10).trim();
            } else if (line.startsWith("Password: ")) {
                password = line.substring(10).trim();
            } else if (line.startsWith("Email: ")) {
                email = line.substring(7).trim();
            }

            if (username != null && password != null && email != null) {
                accounts.add(new LuuFlieTaiKhoan(username, email, password));
                username = password = email = null; // Reset cho tài khoản tiếp theo
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return accounts;
}
}
