package Bai3_Nangcap; // Khai báo package

import java.util.Scanner;

public class SanPham {
    private String tenSp;
    private double donGia;
    private double giamGia;

    // Constructor có đủ 3 tham số
    public SanPham(String tenSp, double donGia, double giamGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    // Constructor chỉ có 2 tham số, ngầm hiểu giamGia = 0
    public SanPham(String tenSp, double donGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = 0;
    }

    // Phương thức tính thuế nhập khẩu (private)
    private double getThueNhapKhau() {
        return donGia * 0.1;
    }

    // Phương thức xuất thông tin sản phẩm (public)
    public void xuat() {
        System.out.println("\nThông tin sản phẩm:");
        System.out.println("Tên sản phẩm: " + tenSp);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Giảm giá: " + giamGia);
        System.out.println("Thuế nhập khẩu: " + getThueNhapKhau());
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        // Tạo sản phẩm có giảm giá
        SanPham sp1 = new SanPham("Laptop Dell", 20000000, 1500000);

        // Tạo sản phẩm không có giảm giá
        SanPham sp2 = new SanPham("iPhone 15", 25000000);

        // Xuất thông tin hai sản phẩm
        sp1.xuat();
        sp2.xuat();
    }
}
