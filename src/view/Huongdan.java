package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.LoginControler;
import control.QLNVControler;


public class Huongdan extends JFrame{
    private static final long serialVersionUID = 1L;
    private static Huongdan instance;
    public static QLNVControler ac;
    private static CardLayout cardLayout = new CardLayout();
    private static JPanel vunghuongdan = new JPanel(cardLayout);
    static String hdgioithieu;
    static String hdthem;
    static String hdcapnhat;
    static String hdxoa;
    static String hdtimkiem;
    static String hdmoluu;
    static String hddangnhap;
    public static void hienhuongdan() {
    	
        JFrame khunghuongdan = new JFrame("Hướng dẫn sử dụng phần mềm");
        khunghuongdan.setSize(600, 600);
        khunghuongdan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        khunghuongdan.setLayout(new BorderLayout());

        JPanel vungnutbam = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JButton nuthdgioithieu    = new JButton("Giới thiệu ");
        JButton nuthdthem         = new JButton("Thêm nhân viên");
        JButton nuthdcapnhat      = new JButton("Cập nhật thông tin nhân viên");
        JButton nuthdxoa          = new JButton("Xóa nhân viên");
        JButton nuthdtimkiem      = new JButton("Tìm kiếm nhân viên");
        JButton nuthdmoluu        = new JButton("Mở hoặc lưu dữ liệu ");
        JButton nuthddangnhap     = new JButton("Đăng nhập ");
        JButton nuttrogiup     = new JButton("Trợ giúp");
        
        
        
        vungnutbam.add(nuthdgioithieu);
        vungnutbam.add(nuthdthem);
        vungnutbam.add(nuthdcapnhat);
        vungnutbam.add(nuthdxoa);
        vungnutbam.add(nuthdtimkiem);
        vungnutbam.add(nuthdmoluu);
        vungnutbam.add(nuthddangnhap);
        vungnutbam.add(nuttrogiup);
        
        
        khunghuongdan.add(vungnutbam, BorderLayout.NORTH);
        
        try {
            hdgioithieu = new String(Files.readAllBytes(Paths.get("huongdan/hdgioithieu.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            hdthem = new String(Files.readAllBytes(Paths.get("huongdan/hdthem.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hdcapnhat = new String(Files.readAllBytes(Paths.get("huongdan/hdcapnhat.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hdxoa = new String(Files.readAllBytes(Paths.get("huongdan/hdxoa.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hdtimkiem  = new String(Files.readAllBytes(Paths.get("huongdan/hdtimkiem.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hdmoluu = new String(Files.readAllBytes(Paths.get("huongdan/hdmoluu.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            hddangnhap = new String(Files.readAllBytes(Paths.get("huongdan/hddangnhap.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
       

        vunghuongdan.add(createGuidePanel("Giới thiệu", hdgioithieu), "About");
        vunghuongdan.add(createGuidePanel("Thêm nhân viên", hdthem), "AddEmployee");
        vunghuongdan.add(createGuidePanel("Cập nhật thông tin nhân viên", hdcapnhat), "UpdateEmployee");
        vunghuongdan.add(createGuidePanel("Xóa nhân viên", hdxoa), "DeleteEmployee");
        vunghuongdan.add(createGuidePanel("Tìm kiếm nhân viên", hdtimkiem), "SearchEmployee");
        vunghuongdan.add(createGuidePanel("Mở và lưu dữ liệu", hdmoluu), "OpenSaveData");
        vunghuongdan.add(createGuidePanel("Đăng nhập", hddangnhap), "Login");
        khunghuongdan.add(vunghuongdan, BorderLayout.CENTER);

        nuthdgioithieu.addActionListener(e -> showGuide("About"));
        nuthdthem.addActionListener(e -> showGuide("AddEmployee"));
        nuthdcapnhat.addActionListener(e -> showGuide("UpdateEmployee"));
        nuthdxoa.addActionListener(e -> showGuide("DeleteEmployee"));
        nuthdtimkiem.addActionListener(e -> showGuide("SearchEmployee"));
        nuthdmoluu.addActionListener(e -> showGuide("OpenSaveData"));
        nuthddangnhap.addActionListener(e -> showGuide("Login"));
        
        
        khunghuongdan.setVisible(true);
    }

    private static JPanel createGuidePanel(String title, String content) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JEditorPane editorPane = new JEditorPane("text/html", content);
        editorPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(editorPane);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private static void showGuide(String guideName) {
        cardLayout.show(vunghuongdan, guideName);
    }
    //---------------------------------------------------------------------------------------------

}
