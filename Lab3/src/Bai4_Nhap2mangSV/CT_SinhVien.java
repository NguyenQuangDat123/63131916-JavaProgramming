package Bai4_Nhap2mangSV;

import java.util.Scanner;

public class CT_SinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng sinh viên
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống

        String[] hoTen = new String[n];
        double[] diem = new double[n];

        // Nhập thông tin sinh viên
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập họ tên sinh viên thứ " + (i + 1) + ": ");
            hoTen[i] = scanner.nextLine();
            System.out.print("Nhập điểm của sinh viên thứ " + (i + 1) + ": ");
            diem[i] = scanner.nextDouble();
            scanner.nextLine(); // Đọc dòng trống
        }

        // Xuất danh sách sinh viên kèm học lực
        System.out.println("\nDanh sách sinh viên:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s - Điểm: %.2f - Học lực: %s\n", hoTen[i], diem[i], xepLoai(diem[i]));
        }

        // Sắp xếp danh sách theo điểm tăng dần (Sắp xếp nổi bọt - Bubble Sort)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (diem[i] > diem[j]) {
                    // Hoán đổi điểm
                    double tempDiem = diem[i];
                    diem[i] = diem[j];
                    diem[j] = tempDiem;

                    // Hoán đổi tên sinh viên theo điểm
                    String tempTen = hoTen[i];
                    hoTen[i] = hoTen[j];
                    hoTen[j] = tempTen;
                }
            }
        }

        // Xuất danh sách sau khi sắp xếp
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo điểm:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s - Điểm: %.2f - Học lực: %s\n", hoTen[i], diem[i], xepLoai(diem[i]));
        }

        scanner.close();
    }

    // Hàm xét học lực
    public static String xepLoai(double diem) {
        if (diem < 5) return "Yếu";
        else if (diem < 6.5) return "Trung bình";
        else if (diem < 7.5) return "Khá";
        else if (diem < 9) return "Giỏi";
        else return "Xuất sắc";
    }
}
