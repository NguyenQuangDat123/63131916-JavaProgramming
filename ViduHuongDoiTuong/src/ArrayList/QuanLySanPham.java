package ArrayList;
import java.util.ArrayList;


class SanPham {
    private String ten;
    private String muc;

    // Constructor
    public SanPham(String ten, String muc) {
        this.ten = ten;
        this.muc = muc;
    }


    public void hienThi() {
        System.out.println("Tên sản phẩm: " + ten + " | Mục: " + muc);
    }
}


public class QuanLySanPham {
    public static void main(String[] args) {

        ArrayList<SanPham> dsSanPham = new ArrayList<>();


        dsSanPham.add(new SanPham("Kem", "Giải khát"));
        dsSanPham.add(new SanPham("Cơm", "Đồ ăn"));
        dsSanPham.add(new SanPham("Phở", "Đồ ăn"));


        System.out.println("===== Danh sách sản phẩm =====");
        for (SanPham sp : dsSanPham) {
            sp.hienThi();
        }
    }
}
