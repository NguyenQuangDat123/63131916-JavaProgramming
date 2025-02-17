package Bai1_PTtinh;
public final class XPoly {
    
    // Phương thức tĩnh sum() sử dụng varargs để tính tổng các tham số truyền vào
    public static double sum(double... numbers) {
        double total = 0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }
    
    // Kiểm tra phương thức sum()
    public static void main(String[] args) {
        System.out.println("Tổng: " + XPoly.sum(1.2, 2.3, 3.4)); // Kết quả: 6.9
        System.out.println("Tổng: " + XPoly.sum()); // Kết quả: 0.0 (trường hợp không có tham số)
    }
}