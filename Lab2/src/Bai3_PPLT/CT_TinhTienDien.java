package Bai3_PPLT;

import java.util.Scanner;

public class CT_TinhTienDien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số kWh tiêu thụ trong tháng
        System.out.print("Nhập số kWh tiêu thụ trong tháng: ");
        int soKWh = scanner.nextInt();

        // Tính tiền điện
        double tienDien;
        if (soKWh <= 50) {
            tienDien = soKWh * 1000;
        } else {
            tienDien = 50 * 1000 + (soKWh - 50) * 1200;
        }

        // Xuất kết quả
        System.out.println("Số tiền điện phải trả: " + tienDien + " VND");

        scanner.close();
    }
}
