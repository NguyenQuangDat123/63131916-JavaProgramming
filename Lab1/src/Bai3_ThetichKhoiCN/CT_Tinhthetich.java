package Bai3_ThetichKhoiCN;

import java.util.Scanner;

public class CT_Tinhthetich {
    public static void main(String[] args) {
        // Khai báo Scanner để nhập từ bàn phím
        Scanner scanner = new Scanner(System.in);
        
        // Nhập cạnh của khối lập phương
        System.out.print("Nhập cạnh của khối lập phương: ");
        double canh = scanner.nextDouble();
        
        // Tính thể tích
        double theTich = Math.pow(canh, 3);
        
        // Xuất kết quả ra màn hình
        System.out.println("Thể tích của khối lập phương là: " + theTich);
        
        // Đóng Scanner
        scanner.close();
    }
}
