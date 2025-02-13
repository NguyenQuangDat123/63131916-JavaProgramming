package Bai4_Delta;

import java.util.Scanner;

public class CT_TinhDelta {
    public static void main(String[] args) {
        // Khai báo Scanner để nhập từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập hệ số a, b, c
        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();

        // Tính Delta
        double delta = Math.pow(b, 2) - 4 * a * c;
        
        // Xuất kết quả
        System.out.println("Delta = " + delta);
        
        // Tính căn Delta nếu Delta >= 0
        if (delta >= 0) {
            double sqrtDelta = Math.sqrt(delta);
            System.out.println("Căn Delta = " + sqrtDelta);
        } else {
            System.out.println("Delta âm, không thể tính căn Delta.");
        }

        // Đóng Scanner
        scanner.close();
    }
}
