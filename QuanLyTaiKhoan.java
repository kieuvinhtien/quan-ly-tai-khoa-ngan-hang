package BankApp.src.model;

import java.sql.*;

public class QuanLyTaiKhoan {

    public TaiKhoan getTaiKhoan(int soTK) {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM taikhoan WHERE soTK=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soTK);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new TaiKhoan(
                        rs.getInt("soTK"),
                        rs.getInt("idKH"),
                        rs.getDouble("soDu")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean napTien(int soTK, double soTien) {
        try (Connection conn = Database.getConnection()) {
            String sql = "UPDATE taikhoan SET soDu = soDu + ? WHERE soTK=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, soTien);
            ps.setInt(2, soTK);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean rutTien(int soTK, double soTien) {
        TaiKhoan tk = getTaiKhoan(soTK);
        if (tk == null || tk.getSoDu() < soTien) return false;

        try (Connection conn = Database.getConnection()) {
            String sql = "UPDATE taikhoan SET soDu = soDu - ? WHERE soTK=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, soTien);
            ps.setInt(2, soTK);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}

