package Bai4_CT;

public final class XPoly {
    
    // Phương thức tĩnh sum() sử dụng varargs để tính tổng các tham số truyền vào
    public static double sum(double... numbers) {
        double total = 0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }
    
    // Phương thức chuyển đổi ký tự đầu tiên của mỗi từ sang ký tự hoa
    public static String toUpperFirstChar(String s) {
        if (s == null || s.isEmpty()) return s;
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }
}

public final class XPolyMinMax {
    
    // Phương thức tìm số nhỏ nhất
    public static double min(double... x) {
        if (x.length == 0) throw new IllegalArgumentException("Không có giá trị đầu vào");
        double min = x[0];
        for (double num : x) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    
    // Phương thức tìm số lớn nhất
    public static double max(double... x) {
        if (x.length == 0) throw new IllegalArgumentException("Không có giá trị đầu vào");
        double max = x[0];
        for (double num : x) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

// Chương trình sử dụng các phương thức tiện ích từ XPoly
public class Main {
    public static void main(String[] args) {
        // Sử dụng phương thức sum()
        System.out.println("Tổng: " + XPoly.sum(1.2, 2.3, 3.4)); // Kết quả: 6.9
        System.out.println("Tổng: " + XPoly.sum()); // Kết quả: 0.0 (trường hợp không có tham số)

        // Sử dụng phương thức toUpperFirstChar()
        System.out.println("Chuyển đổi: " + XPoly.toUpperFirstChar("nguyen van teo")); // Kết quả: Nguyen Van Teo

        // Sử dụng phương thức min() và max()
        System.out.println("Nhỏ nhất: " + XPolyMinMax.min(1.2, 2.3, 3.4, -1.5)); // Kết quả: -1.5
        System.out.println("Lớn nhất: " + XPolyMinMax.max(1.2, 2.3, 3.4, -1.5)); // Kết quả: 3.4
    }
}

