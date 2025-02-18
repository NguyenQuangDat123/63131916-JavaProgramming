package TinhTong;


import java.util.Scanner; // Import thư viện Scanner

public class CTTinhTong {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập số a
        System.out.print("Nhập số a: ");
        double a = scanner.nextDouble();

        // Nhập số b
        System.out.print("Nhập số b: ");
        double b = scanner.nextDouble();

        // Tính tổng
        double tong = a + b;

        // In kết quả
        System.out.println("Tổng của " + a + " và " + b + " là: " + tong);

        // Đóng Scanner
        scanner.close();
    }
}
