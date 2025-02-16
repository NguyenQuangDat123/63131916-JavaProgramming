package Bai1_HovatenInHoa;

import java.util.Scanner;

public class HovatenInHoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập họ và tên từ bàn phím
        System.out.print("Nhập họ và tên: ");
        String hoTen = scanner.nextLine().trim(); // Xóa khoảng trắng dư thừa

        // Tìm vị trí khoảng trắng đầu tiên và cuối cùng
        int viTriDau = hoTen.indexOf(" ");
        int viTriCuoi = hoTen.lastIndexOf(" ");

        // Kiểm tra xem có đủ phần họ, đệm, tên không
        if (viTriDau == -1) {
            System.out.println("Vui lòng nhập đầy đủ họ và tên!");
        } else {
            String ho = hoTen.substring(0, viTriDau).toUpperCase();
            String ten = hoTen.substring(viTriCuoi + 1).toUpperCase();
            String tenDem = hoTen.substring(viTriDau + 1, viTriCuoi);

            // Xuất kết quả
            System.out.println("Họ: " + ho);
            System.out.println("Tên đệm: " + tenDem);
            System.out.println("Tên: " + ten);
        }
        scanner.close();
    }
}