package Bai2_Mang5SP;
import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    private String tenSp;
    private double donGia;
    private String hang;

    // Constructor
    public SanPham(String tenSp, double donGia, String hang) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.hang = hang;
    }

    // Getter cho hãng
    public String getHang() {
        return hang;
    }

    // Phương thức xuất thông tin sản phẩm
    public void xuat() {
        System.out.println("Tên sản phẩm: " + tenSp);
        System.out.println("Giá: " + donGia);
        System.out.println("Hãng: " + hang);
        System.out.println("----------------------");
    }
}

public class QuanLySanPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SanPham> danhSach = new ArrayList<>();

        // Nhập 5 sản phẩm
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            System.out.print("Tên sản phẩm: ");
            String tenSp = scanner.nextLine();
            System.out.print("Giá: ");
            double donGia = scanner.nextDouble();
            scanner.nextLine(); // Xóa bộ nhớ đệm
            System.out.print("Hãng: ");
            String hang = scanner.nextLine();

            danhSach.add(new SanPham(tenSp, donGia, hang));
        }

        // Xuất thông tin sản phẩm của hãng Nokia
        System.out.println("\nDanh sách sản phẩm thuộc hãng Nokia:");
        for (SanPham sp : danhSach) {
            if (sp.getHang().equalsIgnoreCase("Nokia")) {
                sp.xuat();
            }
        }

        scanner.close();
    }
}
