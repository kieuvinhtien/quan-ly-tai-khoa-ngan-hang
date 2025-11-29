package BankApp.src.model;

import javax.swing.*;

public class MainUI extends JFrame {

    QuanLyTaiKhoan ql = new QuanLyTaiKhoan();

    public MainUI() {
        setTitle("Quản lý tài khoản");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbl = new JLabel("Số tài khoản:");
        lbl.setBounds(20, 20, 120, 25);
        add(lbl);

        JTextField txt = new JTextField();
        txt.setBounds(140, 20, 120, 25);
        add(txt);

        JButton nap = new JButton("Nạp 100k");
        nap.setBounds(20, 70, 120, 30);
        add(nap);

        nap.addActionListener(e -> {
            int stk = Integer.parseInt(txt.getText());
            boolean ok = ql.napTien(stk, 100000);
            JOptionPane.showMessageDialog(this, ok ? "Thành công!" : "Thất bại!");
        });

        setVisible(true);
    }
}

