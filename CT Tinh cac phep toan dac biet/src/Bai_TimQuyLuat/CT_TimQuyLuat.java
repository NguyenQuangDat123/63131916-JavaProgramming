package Bai_TimQuyLuat;

import java.util.Scanner;

public class CT_TimQuyLuat {
    // Hàm tìm quy luật tạo ra số nhập vào
    public static void findRules(int number) {
        System.out.println("Các phép toán tạo ra số " + number + " là:");

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if (i + j == number) {
                    System.out.println(i + " + " + j + " = " + number);
                }
                if (i - j == number) {
                    System.out.println(i + " - " + j + " = " + number);
                }
                if (i * j == number) {
                    System.out.println(i + " * " + j + " = " + number);
                }
                if (j != 0 && i / j == number && i % j == 0) {
                    System.out.println(i + " / " + j + " = " + number);
                }
            }
        }
    }

    // Hàm chính
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số cần tìm quy luật: ");
        int number = scanner.nextInt();

        findRules(number);

        scanner.close();
    }
}
