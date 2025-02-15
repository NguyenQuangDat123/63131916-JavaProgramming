package Bai2_PhuongthucSP;
import java.util.Scanner;

public class SanPham {
    private String tenSp;
    private double donGia;
    private double giamGia;

    // Constructor không tham số
    public SanPham() {}

    // Constructor có tham số
    public SanPham(String tenSp, double donGia, double giamGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    // Phương thức tính thuế nhập khẩu (10% giá sản phẩm)
    public double getThueNhapKhau() {
        return donGia * 0.1;
    }

    // Phương thức nhập thông tin sản phẩm từ bàn phím
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        tenSp = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = scanner.nextDouble();
        System.out.print("Nhập giảm giá: ");
        giamGia = scanner.nextDouble();
    }

    // Phương thức xuất thông tin sản phẩm
    public void xuat() {
        System.out.println("\nThông tin sản phẩm:");
        System.out.println("Tên sản phẩm: " + tenSp);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Giảm giá: " + giamGia);
        System.out.println("Thuế nhập khẩu: " + getThueNhapKhau());
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        // Tạo hai đối tượng sản phẩm
        SanPham sp1 = new SanPham();
        SanPham sp2 = new SanPham();

        // Nhập thông tin cho hai sản phẩm
        System.out.println("Nhập thông tin sản phẩm 1:");
        sp1.nhap();
        System.out.println("\nNhập thông tin sản phẩm 2:");
        sp2.nhap();

        // Xuất thông tin hai sản phẩm
        System.out.println("\nThông tin hai sản phẩm:");
        sp1.xuat();
        sp2.xuat();
    }
}
