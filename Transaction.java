import java.util.Date; // Cần import lớp Date

public class Transaction {
    private String maGiaoDich;
    private String loaiGiaoDich; 
    private double soTien;
    private Date thoiGian;
    private String moTa;

    // Constructor 
    public Transaction(String maGiaoDich, String loaiGiaoDich, double soTien, String moTa) {
        this.maGiaoDich = maGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.soTien = soTien;
        this.moTa = moTa;
        this.thoiGian = new Date(); // Ghi lại thời điểm tạo giao dịch
    }

    // Bạn nên thêm Getters ở đây để truy xuất thông tin lịch sử giao dịch
    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }
    public double getSoTien() {
        return soTien;
    }
    public Date getThoiGian() {
        return thoiGian;
    }

    @Override
    public String toString() {
        return "GD: " + maGiaoDich + " | Loại: " + loaiGiaoDich + " | Số tiền: " + soTien 
    + " | Thời gian: " + thoiGian;
    }
}