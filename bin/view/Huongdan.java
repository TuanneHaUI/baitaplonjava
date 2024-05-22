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
    
    private static CardLayout cardLayout = new CardLayout();
    private static JPanel vunghuongdan = new JPanel(cardLayout);
    
    static String hdgioithieu = "<!DOCTYPE html>\r\n"
    		+ "<html>\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Giới thiệu phần mềm quản lý nhân viên</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        a {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "            text-decoration: none;\r\n"
    		+ "        }\r\n"
    		+ "        a:hover {\r\n"
    		+ "            text-decoration: underline;\r\n"
    		+ "        }\r\n"
    		+ "        img {\r\n"
    		+ "            max-width: 100%;\r\n"
    		+ "            height: auto;\r\n"
    		+ "            display: block;\r\n"
    		+ "            margin: 0 auto;\r\n"
    		+ "        }\r\n"
    		+ "        .center {\r\n"
    		+ "            text-align: center;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Giới thiệu</h1>\r\n"
    		+ "    <p><strong>1. Giới thiệu phần mềm quản lý nhân viên:</strong></p>\r\n"
    		+ "    <p>Đây là phần mềm quản lý nhân viên, phần mềm giúp người sử dụng:</p>\r\n"
    		+ "    <ul>\r\n"
    		+ "        <li>Quản lý nhân viên hiệu quả, giúp đơn giản hóa và tự động hóa các quy trình quản lý nhân sự.</li>\r\n"
    		+ "        <li>Nâng cao năng suất làm việc của bộ phận quản lý nhân sự.</li>\r\n"
    		+ "        <li>Cung cấp thông tin nhân viên chính xác và cập nhật cho các thông tin liên quan.</li>\r\n"
    		+ "    </ul>\r\n"
    		+ "    <p><strong>2. Quản lý thông tin nhân viên:</strong></p>\r\n"
    		+ "    <ul>\r\n"
    		+ "        <li>Thêm mới thông tin nhân viên: bao gồm thông tin cá nhân (họ tên, ngày sinh, giới tính, quê quán…), thông tin liên lạc (số điện thoại), thông tin công việc (chức vụ, bộ phận làm việc).</li>\r\n"
    		+ "        <li>Cập nhật thông tin nhân viên: cho phép thay đổi thông tin cá nhân, thông tin liên lạc, thông tin công việc khi có thay đổi.</li>\r\n"
    		+ "        <li>Xóa nhân viên đã nghỉ việc.</li>\r\n"
    		+ "        <li>Tìm kiếm nhân viên: theo mã nhân viên.</li>\r\n"
    		+ "        <li>Mở và lưu danh sách nhân viên nhằm mục đích sao lưu.</li>\r\n"
    		+ "        <li>Đăng nhập và đăng ký cho nhân viên.</li>\r\n"
    		+ "    </ul>\r\n"
    		+ "    <p><strong>3. Đối tượng sử dụng:</strong></p>\r\n"
    		+ "    <ul>\r\n"
    		+ "        <li>Bộ phận nhân sự</li>\r\n"
    		+ "        <li>Ban lãnh đạo</li>\r\n"
    		+ "        <li>Các bộ phận liên quan khác trong công ty</li>\r\n"
    		+ "    </ul>\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n"
    		+ "";
    static String hdthem ="<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Hướng dẫn thêm nhân viên mới</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Hướng dẫn thêm nhân viên mới</h1>\r\n"
    		+ "    <ol>\r\n"
    		+ "        <li>Nhập tất cả thông tin của nhân viên ở phần thông tin nhân viên ở phía dưới phần mềm\r\n"
    		+ "            <ul>\r\n"
    		+ "                <li>Mã nhân viên: Nhập mã số cho nhân viên mới</li>\r\n"
    		+ "                <li>Họ và tên: Nhập họ và tên đầy đủ của nhân viên mới</li>\r\n"
    		+ "                <li>Giới tính: Chọn giới tính của nhân viên mới</li>\r\n"
    		+ "                <li>Lương: Nhập lương một tháng đi làm đầy đủ của nhân viên mới</li>\r\n"
    		+ "                <li>Chức vụ: Chọn chức vụ phù hợp với nhân viên mới</li>\r\n"
    		+ "                <li>Số điện thoại: Nhập số điện thoại của nhân viên mới</li>\r\n"
    		+ "                <li>Quê quán: Chọn quê quán của nhân viên mới</li>\r\n"
    		+ "                <li>Email: Chỉ cần nhập phần địa chỉ email ở trước dấu @, phần mềm sẽ tự thêm đuôi vào sau.</li>\r\n"
    		+ "            </ul>\r\n"
    		+ "        </li>\r\n"
    		+ "        <li>Ấn vào nút thêm ở hàng cuối cùng của phần mềm để thêm nhân viên mới, thông tin nhân viên mới sẽ hiện ở bảng danh sách nhân viên bên trên phần thông tin nhân viên.</li>\r\n"
    		+ "    </ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n"
    		+ "";
    static String hdcapnhat = "<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Hướng dẫn cập nhật thông tin nhân viên</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Hướng dẫn cập nhật thông tin nhân viên</h1>\r\n"
    		+ "    <ol>\r\n"
    		+ "        <li>Tìm kiếm nhân viên cần cập nhật thông tin bằng mã nhân viên và quê quán.</li>\r\n"
    		+ "        <li>Bấm vào nhân viên vừa tìm được ở danh sách nhân viên.</li>\r\n"
    		+ "        <li>Bấm vào nút cập nhật ở hàng cuối cùng của phần mềm, các thông tin nhân viên đó sẽ hiện ra tương ứng ở phần thông tin nhân viên.</li>\r\n"
    		+ "        <li>Ấn vào ô thông tin cần cập nhật để sửa đổi, sau khi sửa đổi xong thì ấn vào nút \"Cập nhật\" ở hàng cuối cùng của phần mềm để hoàn thành cập nhật thông tin nhân viên.</li>\r\n"
    		+ "    </ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n"
    		+ "";
    static String hdxoa ="<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Hướng dẫn xóa nhân viên đã nghỉ việc</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Hướng dẫn xóa nhân viên đã nghỉ việc</h1>\r\n"
    		+ "    <ol>\r\n"
    		+ "        <li>Tìm kiếm nhân viên đã nghỉ theo mã nhân viên và quê quán.</li>\r\n"
    		+ "        <li>Chọn vào nhân viên đã nghỉ trong danh sách nhân viên.</li>\r\n"
    		+ "        <li>Ấn nút xóa ở hàng cuối của phần mềm.</li>\r\n"
    		+ "        <li>Chọn Yes nếu đã chắc chắn để xóa nhân viên đó đi, chọn No hoặc Cancel nếu có nhầm lẫn.</li>\r\n"
    		+ "    </ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n"
    		+ "";
    static String hdtimkiem = "<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Hướng dẫn tìm thông tin nhân viên</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Hướng dẫn tìm thông tin nhân viên</h1>\r\n"
    		+ "    <ol>\r\n"
    		+ "        <li>Nhập mã nhân viên cần tìm kiếm vào ô \"Mã nhân viên\" ở đầu trang phần mềm.</li>\r\n"
    		+ "        <li>Chọn quê quán của nhân viên cần tìm.</li>\r\n"
    		+ "        <li>Ấn nút \"Tìm\" bên cạnh ô nhập mã nhân viên để tìm thông tin nhân viên. Thông tin nhân viên phù hợp sẽ chỉ xuất hiện duy nhất ở bảng danh sách nhân viên. Nếu không tìm thấy thông tin nhân viên, thì sẽ không có nhân viên nào hiện ra trong bảng danh sách nhân viên.</li>\r\n"
    		+ "        <li>Sau khi thực hiện công việc với nhân viên vừa tìm kiếm xong, ấn nút \"Hủy tìm\" ở bên cạnh nút \"Tìm\" để danh sách nhân viên quay lại trạng thái bình thường.</li>\r\n"
    		+ "    </ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n"
    		+ "";
    static String hdmoluu = "<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Hướng dẫn cập nhật mở và lưu danh sách nhân viên</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Hướng dẫn cập nhật mở và lưu danh sách nhân viên</h1>\r\n"
    		+ "    <ol>\r\n"
    		+ "        <li>Trong trường hợp cần lưu danh sách nhân viên hiện tại:</li>\r\n"
    		+ "        <ul>\r\n"
    		+ "            <li>Bấm vào nút \"Lưu\" ở hàng cuối cùng của phần mềm.</li>\r\n"
    		+ "            <li>Cửa sổ thư mục hiện ra, chọn vị trí lưu file chứa danh sách nhân viên.</li>\r\n"
    		+ "            <li>Đặt tên cho file lưu file chứa danh sách nhân viên và ấn \"Save\" để hoàn tất lưu danh sách nhân viên.</li>\r\n"
    		+ "        </ul>\r\n"
    		+ "        <li>Trong hợp cần mở danh sách nhân viên đã lưu trước đó:</li>\r\n"
    		+ "        <ul>\r\n"
    		+ "            <li>Chọn \"File\" ở thanh menu ở đỉnh của phần mềm, tiếp đó chọn \"Open\".</li>\r\n"
    		+ "            <li>Cửa sổ thư mục hiện ra, tìm đến vị trí đã lưu file chứa danh sách nhân viên trước đó.</li>\r\n"
    		+ "            <li>Bấm vào \"Open\" để mở file chứa danh sách nhân viên, danh sách nhân viên trong file sẽ được hiện ra ở bảng danh sách nhân viên trong phần mềm.</li>\r\n"
    		+ "        </ul>\r\n"
    		+ "    </ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>\r\n"
    		+ "";
    static String hdquanlytk = "<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Hướng dẫn quản lý tài khoản</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Hướng dẫn quản lý tài khoản</h1>\r\n"
    		+ "    <ol>\r\n"
    		+ "            <li>Trong menu sau khi đăng nhập, chọn quản lý tài khảo.</li>\r\n"
    		+ "            <li>Cửa sổ quản lý tài khoản hiện ra, tất cả thông tin của các tài khoản sẽ được hiện theo bảng trong cửa sổ.</li>\r\n"
    		+ "            <li>Bấm nút Quay lại để trở về menu chính sau khi đã xem thông tin các tài khoản.</li>\r\n"
    		
    		+ "    </ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>";
    static String trogiup = "<!DOCTYPE html>\r\n"
    		+ "<html lang=\"vi\">\r\n"
    		+ "<head>\r\n"
    		+ "    <meta charset=\"UTF-8\">\r\n"
    		+ "    <title>Trợ giúp</title>\r\n"
    		+ "    <style>\r\n"
    		+ "        body {\r\n"
    		+ "            font-family: Arial, sans-serif;\r\n"
    		+ "            padding: 10px;\r\n"
    		+ "        }\r\n"
    		+ "        h1 {\r\n"
    		+ "            color: #2E8B57;\r\n"
    		+ "        }\r\n"
    		+ "        p, ul, ol {\r\n"
    		+ "            line-height: 1.6;\r\n"
    		+ "        }\r\n"
    		+ "        ul {\r\n"
    		+ "            list-style-type: disc;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "        ol {\r\n"
    		+ "            list-style-type: decimal;\r\n"
    		+ "            padding-left: 20px;\r\n"
    		+ "        }\r\n"
    		+ "    </style>\r\n"
    		+ "</head>\r\n"
    		+ "<body>\r\n"
    		+ "    <h1>Trợ giúp</h1>\r\n"
    		
    		+ "            <li>Nếu có bất kỳ thắc mắc nào về cách sử dụng phần mềm, lỗi khi sử dụng hoặc muốn đóng góp ý kiến vui lòng gửi thông tin "
    		+"			   về email : nhom2javaIT6019.5@gamil.com</li>"
    		+ "            <li>Cảm bạn đã sử dụng phầm mềm của chúng tôi.</li>\r\n"
    		
    		+ "</body>\r\n"
    		+ "</html>";
    public static void hienhuongdan() {
    	
        JFrame khunghuongdan = new JFrame("Hướng dẫn sử dụng phần mềm");
        khunghuongdan.setSize(600, 600);
        khunghuongdan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        khunghuongdan.setLayout(new BorderLayout());

        JPanel vungnutbam = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JButton nuthdgioithieu    	= new JButton("Giới thiệu ");
        JButton nuthdthem         	= new JButton("Thêm nhân viên");
        JButton nuthdcapnhat      	= new JButton("Cập nhật thông tin nhân viên");
        JButton nuthdxoa          	= new JButton("Xóa nhân viên");
        JButton nuthdtimkiem      	= new JButton("Tìm kiếm nhân viên");
        JButton nuthdmoluu        	= new JButton("Mở hoặc lưu dữ liệu ");
        JButton nuthdquanlytk     	= new JButton("Quản lý tài khoản ");
        JButton nuttrogiup   		= new JButton("Trợ giúp");
        
        vungnutbam.add(nuthdgioithieu);
        vungnutbam.add(nuthdthem);
        vungnutbam.add(nuthdcapnhat);
        vungnutbam.add(nuthdxoa);
        vungnutbam.add(nuthdtimkiem);
        vungnutbam.add(nuthdmoluu);
        vungnutbam.add(nuthdquanlytk);
        vungnutbam.add(nuttrogiup);
        
        khunghuongdan.add(vungnutbam, BorderLayout.NORTH);
        
        vunghuongdan.add(createGuidePanel("Giới thiệu", hdgioithieu), "About");
        vunghuongdan.add(createGuidePanel("Thêm nhân viên", hdthem), "AddEmployee");
        vunghuongdan.add(createGuidePanel("Cập nhật thông tin nhân viên", hdcapnhat), "UpdateEmployee");
        vunghuongdan.add(createGuidePanel("Xóa nhân viên", hdxoa), "DeleteEmployee");
        vunghuongdan.add(createGuidePanel("Tìm kiếm nhân viên", hdtimkiem), "SearchEmployee");
        vunghuongdan.add(createGuidePanel("Mở và lưu dữ liệu", hdmoluu), "OpenSaveData");
        vunghuongdan.add(createGuidePanel("Quản lý tài khoản", hdquanlytk), "AccountManager");
        vunghuongdan.add(createGuidePanel("Trợ giúp", trogiup), "Help");
        khunghuongdan.add(vunghuongdan, BorderLayout.CENTER);

        nuthdgioithieu.addActionListener(e -> showGuide("About"));
        nuthdthem.addActionListener(e -> showGuide("AddEmployee"));
        nuthdcapnhat.addActionListener(e -> showGuide("UpdateEmployee"));
        nuthdxoa.addActionListener(e -> showGuide("DeleteEmployee"));
        nuthdtimkiem.addActionListener(e -> showGuide("SearchEmployee"));
        nuthdmoluu.addActionListener(e -> showGuide("OpenSaveData"));
        nuthdquanlytk.addActionListener(e -> showGuide("AccountManager"));
        nuttrogiup.addActionListener(e -> showGuide("Help"));
        
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
