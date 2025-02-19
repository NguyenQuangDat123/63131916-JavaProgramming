package Toantaphop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TapHop {
    private static Scanner scanner = new Scanner(System.in);

    // Nhập tập hợp từ bàn phím
    public static List<Integer> nhapTapHop(String tenTap) {
        List<Integer> tapHop = new ArrayList<>();
        System.out.print("Nhập số phần tử của " + tenTap + ": ");
        int n = scanner.nextInt();

        System.out.println("Nhập các phần tử của " + tenTap + ":");
        for (int i = 0; i < n; i++) {
            int phanTu = scanner.nextInt();
            if (!tapHop.contains(phanTu)) { // Tránh phần tử trùng
                tapHop.add(phanTu);
            }
        }
        return tapHop;
    }

    // Hợp của hai tập hợp (A ∪ B)
    public static List<Integer> hop(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>(A);
        for (int num : B) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    // Giao của hai tập hợp (A ∩ B)
    public static List<Integer> giao(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        for (int num : A) {
            if (B.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    // Hiệu của hai tập hợp (A - B)
    public static List<Integer> hieu(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>(A);
        result.removeAll(B);
        return result;
    }

    // Tích Descartes của hai tập hợp (A × B)
    public static List<String> tichDescartes(List<Integer> A, List<Integer> B) {
        List<String> result = new ArrayList<>();
        for (int a : A) {
            for (int b : B) {
                result.add("(" + a + "," + b + ")");
            }
        }
        return result;
    }

    // Hiển thị danh sách
    public static void hienThiDanhSach(String moTa, List<?> tapHop) {
        System.out.println(moTa + tapHop);
    }

    public static void main(String[] args) {
        // Nhập tập hợp A và B
        List<Integer> A = nhapTapHop("tập hợp A");
        List<Integer> B = nhapTapHop("tập hợp B");

        // Tính toán và hiển thị kết quả
        hienThiDanhSach("Hợp (A ∪ B): ", hop(A, B));
        hienThiDanhSach("Giao (A ∩ B): ", giao(A, B));
        hienThiDanhSach("Hiệu (A - B): ", hieu(A, B));
        hienThiDanhSach("Hiệu (B - A): ", hieu(B, A));
        hienThiDanhSach("Tích Descartes (A × B): ", tichDescartes(A, B));
    }
}
