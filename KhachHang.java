public class KhachHang {
    private String id;
    private String tenKH;
    private String diachi;
    private String sdt;

    public KhachHang(String id, String tenKH, String diachi, String sdt) {
        this.id = id;
        this.tenKH = tenKH;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public String getid() {
        return id;
    }

    public String gettenKH() {
        return tenKH;
    }

    public String getdiachi() {
        return diachi;
    }

    public String getsdt() {
        return sdt;
    }
    public void setid(String id) {
        this.id = id;
    }
    public void settenKH(String tenKH)  {
        this.tenKH = tenKH;
    }
    public void setdiachi(String diachi){
        this.diachi = diachi;
    }
    public void setsdt(String sdt){
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "Mã KH: " + id + ", Tên: " + tenKH + ", Địa chỉ: " + diachi + ", Số điện thoại:" + sdt;
    }
}