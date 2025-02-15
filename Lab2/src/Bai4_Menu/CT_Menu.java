package Bai4_Menu;

import java.util.Scanner;

public class CT_Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\n===== MENU CHƯƠNG TRÌNH =====");
            System.out.println("1. Giải phương trình bậc 1 (ax + b = 0)");
            System.out.println("2. Giải phương trình bậc 2 (ax^2 + bx + c = 0)");
            System.out.println("3. Tính tiền điện theo phương pháp lũy tiến");
            System.out.println("4. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    giaiPTBac1(scanner);
                    break;
                case 2:
                    giaiPTBac2(scanner);
                    break;
                case 3:
                    tinhTienDien(scanner);
                    break;
                case 4:
                    System.out.println("Thoát chương trình. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Chức năng 1: Giải phương trình bậc 1 (ax + b = 0)
    public static void giaiPTBac1(Scanner scanner) {
        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            double x = -b / a;
            System.out.println("Nghiệm của phương trình: x = " + x);
        }
    }

    // Chức năng 2: Giải phương trình bậc 2 (ax^2 + bx + c = 0)
    public static void giaiPTBac2(Scanner scanner) {
        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Đây không phải phương trình bậc 2. Chuyển sang giải bậc 1.");
            giaiPTBac1(scanner);
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Phương trình có nghiệm kép: x = " + x);
        } else {
            System.out.println("Phương trình vô nghiệm.");
        }
    }

    // Chức năng 3: Tính tiền điện theo phương pháp lũy tiến
    public static void tinhTienDien(Scanner scanner) {
        System.out.print("Nhập số kWh tiêu thụ trong tháng: ");
        int soKWh = scanner.nextInt();

        double tienDien;
        if (soKWh <= 50) {
            tienDien = soKWh * 1000;
        } else {
            tienDien = 50 * 1000 + (soKWh - 50) * 1200;
        }

        System.out.println("Số tiền điện phải trả: " + tienDien + " VND");
    }
}

