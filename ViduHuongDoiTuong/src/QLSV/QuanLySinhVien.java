package QLSV;

import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVien {
    private List<SinhVien> sinhViens;

    public QuanLySinhVien() {
        sinhViens = new ArrayList<>();
    }

    // Add a student to the list
    public void themSinhVien(SinhVien sinhVien) {
        sinhViens.add(sinhVien);
    }

    // Display all students
    public void hienThiSinhVien() {
        if (sinhViens.isEmpty()) {
            System.out.println("Chưa có sinh viên.");
        } else {
            for (SinhVien sinhVien : sinhViens) {
                System.out.println(sinhVien);
            }
        }
    }

    // Find student by ID
    public SinhVien timSinhVienTheoId(int id) {
        for (SinhVien sinhVien : sinhViens) {
            if (sinhVien.getId() == id) {
                return sinhVien;
            }
        }
        return null; // return null if not found
    }
}
