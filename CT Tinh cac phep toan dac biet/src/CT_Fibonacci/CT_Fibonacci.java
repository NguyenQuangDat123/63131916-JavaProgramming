package CT_Fibonacci;

import java.util.Scanner;

public class CT_Fibonacci {
    // Hàm tính dãy Fibonacci
    public static void fibonacci(int n) {
        int first = 0, second = 1;
        System.out.print("Dãy Fibonacci với " + n + " số là: ");
        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử Fibonacci cần in: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Vui lòng nhập số lớn hơn 0.");
        } else {
            fibonacci(n);
        }

        scanner.close();
    }
}
