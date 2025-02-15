package Bai2_BangCC;

public class CT_BangCuuChuong {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) { // Duyệt qua các bảng nhân từ 1 đến 9
            System.out.println("Bảng nhân " + i + ":");
            for (int j = 1; j <= 10; j++) { // Duyệt qua các số từ 1 đến 10
                System.out.printf("%d x %d = %d\n", i, j, i * j);
            }
            System.out.println(); // Xuống dòng sau mỗi bảng
        }
    }
}
