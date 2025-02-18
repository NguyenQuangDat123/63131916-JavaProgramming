import java.util.ArrayList;

class SanPham {
    private int maSP;
    private String tenSP;
    private String loaiSP;
    private String anhSP;

    // Constructor mặc định
    public SanPham() {
    }

    // Constructor có tham số
    public SanPham(int maSP, String tenSP, String loaiSP, String anhSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.anhSP = anhSP;
    }

    // Getter và Setter
    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    // Ghi đè phương thức toString để hiển thị sản phẩm
    @Override
    public String toString() {
        return "Mã SP: " + maSP + ", Tên SP: " + tenSP + ", Loại SP: " + loaiSP + ", Ảnh: " + anhSP;
    }
}

public class CT {
    public static void main(String[] args) {
        // Tạo 2 sản phẩm
        SanPham sp1 = new SanPham();  // Khởi tạo đối tượng
        sp1.setMaSP(1);
        sp1.setTenSP("BiaSG");
        sp1.setLoaiSP("Đồ uống có cồn");
        sp1.setAnhSP("sq.png");

        SanPham sp2 = new SanPham(2, "Bánh Chuối", "Đồ ăn nhanh", "bc.jpg");

        // In thông tin 2 sản phẩm
        System.out.println(sp1.toString());
        System.out.println(sp2.toString());
    }
}
