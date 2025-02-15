package Bai1_Songuyento;

import java.util.Scanner;

public class CT_KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập một số nguyên: ");
        int N = scanner.nextInt();
        
        if (N < 2) {
            System.out.println(N + " không phải là số nguyên tố.");
        } else {
            boolean ok = true;
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                System.out.println(N + " là số nguyên tố.");
            } else {
                System.out.println(N + " không phải là số nguyên tố.");
            }
        }
        
        scanner.close();
    }
}
