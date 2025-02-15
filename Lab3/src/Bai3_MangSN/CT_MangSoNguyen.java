package Bai3_MangSN;

import java.util.Arrays;
import java.util.Scanner;

public class CT_MangSoNguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số phần tử của mảng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        int[] a = new int[n];

        // Nhập từng phần tử
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
        }

        // Sắp xếp mảng
        Arrays.sort(a);

        // Xuất mảng sau khi sắp xếp
        System.out.println("\nMảng sau khi sắp xếp:");
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Tìm phần tử nhỏ nhất
        int min = a[0];
        System.out.println("Phần tử nhỏ nhất trong mảng là: " + min);

        // Tính trung bình cộng các số chia hết cho 3
        int sum = 0, count = 0;
        for (int num : a) {
            if (num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        if (count > 0) {
            double avg = (double) sum / count;
            System.out.println("Trung bình cộng các phần tử chia hết cho 3: " + avg);
        } else {
            System.out.println("Không có phần tử nào chia hết cho 3.");
        }

        scanner.close();
    }
}
