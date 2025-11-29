package BankApp.src.model;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int soTK;
    private String loai;
    private double soTien;
    private LocalDateTime thoiGian;

    public Transaction(int id, int soTK, String loai, double soTien, LocalDateTime thoiGian) {
        this.id = id;
        this.soTK = soTK;
        this.loai = loai;
        this.soTien = soTien;
        this.thoiGian = thoiGian;
    }
}
