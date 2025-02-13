package Bai2_ChuviDT;

import java.util.Scanner;

public class CT_TinhchuviDT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhập hai cạnh của hình chữ nhật
        System.out.print("Nhập cạnh thứ nhất của hình chữ nhật: ");
        double canh1 = scanner.nextDouble();
        
        System.out.print("Nhập cạnh thứ hai của hình chữ nhật: ");
        double canh2 = scanner.nextDouble();
        
        // Tính chu vi và diện tích
        double chuVi = 2 * (canh1 + canh2);
        double dienTich = canh1 * canh2;
        double canhNho = Math.min(canh1, canh2);
        
        // Xuất kết quả ra màn hình
        System.out.println("\n===== KẾT QUẢ =====");
        System.out.println("Chu vi hình chữ nhật: " + chuVi);
        System.out.println("Diện tích hình chữ nhật: " + dienTich);
        System.out.println("Cạnh nhỏ của hình chữ nhật: " + canhNho);
        
        scanner.close();
    }
}
