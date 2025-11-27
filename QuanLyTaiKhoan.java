import java.util.ArrayList;
import java.util.List;

public class QuanLyTaiKhoan {
    private List<TaiKhoan> danhSachTK = new ArrayList<>();
    private List<Transaction> lichSuGD = new ArrayList<>();

    public void themTaiKhoan(TaiKhoan tk) {
        danhSachTK.add(tk);
    }

    public TaiKhoan timTaiKhoan(String soTK) {
        for (TaiKhoan tk : danhSachTK) {
            if (tk.getSoTaiKhoan().equals(soTK)) {
                return tk;
            }
        }
        return null;
    }

    public void napTien(String soTK, double amount) {
        TaiKhoan tk = timTaiKhoan(soTK);
        if (tk != null) {
            tk.deposit(amount);
            lichSuGD.add(new Transaction("GD" + lichSuGD.size(), soTK, "DEPOSIT", amount));
        }
    }

    public void rutTien(String soTK, double amount) {
        TaiKhoan tk = timTaiKhoan(soTK);
        if (tk != null && tk.withdraw(amount)) {
            lichSuGD.add(new Transaction("GD" + lichSuGD.size(), soTK, "WITHDRAW", amount));
        }
    }

    public void chuyenTien(String from, String to, double amount) {
        TaiKhoan tkFrom = timTaiKhoan(from);
        TaiKhoan tkTo = timTaiKhoan(to);

        if (tkFrom != null && tkTo != null && tkFrom.transfer(tkTo, amount)) {
            lichSuGD.add(new Transaction("GD" + lichSuGD.size(), from, "TRANSFER_OUT", amount));
            lichSuGD.add(new Transaction("GD" + lichSuGD.size(), to, "TRANSFER_IN", amount));
        }
    }

    public void inLichSu() {
        for (Transaction gd : lichSuGD) {
            System.out.println(gd);
        }
    }
}
