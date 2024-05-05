package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Chucvu;
import model.QLNV;
import model.Tinh;
import model.nhanvien;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.QLNVControler;

public class giaodien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QLNV qlnv;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	public JTextField textField_Ma_nv;
	public JTextField textField_Ho_va_ten;
	public JTextField textField_So_Dien_Thoai;
	public JTextField textField_Luong;
	public ButtonGroup btn_gioitinh;
	public JComboBox comboBox_QueQuan1;
	private JComboBox comboBox_QueQuan;
	public JComboBox comboBox_Chuc_Vu;
	public QLNVControler ac;
	public JTextField textField_Email;
	public JRadioButton Radio_Nam;
	public JRadioButton Radio_Nu;

	
	public giaodien() {
		this.qlnv = new QLNV();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 583);
		
		// tao lệnh điều khiển
		 ac = new QLNVControler(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 24);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Close");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("About me");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JLabel Label_Que_Quan = new JLabel("Quê quán");
		Label_Que_Quan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Que_Quan.setBounds(52, 34, 98, 34);
		contentPane.add(Label_Que_Quan);
		
		JLabel Label_Ma_Nhan_vien = new JLabel("Mã nhân viên");
		Label_Ma_Nhan_vien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Ma_Nhan_vien.setBounds(352, 34, 98, 34);
		contentPane.add(Label_Ma_Nhan_vien);
		
		textField_6 = new JTextField();
		textField_6.setBounds(460, 34, 126, 39);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton Button_Tim = new JButton("Tìm");
		Button_Tim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_Tim.setBounds(609, 32, 97, 39);
		contentPane.add(Button_Tim);
		
		// Tạo mảng để lữu trữ quê
	    comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh x : listTinh) {
		    comboBox_QueQuan.addItem(x.getTenTinh());
		}
		comboBox_QueQuan.setBounds(135, 34, 119, 39);
		contentPane.add(comboBox_QueQuan);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 94, 734, 2);
		contentPane.add(separator);
		
		JLabel Label_DS_Nhan_Vien = new JLabel("Danh sách nhân viên");
		Label_DS_Nhan_Vien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_DS_Nhan_Vien.setBounds(0, 94, 184, 34);
		contentPane.add(Label_DS_Nhan_Vien);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 T\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ch\u1EE9c v\u1EE5", "Qu\u00EA Qu\u00E1n", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "L\u01B0\u01A1ng"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 128, 704, 154);
		contentPane.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 292, 734, 2);
		contentPane.add(separator_1);
		
		JLabel Label_Thong_tin_NV = new JLabel("Thông tin nhân viên");
		Label_Thong_tin_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Thong_tin_NV.setBounds(0, 288, 184, 34);
		contentPane.add(Label_Thong_tin_NV);
		
		JLabel Label_NMaSv = new JLabel("Mã nhân viên");
		Label_NMaSv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_NMaSv.setBounds(20, 326, 98, 34);
		contentPane.add(Label_NMaSv);
		
		textField_Ma_nv = new JTextField();
		textField_Ma_nv.setColumns(10);
		textField_Ma_nv.setBounds(115, 336, 96, 19);
		contentPane.add(textField_Ma_nv);
		
		JLabel Label_Ho_Va_Ten = new JLabel("Họ và tên");
		Label_Ho_Va_Ten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Ho_Va_Ten.setBounds(20, 360, 98, 34);
		contentPane.add(Label_Ho_Va_Ten);
		
		textField_Ho_va_ten = new JTextField();
		textField_Ho_va_ten.setColumns(10);
		textField_Ho_va_ten.setBounds(115, 370, 96, 19);
		contentPane.add(textField_Ho_va_ten);
		
		JLabel Label_Gioi_Tinh = new JLabel("Giới tính");
		Label_Gioi_Tinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Gioi_Tinh.setBounds(20, 393, 98, 34);
		contentPane.add(Label_Gioi_Tinh);
		
		Radio_Nam = new JRadioButton("Nam");
		Radio_Nam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Radio_Nam.setBounds(115, 400, 57, 21);
		contentPane.add(Radio_Nam);
		
		Radio_Nu = new JRadioButton("Nữ");
		Radio_Nu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Radio_Nu.setBounds(174, 400, 57, 21);
		contentPane.add(Radio_Nu);
		
		// Gom nhóm chỉ được chọn 1 trong hai giới tính
		 btn_gioitinh = new ButtonGroup();
		btn_gioitinh.add(Radio_Nam);
		btn_gioitinh.add(Radio_Nu);
		
		JLabel Label_ChucVu = new JLabel("Chức vụ");
		Label_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_ChucVu.setBounds(352, 326, 98, 34);
		contentPane.add(Label_ChucVu);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(352, 360, 98, 34);
		contentPane.add(lblSinThoi);
		
		textField_So_Dien_Thoai = new JTextField();
		textField_So_Dien_Thoai.setColumns(10);
		textField_So_Dien_Thoai.setBounds(460, 370, 96, 19);
		contentPane.add(textField_So_Dien_Thoai);
		
		JLabel Label_So_gio_Lam_1 = new JLabel("Quê quán");
		Label_So_gio_Lam_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_So_gio_Lam_1.setBounds(352, 393, 98, 34);
		contentPane.add(Label_So_gio_Lam_1);
		
		// Tạo mảng quê quán
		comboBox_QueQuan1 = new JComboBox();
		comboBox_QueQuan1.addItem("");
		for (Tinh x : listTinh) {
		    comboBox_QueQuan1.addItem(x.getTenTinh());
		}
		comboBox_QueQuan1.setBounds(460, 402, 96, 21);
		contentPane.add(comboBox_QueQuan1);
		
		
		
		JLabel Label_Ma_Nhan_vien_1 = new JLabel("Lương");
		Label_Ma_Nhan_vien_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Ma_Nhan_vien_1.setBounds(20, 427, 98, 34);
		contentPane.add(Label_Ma_Nhan_vien_1);
		
		textField_Luong = new JTextField();
		textField_Luong.setColumns(10);
		textField_Luong.setBounds(115, 437, 96, 19);
		contentPane.add(textField_Luong);
		
	   comboBox_Chuc_Vu = new JComboBox();
		comboBox_Chuc_Vu.addItem("");
		ArrayList<Chucvu> chucvu = Chucvu.getDSChucVu();
		for (Chucvu x : chucvu) {
			comboBox_Chuc_Vu.addItem(x.getTenChucVu());
		}
		comboBox_Chuc_Vu.setBounds(460, 335, 96, 21);
		contentPane.add(comboBox_Chuc_Vu);
		
		JButton Button_Them = new JButton("Thêm");
		Button_Them.addActionListener(ac);
		Button_Them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_Them.setBounds(20, 471, 97, 39);
		contentPane.add(Button_Them);
		
		JButton Button_Xoa = new JButton("Xóa");
		Button_Xoa.addActionListener(ac);
		Button_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_Xoa.setBounds(135, 471, 97, 39);
		contentPane.add(Button_Xoa);
		
		JButton Button_Cap_Nhat = new JButton("Cập nhật");
		Button_Cap_Nhat.addActionListener(ac);
		Button_Cap_Nhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_Cap_Nhat.setBounds(258, 471, 97, 39);
		contentPane.add(Button_Cap_Nhat);
		
		JButton Button_Lưu = new JButton("Lưu");
		Button_Lưu.addActionListener(ac);
		Button_Lưu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_Lưu.setBounds(384, 471, 97, 39);
		contentPane.add(Button_Lưu);
		
		JButton Button_Sap_xep = new JButton("Sắp xếp ");
		Button_Sap_xep.addActionListener(ac);
		Button_Sap_xep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Button_Sap_xep.setBounds(515, 471, 97, 39);
		contentPane.add(Button_Sap_xep);
		
		JLabel Label_Email = new JLabel("Email");
		Label_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_Email.setBounds(352, 427, 98, 34);
		contentPane.add(Label_Email);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(460, 437, 96, 19);
		contentPane.add(textField_Email);
		
		
		
		
	}


	public void xoaForm() {
		textField_Ho_va_ten.setText("");
		textField_Luong.setText("");
		textField_Ma_nv.setText("");
		textField_So_Dien_Thoai.setText("");
		comboBox_QueQuan1.setSelectedIndex(-1);// không chọn bất kì ai hết
		comboBox_Chuc_Vu.setSelectedIndex(-1); // không chọn bất kì ai hết
		btn_gioitinh.clearSelection();
		textField_Email.setText("");
	}
public void themNhanVien(nhanvien nv) {
	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	model_table = (DefaultTableModel) table.getModel();
	model_table.addRow(
			new Object[] {
					nv.getMaNhanVien()+"",
					nv.getHovaTen(),
				   (nv.getGioiTinh()?"Nam":"Nữ"),
					nv.getChucVu().getTenChucVu(),
				    nv.getQueQuan().getTenTinh(),
				    nv.getSoDienThoai()+"",
				    nv.getEmail(),
				    nv.getLuong()+""});
}
// thêm nhân viên vô
	public void themofcapnhatNhanVien(nhanvien nv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		// kiểm tra nếu mã nhân viên tồn tại
	if(!this.qlnv.kiemTraTonTai(nv)) {
		this.qlnv.them(nv);
		this.themNhanVien(nv);
	}else {
		this.qlnv.capnhat(nv);
		int soLuongDong = model_table.getRowCount();
		for(int i = 0;i <soLuongDong;i++) {
			String id = model_table.getValueAt(i, 0)+"";
			if(id.equals(nv.getMaNhanVien())) {
				model_table.setValueAt(nv.getMaNhanVien()+"",i,0);
				model_table.setValueAt(nv.getHovaTen(),i,1);
				model_table.setValueAt((nv.getGioiTinh()?"Nam":"Nữ"),i,2);
				model_table.setValueAt(nv.getChucVu().getTenChucVu(),i,3);
				model_table.setValueAt(nv.getQueQuan().getTenTinh(),i,4);
				model_table.setValueAt(nv.getSoDienThoai()+"",i,5);
				model_table.setValueAt(nv.getEmail(),i,6);
				model_table.setValueAt(nv.getLuong()+"",i,7);
			}
			
		}
	}
}





	public void hienThiThongTinNhanVien() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row= table.getSelectedRow();//lấy vị trí thứ tự
		//Lấy dữ liệu
		String manhanvien = model_table.getValueAt(i_row, 0)+" ";
		String tennhanvien = model_table.getValueAt(i_row, 1)+"";
		String gt = model_table.getValueAt(i_row, 2)+"";
		boolean gioitinh = gt.equals("Nam");
		Chucvu cv = Chucvu.getChucVuByChucVu( (String) model_table.getValueAt(i_row, 3));
		Tinh tinh = Tinh.getTinhByTinh((String)model_table.getValueAt(i_row, 4));
		String sodienthoai =  model_table.getValueAt(i_row, 5)+"";
		String email =  model_table.getValueAt(i_row, 6)+"";
		
		
		int luong = Integer.valueOf( model_table.getValueAt(i_row, 7)+"");
		
		
		this.textField_Ma_nv.setText(manhanvien);
		this.textField_Ho_va_ten.setText(tennhanvien);
		if(gioitinh) {
			Radio_Nam.setSelected(true);
		}else {
			Radio_Nu.setSelected(true);
		}
		
		
		
		this.comboBox_Chuc_Vu.setSelectedItem(cv.getTenChucVu());
		this.comboBox_QueQuan1.setSelectedItem(tinh.getTenTinh());
		this.textField_So_Dien_Thoai.setText(sodienthoai);
		this.textField_Email.setText(email);
		this.textField_Luong.setText(luong+"");
		   
		

}
}

