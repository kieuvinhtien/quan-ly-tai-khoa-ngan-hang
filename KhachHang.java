public class KhachHang {
    private String maKH;
    private String hoTen;
    private String soCCCD;
    private String diaChi;

    public KhachHang(String maKH, String hoTen, String soCCCD, String diaChi) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.soCCCD = soCCCD;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", soCCCD='" + soCCCD + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
