package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import control.LoginControler;

public class SlidingMenuDemo extends JFrame {
    private JPanel contentPane;
    private JPanel slidingMenu;
    private Timer timer;
    private boolean isMenuOpen = false;
    private int menuWidth = 200;
    private int animationStep = 10;
    private JButton toggleButton;

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    SlidingMenuDemo frame = new SlidingMenuDemo();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public SlidingMenuDemo() {
    	this.setTitle("Trang chủ");
    	setResizable(false);// cố định cửa số không cho phóng to
        LoginControler ac = new LoginControler(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        slidingMenu = new JPanel();
        slidingMenu.setLayout(new BoxLayout(slidingMenu, BoxLayout.Y_AXIS)); // Set layout to BoxLayout
        slidingMenu.setBounds(-menuWidth, 0, menuWidth, getContentPane().getHeight());
        slidingMenu.setBackground(Color.LIGHT_GRAY);
        contentPane.add(slidingMenu);

        // Add individual buttons
        JButton homeButton = new JButton("Trang chủ");
        homeButton.addActionListener(ac);
        JButton employeeManagementButton = new JButton("Quản lí nhân viên");
        employeeManagementButton.addActionListener(ac);
        JButton accountManagementButton = new JButton("Quản lí tài khoản");
        accountManagementButton.addActionListener(ac);
        JButton guideButton = new JButton("Hướng dẫn");
        guideButton.addActionListener(ac);
        JButton logoutButton = new JButton("Đăng xuất");
        logoutButton.addActionListener(ac);
        JButton editButton = new JButton("Chỉnh sửa");
        editButton.addActionListener(ac);

        // Add buttons to the sliding menu with spacing
        addMenuButton(homeButton);
        addMenuButton(employeeManagementButton);
        addMenuButton(accountManagementButton);
        addMenuButton(guideButton);
        addMenuButton(logoutButton);
        addMenuButton(editButton);

        // Add toggle button for opening and closing the menu
        toggleButton = new JButton("Đóng menu");
        toggleButton.setMaximumSize(new Dimension(menuWidth, 40)); // Set maximum size to button width
        toggleButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleMenu();
            }
        });
        slidingMenu.add(Box.createVerticalStrut(10)); // Add space before toggle button
        slidingMenu.add(toggleButton);

        JButton menuButton = new JButton("|||");
        menuButton.setBounds(10, 10, 50, 30);
        contentPane.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleMenu();
            }
        });

        timer = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animateMenu();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                slidingMenu.setBounds(slidingMenu.getX(), 0, menuWidth, getContentPane().getHeight());
            }
        });
    }

    // Method to add menu button with spacing
    private void addMenuButton(JButton button) {
        button.setMaximumSize(new Dimension(menuWidth, 40)); // Set maximum size to button width
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        slidingMenu.add(button);
        slidingMenu.add(Box.createVerticalStrut(10)); // Add space between buttons
    }

    private void toggleMenu() {
        isMenuOpen = !isMenuOpen;
        if (isMenuOpen) {
            toggleButton.setText("Đóng menu");
        } else {
            toggleButton.setText("Mở menu");
        }
        timer.start();
    }

    private void animateMenu() {
        int currentX = slidingMenu.getX();
        if (isMenuOpen) {
            if (currentX < 0) {
                slidingMenu.setLocation(currentX + animationStep, 0);
            } else {
                slidingMenu.setLocation(0, 0);
                timer.stop();
            }
        } else {
            if (currentX > -menuWidth) {
                slidingMenu.setLocation(currentX - animationStep, 0);
            } else {
                slidingMenu.setLocation(-menuWidth, 0);
                timer.stop();
            }
        }
        contentPane.revalidate();
        contentPane.repaint();
    }
}
