package BankApp.src.model;

public class TaiKhoan {
    private int soTK;
    private int idKhachHang;
    private double soDu;

    public TaiKhoan(int soTK, int idKhachHang, double soDu) {
        this.soTK = soTK;
        this.idKhachHang = idKhachHang;
        this.soDu = soDu;
    }

    public int getSoTK() { return soTK; }
    public int getIdKhachHang() { return idKhachHang; }
    public double getSoDu() { return soDu; }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
}
