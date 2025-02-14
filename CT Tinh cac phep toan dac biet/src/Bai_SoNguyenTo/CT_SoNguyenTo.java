package Bai_SoNguyenTo;

import java.util.Scanner;

public class CT_SoNguyenTo {
    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Hàm chính để nhập số và in ra dãy số nguyên tố
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số bắt đầu: ");
        int start = scanner.nextInt();
        
        System.out.print("Nhập số kết thúc: ");
        int end = scanner.nextInt();
        
        System.out.println("Các số nguyên tố từ " + start + " đến " + end + " là:");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        
        scanner.close();
    }
}
