import java.time.LocalDate;

public class TaiKhoan {
    private String soTaiKhoan;
    private KhachHang chuSoHuu;
    private double soDu;
    private LocalDate ngayMo;
    private boolean trangThai; // true = hoạt động, false = khóa

    public TaiKhoan(String soTaiKhoan, KhachHang chuSoHuu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuSoHuu = chuSoHuu;
        this.soDu = 0;
        this.ngayMo = LocalDate.now();
        this.trangThai = true;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public KhachHang getChuSoHuu() {
        return chuSoHuu;
    }

    public double getSoDu() {
        return soDu;
    }

    public boolean isHoatDong() {
        return trangThai;
    }

    public void deposit(double amount) {
        if (!trangThai) {
            System.out.println("Tài khoản đang bị khóa!");
            return;
        }
        if (amount > 0) {
            soDu += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (!trangThai) {
            System.out.println("Tài khoản đang bị khóa!");
            return false;
        }
        if (amount > 0 && amount <= soDu) {
            soDu -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(TaiKhoan to, double amount) {
        if (withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "soTK='" + soTaiKhoan + '\'' +
                ", chuSoHuu=" + chuSoHuu.getHoTen() +
                ", soDu=" + soDu +
                ", ngayMo=" + ngayMo +
                ", trangThai=" + (trangThai ? "Hoạt động" : "Khóa") +
                '}';
    }
}
