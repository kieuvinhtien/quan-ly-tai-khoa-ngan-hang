public class QuanLyTaiKhoan {
    // 1. Loại bỏ ArrayList và thay thế bằng các DAO
    // private List<TaiKhoan> danhSachTaiKhoan; // LOẠI BỎ
    
    private TaiKhoanDAO tkDAO;
    private TransactionDAO transactionDAO;
    // Cần có tham chiếu đến QuanLyKhachHang nếu muốn tạo Tài khoản mới cho KH
    // private QuanLyKhachHang qlkh; 

    public QuanLyTaiKhoan(/* QuanLyKhachHang qlkh */) {
        this.tkDAO = new TaiKhoanDAO(); // Khởi tạo DAO
        this.transactionDAO = new TransactionDAO(); // Cần tạo lớp này
        // this.qlkh = qlkh;
    }

    // Phương thức hỗ trợ vẫn giữ nguyên mục tiêu, nhưng bây giờ gọi DAO
    public TaiKhoan timTaiKhoan(String soTK) {
        // Thay vì tìm trong ArrayList, gọi DAO để lấy dữ liệu từ DB
        return tkDAO.layTaiKhoan(soTK); 
    }
    
    // Phương thức ghi nhận giao dịch sử dụng TransactionDAO
    private void ghiNhanGiaoDich(TaiKhoan tk, String loaiGD, double soTien, String moTa) {
        // Tạo đối tượng Transaction và gọi DAO để lưu vào DB
        String maGD = UUID.randomUUID().toString().substring(0, 8); 
        Transaction giaoDichMoi = new Transaction(maGD, loaiGD, soTien, moTa);
        
        // Cần thêm phương thức này vào TransactionDAO
        transactionDAO.luuGiaoDich(giaoDichMoi, tk.getSoTaiKhoan()); 
    }
    
    //------------------------------------------
    // 2. NẠP TIỀN (Ví dụ về sự thay đổi)
    //------------------------------------------
    @Override
    public boolean napTien(String soTK, double soTien) {
        TaiKhoan tk = tkDAO.layTaiKhoan(soTK); // Lấy từ DB
        if (tk == null || soTien <= 0) {
            return false;
        }

        double soDuMoi = tk.getSoDu() + soTien;
        
        // 1. Cập nhật vào DB
        boolean success = tkDAO.capNhatSoDu(soTK, soDuMoi);
        
        if (success) {
            // 2. Ghi lại giao dịch vào DB
            ghiNhanGiaoDich(tk, "NAP", soTien, "Nạp tiền");
        }
        
        return success;
    }
    
    // ... Cần sửa lại tương tự cho rutTien, moTaiKhoan, layLichSuGiaoDich, v.v.
}