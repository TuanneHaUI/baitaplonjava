package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.LuuFlieTaiKhoan;
import model.LuuFlieTaiKhoan;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import control.LoginControler;

import java.util.List;

public class Quanlitaikhoan extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Quanlitaikhoan frame = new Quanlitaikhoan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Quanlitaikhoan() {
    	this.setTitle("Quản lí tài khoản");
    	LoginControler ac = new LoginControler(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 630, 337);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Tên tài khoản", "Mật khẩu", "Email"}
        ));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 42, 574, 154);
        contentPane.add(scrollPane);

        JButton btnNewButton_Quay_Lai = new JButton("Quay lại");
        btnNewButton_Quay_Lai.addActionListener(ac);
        btnNewButton_Quay_Lai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_Quay_Lai.setBounds(258, 219, 91, 40);
        contentPane.add(btnNewButton_Quay_Lai);

        docdulieuvaobang();
    }

    public void docdulieuvaobang() {

        List<LuuFlieTaiKhoan> accounts = LuuFlieTaiKhoan.readFromFile();
        
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        for (LuuFlieTaiKhoan account : accounts) {
            System.out.println("Adding row to table: " + account.getTenTaiKhoan() + ", " + account.getMatKhau() + ", " + account.getTenEmail()); // Debug print
            model_table.addRow(new Object[] { account.getTenTaiKhoan(), account.getMatKhau(), account.getTenEmail() });
        }
    }
}
