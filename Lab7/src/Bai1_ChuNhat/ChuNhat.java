package Bai1_ChuNhat;

import java.util.Scanner;

class ChuNhat {
    protected double rong;
    protected double dai;

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double getChuVi() {
        return 2 * (dai + rong);
    }

    public double getDienTich() {
        return dai * rong;
    }

    public void xuat() {
        System.out.println("Hình chữ nhật:");
        System.out.println("Chiều dài: " + dai);
        System.out.println("Chiều rộng: " + rong);
        System.out.println("Diện tích: " + getDienTich());
        System.out.println("Chu vi: " + getChuVi());
        System.out.println("--------------------------");
    }
}

class Vuong extends ChuNhat {
    public Vuong(double canh) {
        super(canh, canh);
    }

    @Override
    public void xuat() {
        System.out.println("Hình vuông:");
        System.out.println("Cạnh: " + dai);
        System.out.println("Diện tích: " + getDienTich());
        System.out.println("Chu vi: " + getChuVi());
        System.out.println("--------------------------");
    }
}

public class HinhHocTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập hình chữ nhật 1:");
        System.out.print("Chiều dài: ");
        double dai1 = scanner.nextDouble();
        System.out.print("Chiều rộng: ");
        double rong1 = scanner.nextDouble();
        ChuNhat cn1 = new ChuNhat(dai1, rong1);

        System.out.println("Nhập hình chữ nhật 2:");
        System.out.print("Chiều dài: ");
        double dai2 = scanner.nextDouble();
        System.out.print("Chiều rộng: ");
        double rong2 = scanner.nextDouble();
        ChuNhat cn2 = new ChuNhat(dai2, rong2);

        System.out.println("Nhập hình vuông:");
        System.out.print("Cạnh: ");
        double canh = scanner.nextDouble();
        ChuNhat vu = new Vuong(canh);

        System.out.println("\n==== KẾT QUẢ ====");
        cn1.xuat();
        cn2.xuat();
        vu.xuat();
    }
}

