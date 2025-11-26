import java.util.ArrayList;

public class TaiKhoan {
    
    private String soTaiKhoan;
    private double soDu;
    private String loaiTaiKhoan;
    private ArrayList<Transaction> transactions; // Đã chuẩn hóa tên

    // Constructor
    public TaiKhoan(String soTaiKhoan, double soDu, String loaiTaiKhoan){
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.transactions = new ArrayList<>(); 
    }

    
    public String getSoTaiKhoan(){
        return soTaiKhoan;
    }
    public double getSoDu(){
        return soDu;
    }
    public String getLoaiTaiKhoan(){
        return loaiTaiKhoan;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setSoTaiKhoan(String soTaiKhoan){
        this.soTaiKhoan = soTaiKhoan;
    }
    public void setSoDu(double soDu){
        this.soDu = soDu;
    }
    public void setLoaiTaiKhoan(String loaiTaiKhoan){
        this.loaiTaiKhoan = loaiTaiKhoan;
    }
}