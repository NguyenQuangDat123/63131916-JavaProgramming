package Bai1_DTB;

import java.util.Scanner;

public class CT_TinhDTB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập thông tin sinh viên
        System.out.print("Nhập họ và tên sinh viên: ");
        String hoTen = scanner.nextLine();
        
        System.out.print("Nhập điểm trung bình: ");
        double diemTB = scanner.nextDouble();
        
        // Xuất kết quả ra màn hình
        System.out.println("\n===== KẾT QUẢ =====");
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Điểm trung bình: " + diemTB);
        
        scanner.close();
    }
}
