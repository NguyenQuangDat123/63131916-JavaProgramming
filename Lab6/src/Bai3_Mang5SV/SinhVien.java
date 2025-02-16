package Bai3_Mang5SV;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class SinhVien {
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String cmnd;

    // Constructor
    public SinhVien(String hoTen, String email, String soDienThoai, String cmnd) {
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.cmnd = cmnd;
    }

    // Phương thức kiểm tra định dạng email
    public static boolean isValidEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email);
    }

    // Phương thức kiểm tra định dạng số điện thoại (bắt đầu bằng 0, có 10 số)
    public static boolean isValidPhone(String phone) {
        return Pattern.matches("^0[0-9]{9}$", phone);
    }

    // Phương thức kiểm tra định dạng CMND (9 hoặc 12 số)
    public static boolean isValidCMND(String cmnd) {
        return Pattern.matches("^[0-9]{9}$|^[0-9]{12}$", cmnd);
    }

    // Hiển thị thông tin sinh viên
    public void xuat() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Email: " + email);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("CMND/CCCD: " + cmnd);
        System.out.println("--------------------------");
    }
}

public class QuanLySinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SinhVien> danhSach = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập thông tin sinh viên " + (i + 1) + ":");

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();

            String email;
            while (true) {
                System.out.print("Email: ");
                email = scanner.nextLine();
                if (SinhVien.isValidEmail(email)) break;
                System.out.println("❌ Email không hợp lệ! Vui lòng nhập lại.");
            }

            String soDienThoai;
            while (true) {
                System.out.print("Số điện thoại: ");
                soDienThoai = scanner.nextLine();
                if (SinhVien.isValidPhone(soDienThoai)) break;
                System.out.println("❌ Số điện thoại không hợp lệ! Vui lòng nhập lại.");
            }

            String cmnd;
            while (true) {
                System.out.print("CMND/CCCD: ");
                cmnd = scanner.nextLine();
                if (SinhVien.isValidCMND(cmnd)) break;
                System.out.println("❌ CMND/CCCD không hợp lệ! Vui lòng nhập lại.");
            }

            danhSach.add(new SinhVien(hoTen, email, soDienThoai, cmnd));
        }

        // Xuất danh sách sinh viên
        System.out.println("\n==== Danh Sách Sinh Viên ====");
        for (SinhVien sv : danhSach) {
            sv.xuat();
        }

        scanner.close();
    }
}
