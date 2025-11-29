package BankApp.src.model;

import javax.swing.*;

import java.awt.*;

public class LoginUI extends JFrame {

    public LoginUI() {
        setTitle("Đăng nhập");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btn = new JButton("Vào ứng dụng");
        btn.addActionListener(e -> {
            new MainUI();
            dispose();
        });

        add(btn, BorderLayout.CENTER);
        setVisible(true);
    }
}
