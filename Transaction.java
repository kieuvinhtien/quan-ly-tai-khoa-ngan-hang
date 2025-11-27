import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String soTaiKhoan;
    private String loaiGiaoDich; // deposit, withdraw, transfer
    private double soTien;
    private LocalDateTime thoiGian;

    public Transaction(String id, String soTaiKhoan, String loaiGiaoDich, double soTien) {
        this.id = id;
        this.soTaiKhoan = soTaiKhoan;
        this.loaiGiaoDich = loaiGiaoDich;
        this.soTien = soTien;
        this.thoiGian = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", soTK='" + soTaiKhoan + '\'' +
                ", loaiGD='" + loaiGiaoDich + '\'' +
                ", soTien=" + soTien +
                ", thoiGian=" + thoiGian +
                '}';
    }
}
