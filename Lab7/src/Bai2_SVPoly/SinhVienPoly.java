package Bai2_SVPoly;

abstract class SinhVienPoly {
    protected String hoTen;
    protected String nganh;

    public SinhVienPoly(String hoTen, String nganh) {
        this.hoTen = hoTen;
        this.nganh = nganh;
    }

    public abstract double getDiem(); 

    public String getHocLuc() {
        double diem = getDiem();
        if (diem < 5) return "Yếu";
        else if (diem < 6.5) return "Trung bình";
        else if (diem < 7.5) return "Khá";
        else if (diem < 9) return "Giỏi";
        else return "Xuất sắc";
    }

    public void xuat() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngành: " + nganh);
        System.out.println("Điểm: " + getDiem());
        System.out.println("Học lực: " + getHocLuc());
        System.out.println("--------------------------");
    }
}

class SinhVienIT extends SinhVienPoly {
    private double diemJava, diemHtml, diemCss;

    public SinhVienIT(String hoTen, double diemJava, double diemHtml, double diemCss) {
        super(hoTen, "Công nghệ thông tin");
        this.diemJava = diemJava;
        this.diemHtml = diemHtml;
        this.diemCss = diemCss;
    }

    @Override
    public double getDiem() {
        return (2 * diemJava + diemHtml + diemCss) / 4;
    }
}

class SinhVienBiz extends SinhVienPoly {
    private double diemMarketing, diemSales;

    public SinhVienBiz(String hoTen, double diemMarketing, double diemSales) {
        super(hoTen, "Kinh doanh");
        this.diemMarketing = diemMarketing;
        this.diemSales = diemSales;
    }

    @Override
    public double getDiem() {
        return (2 * diemMarketing + diemSales) / 3;
    }
}

public class Main {
    public static void main(String[] args) {
        SinhVienPoly sv1 = new SinhVienIT("Nguyễn Văn A", 9, 8, 7);
        SinhVienPoly sv2 = new SinhVienBiz("Trần Thị B", 7.5, 6);

        sv1.xuat();
        sv2.xuat();
    }
}
