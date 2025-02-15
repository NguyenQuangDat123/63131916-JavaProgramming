package Bai1_LopSP;

import java.util.Scanner;

public class SanPham {
    private String tenSp;
    private double donGia;
    private double giamGia;

    // Constructor
    public SanPham() {}

    public SanPham(String tenSp, double donGia, double giamGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    // Tính thuế nhập khẩu (10% giá sản phẩm)
    public double getThueNhapKhau() {
        return donGia * 0.1;
    }

    // Nhập thông tin sản phẩm
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        tenSp = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = scanner.nextDouble();
        System.out.print("Nhập giảm giá: ");
        giamGia = scanner.nextDouble();
    }

    // Xuất thông tin sản phẩm
    public void xuat() {
        System.out.println("\nThông tin sản phẩm:");
        System.out.println("Tên sản phẩm: " + tenSp);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Giảm giá: " + giamGia);
        System.out.println("Thuế nhập khẩu: " + getThueNhapKhau());
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        SanPham sp = new SanPham();
        sp.nhap();
        sp.xuat();
    }
}
