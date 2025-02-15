package Bai4_GettervaSetter; // Khai báo package

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

    // Constructor chỉ có 2 tham số, mặc định giamGia = 0
    public SanPham(String tenSp, double donGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = 0;
    }

    // Getter & Setter cho tenSp
    public String getTenSp() {
        return this.tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    // Getter & Setter cho donGia
    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    // Getter & Setter cho giamGia
    public double getGiamGia() {
        return this.giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    // Phương thức tính thuế nhập khẩu (private)
    private double getThueNhapKhau() {
        return donGia * 0.1;
    }

    // Phương thức xuất thông tin sản phẩm (public)
    public void xuat() {
        System.out.println("\nThông tin sản phẩm:");
        System.out.println("Tên sản phẩm: " + getTenSp());
        System.out.println("Đơn giá: " + getDonGia());
        System.out.println("Giảm giá: " + getGiamGia());
        System.out.println("Thuế nhập khẩu: " + getThueNhapKhau());
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSp = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        this.donGia = scanner.nextDouble();
        System.out.print("Nhập giảm giá: ");
        this.giamGia = scanner.nextDouble();
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        // Nhập thông tin 2 sản phẩm từ bàn phím
        SanPham sp1 = new SanPham("", 0, 0);
        System.out.println("\nNhập thông tin sản phẩm 1:");
        sp1.nhap();

        SanPham sp2 = new SanPham("", 0);
        System.out.println("\nNhập thông tin sản phẩm 2:");
        sp2.nhap();

        // Xuất thông tin 2 sản phẩm
        sp1.xuat();
        sp2.xuat();
    }
}
