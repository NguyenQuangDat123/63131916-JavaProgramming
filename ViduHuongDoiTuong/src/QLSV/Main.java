package QLSV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
        Scanner scanner = new Scanner(System.in);

        // Menu loop
        while (true) {
            System.out.println("\nHệ thống Quản lý Sinh Viên");
            System.out.println("1. Thêm Sinh Viên");
            System.out.println("2. Hiển thị Sinh Viên");
            System.out.println("3. Tìm Sinh Viên theo ID");
            System.out.println("4. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left by nextInt()

            switch (choice) {
                case 1:
                    // Thêm sinh viên
                    System.out.print("Nhập ID sinh viên: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi sinh viên: ");
                    int age = scanner.nextInt();
                    SinhVien sinhVien = new SinhVien(id, name, age);
                    quanLySinhVien.themSinhVien(sinhVien);
                    System.out.println("Sinh viên đã được thêm thành công!");
                    break;

                case 2:
                    // Hiển thị danh sách sinh viên
                    quanLySinhVien.hienThiSinhVien();
                    break;

                case 3:
                    // Tìm sinh viên theo ID
                    System.out.print("Nhập ID sinh viên cần tìm: ");
                    int searchId = scanner.nextInt();
                    SinhVien foundSinhVien = quanLySinhVien.timSinhVienTheoId(searchId);
                    if (foundSinhVien != null) {
                        System.out.println("Sinh viên tìm thấy: " + foundSinhVien);
                    } else {
                        System.out.println("Không tìm thấy sinh viên.");
                    }
                    break;

                case 4:
                    // Thoát
                    System.out.println("Thoát hệ thống.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Tùy chọn không hợp lệ, vui lòng thử lại.");
                    break;
            }
        }
    }
}
