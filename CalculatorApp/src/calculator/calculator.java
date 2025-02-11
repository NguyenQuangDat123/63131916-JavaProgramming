package calculator;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số thứ nhất: ");
        double num1 = scanner.nextDouble();

        System.out.println("Nhập toán tử (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.println("Nhập số thứ hai: ");
        double num2 = scanner.nextDouble();

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Lỗi: Không thể chia cho 0!");
                    return;
                }
                break;
            default:
                System.out.println("Toán tử không hợp lệ!");
                return;
        }

        System.out.println("Kết quả: " + result);
        scanner.close();
    }
}
