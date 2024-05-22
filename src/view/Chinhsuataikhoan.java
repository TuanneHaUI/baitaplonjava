package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import control.LoginControler;
import model.LuuFlieTaiKhoan;

public class Chinhsuataikhoan extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField_Tai_Khoan;
    private JTextField textField_Mat_Khau;
    private JTextField textField_Email;
    private ArrayList<LuuFlieTaiKhoan> accounts;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Chinhsuataikhoan frame = new Chinhsuataikhoan();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Chinhsuataikhoan() {
        setResizable(false);
        LoginControler ac = new LoginControler(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 630, 401);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tên tài khoản", "Mật khẩu", "Email" }));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 42, 574, 154);
        contentPane.add(scrollPane);

        JLabel lblNewLabel_Tai_Khoan = new JLabel("Tài khoản");
        lblNewLabel_Tai_Khoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_Tai_Khoan.setBounds(45, 213, 68, 26);
        contentPane.add(lblNewLabel_Tai_Khoan);

        JLabel lblNewLabel_Mat_Khau = new JLabel("Mật khẩu");
        lblNewLabel_Mat_Khau.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_Mat_Khau.setBounds(45, 249, 68, 26);
        contentPane.add(lblNewLabel_Mat_Khau);

        JLabel lblNewLabel_Email = new JLabel("Email");
        lblNewLabel_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_Email.setBounds(334, 213, 68, 26);
        contentPane.add(lblNewLabel_Email);

        textField_Tai_Khoan = new JTextField();
        textField_Tai_Khoan.setBounds(123, 213, 123, 26);
        contentPane.add(textField_Tai_Khoan);
        textField_Tai_Khoan.setColumns(10);

        textField_Mat_Khau = new JTextField();
        textField_Mat_Khau.setColumns(10);
        textField_Mat_Khau.setBounds(123, 255, 123, 26);
        contentPane.add(textField_Mat_Khau);

        textField_Email = new JTextField();
        textField_Email.setColumns(10);
        textField_Email.setBounds(384, 213, 123, 26);
        contentPane.add(textField_Email);

        JButton btnNewButton_Sua = new JButton("Sửa");
        btnNewButton_Sua.addActionListener(ac);
        btnNewButton_Sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_Sua.setBounds(45, 316, 85, 40);
        contentPane.add(btnNewButton_Sua);

        JButton btnNewButton_Xoa = new JButton("Xóa");
        btnNewButton_Xoa.addActionListener(ac);
        btnNewButton_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_Xoa.setBounds(231, 316, 85, 40);
        contentPane.add(btnNewButton_Xoa);

        JButton btnNewButton_Quay_Lai = new JButton("Quay lại");
        btnNewButton_Quay_Lai.addActionListener(ac);
        btnNewButton_Quay_Lai.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_Quay_Lai.setBounds(422, 316, 102, 40);
        contentPane.add(btnNewButton_Quay_Lai);

        laydulieu();

        // Thêm ListSelectionListener vào bảng
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                fillTextFields(); //Gọi phương thức điền vào trường văn bản bất cứ khi nào một hàng mới được chọn
            }
        });
    }

    public void laydulieu() {// lấy dữ liệu đầu tránh lỗi 
        accounts = LuuFlieTaiKhoan.readFromFile();
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        for (LuuFlieTaiKhoan account : accounts) {
            model_table.addRow(new Object[] { account.getTenTaiKhoan(), account.getMatKhau(), account.getTenEmail() });
        }
    }

    private void fillTextFields() {// cứ ấn đến đâu là hiển thị full dữ liệu đến đó
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String oldUsername = table.getValueAt(selectedRow, 0).toString();
            String password = table.getValueAt(selectedRow, 1).toString();
            String email = table.getValueAt(selectedRow, 2).toString();

            textField_Tai_Khoan.setText(oldUsername);
            textField_Mat_Khau.setText(password);
            textField_Email.setText(email);
        }
    }

    public void sua() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String oldUsername = table.getValueAt(selectedRow, 0).toString();
            String t = textField_Tai_Khoan.getText();
            String m = textField_Mat_Khau.getText();
            String e = textField_Email.getText();

     // cập nhật dữ liệu 
            LuuFlieTaiKhoan account = accounts.get(selectedRow);
            account.setTenTaiKhoan(t);
            account.setMatKhau(m);
            account.setTenEmail(e);

            // cập nhật dữ liệu vào model
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            model_table.setValueAt(t, selectedRow, 0);
            model_table.setValueAt(m, selectedRow, 1);
            model_table.setValueAt(e, selectedRow, 2);

            //ghi dữ liệu vào file
            LuuFlieTaiKhoan.writeToFile(accounts);
        }
    }
    public void xoa() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            //xóa dữ liệu khỏi danh sách
            accounts.remove(selectedRow);

            // xóa khỏi model
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            model_table.removeRow(selectedRow);

            // cập nhât lại dữ liệu
            LuuFlieTaiKhoan.writeToFile(accounts);
        }
    }
}
