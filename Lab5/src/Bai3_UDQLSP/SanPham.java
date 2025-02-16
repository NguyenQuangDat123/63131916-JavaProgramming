package Bai3_UDQLSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SanPham {
    private String tenSp;
    private double donGia;

    // Constructor
    public SanPham(String tenSp, double donGia) {
        this.tenSp = tenSp;
        this.donGia = donGia;
    }

    // Getter
    public String getTenSp() {
        return tenSp;
    }

    public double getDonGia() {
        return donGia;
    }

    // Xuất thông tin sản phẩm
    public void xuat() {
        System.out.printf("Tên: %s - Giá: %.2f\n", tenSp, donGia);
    }
}

public class QuanLySanPham {
    private static ArrayList<SanPham> danhSach = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm
            switch (choice) {
                case 1:
                    nhap();
                    break;
                case 2:
                    sapXep();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    tinhGiaTrungBinh();
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập từ 1 đến 5.");
            }
        }
    }

    // Hiển thị menu
    public static void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Nhập danh sách sản phẩm");
        System.out.println("2. Sắp xếp giảm dần theo giá và xuất danh sách");
        System.out.println("3. Tìm và xóa sản phẩm theo tên");
        System.out.println("4. Xuất giá trung bình của các sản phẩm");
        System.out.println("5. Kết thúc");
        System.out.print("Chọn chức năng (1-5): ");
    }

    // Nhập danh sách sản phẩm
    public static void nhap() {
        System.out.println("Nhập sản phẩm (nhập 'exit' để dừng):");
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String ten = scanner.nextLine();
            if (ten.equalsIgnoreCase("exit")) break;
            System.out.print("Nhập giá sản phẩm: ");
            double gia = scanner.nextDouble();
            scanner.nextLine(); // Xóa bộ nhớ đệm
            danhSach.add(new SanPham(ten, gia));
        }
    }

    // Xuất danh sách sản phẩm
    public static void xuat() {
        System.out.println("\nDanh sách sản phẩm:");
        for (SanPham sp : danhSach) {
            sp.xuat();
        }
    }

    // Sắp xếp giảm dần theo giá và xuất danh sách
    public static void sapXep() {
        danhSach.sort((o1, o2) -> Double.compare(o2.getDonGia(), o1.getDonGia())); // Sắp xếp giảm dần
        System.out.println("\nDanh sách sau khi sắp xếp giảm dần theo giá:");
        xuat();
    }

    // Tìm và xóa sản phẩm theo tên
    public static void xoa() {
        System.out.print("Nhập tên sản phẩm cần xóa: ");
        String tenCanXoa = scanner.nextLine();
        boolean daXoa = danhSach.removeIf(sp -> sp.getTenSp().equalsIgnoreCase(tenCanXoa));
        if (daXoa) {
            System.out.println("Đã xóa thành công sản phẩm: " + tenCanXoa);
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    // Tính giá trung bình của các sản phẩm
    public static void tinhGiaTrungBinh() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        double tongGia = 0;
        for (SanPham sp : danhSach) {
            tongGia += sp.getDonGia();
        }
        double trungBinh = tongGia / danhSach.size();
        System.out.printf("Giá trung bình của các sản phẩm: %.2f\n", trungBinh);
    }
}


