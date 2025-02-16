package Bai2_Chucnang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyDanhSachHoTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachHoTen = new ArrayList<>();

        while (true) {
            // Hiển thị menu lựa chọn
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách họ và tên");
            System.out.println("2. Xuất danh sách vừa nhập");
            System.out.println("3. Xuất danh sách ngẫu nhiên");
            System.out.println("4. Sắp xếp giảm dần và xuất danh sách");
            System.out.println("5. Tìm và xóa họ tên nhập từ bàn phím");
            System.out.println("6. Kết thúc");
            System.out.print("Chọn chức năng (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng

            switch (choice) {
                case 1:
                    // Nhập danh sách họ và tên
                    System.out.println("Nhập họ và tên (nhập 'exit' để dừng):");
                    while (true) {
                        System.out.print("Nhập tên: ");
                        String hoTen = scanner.nextLine();
                        if (hoTen.equalsIgnoreCase("exit")) {
                            break;
                        }
                        danhSachHoTen.add(hoTen);
                    }
                    break;

                case 2:
                    // Xuất danh sách vừa nhập
                    System.out.println("\nDanh sách họ và tên:");
                    for (String hoTen : danhSachHoTen) {
                        System.out.println(hoTen);
                    }
                    break;

                case 3:
                    // Xuất danh sách ngẫu nhiên
                    Collections.shuffle(danhSachHoTen);
                    System.out.println("\nDanh sách sau khi xáo trộn:");
                    for (String hoTen : danhSachHoTen) {
                        System.out.println(hoTen);
                    }
                    break;

                case 4:
                    // Sắp xếp giảm dần và xuất danh sách
                    danhSachHoTen.sort(Collections.reverseOrder());
                    System.out.println("\nDanh sách sau khi sắp xếp giảm dần:");
                    for (String hoTen : danhSachHoTen) {
                        System.out.println(hoTen);
                    }
                    break;

                case 5:
                    // Tìm và xóa họ tên nhập từ bàn phím
                    System.out.print("Nhập họ tên cần xóa: ");
                    String tenCanXoa = scanner.nextLine();
                    if (danhSachHoTen.remove(tenCanXoa)) {
                        System.out.println("Đã xóa thành công: " + tenCanXoa);
                    } else {
                        System.out.println("Không tìm thấy tên trong danh sách.");
                    }
                    break;

                case 6:
                    // Kết thúc chương trình
                    System.out.println("Chương trình kết thúc!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập từ 1 đến 6.");
            }
        }
    }
}


