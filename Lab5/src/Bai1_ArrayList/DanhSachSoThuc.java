package Bai1_ArrayList; // Nếu dùng package, hãy giữ lại dòng này

import java.util.ArrayList; // Import thư viện ArrayList
import java.util.Scanner; // Import thư viện Scanner

public class DanhSachSoThuc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();

        // Nhập danh sách số thực từ bàn phím
        while (true) {
            System.out.print("Nhập số thực: ");
            Double x = scanner.nextDouble();
            list.add(x);

            // Hỏi người dùng có muốn nhập thêm không
            System.out.print("Nhập thêm (Y/N)? ");
            scanner.nextLine(); // Đọc ký tự xuống dòng còn sót
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        // Xuất danh sách số thực đã nhập
        System.out.println("\nDanh sách số thực đã nhập:");
        for (Double num : list) {
            System.out.print(num + " ");
        }

        // Tính tổng các số trong danh sách
        double sum = 0;
        for (Double num : list) {
            sum += num;
        }

        // Xuất tổng
        System.out.println("\nTổng các số trong danh sách: " + sum);

        scanner.close(); // Đóng Scanner để tránh rò rỉ bộ nhớ
    }
}
