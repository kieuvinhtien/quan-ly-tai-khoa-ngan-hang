package BankApp.src.model;

public class KhachHang {
    private int id;
    private String ten;
    private String diaChi;

    public KhachHang(int id, String ten, String diaChi) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public int getId() { return id; }
    public String getTen() { return ten; }
    public String getDiaChi() { return diaChi; }

    @Override
    public String toString() {
        return ten + " - " + id;
    }
}
