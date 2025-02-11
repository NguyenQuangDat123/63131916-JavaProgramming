package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeedCalculator extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDistance, txtTime, txtSpeed;
    private JButton btnCalculate;
    
    public SpeedCalculator() {
        setTitle("Tính Quãng Đường - Thời Gian - Vận Tốc");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Tạo các thành phần giao diện
        JLabel lblDistance = new JLabel("Nhập quãng đường (km):");
        txtDistance = new JTextField();

        JLabel lblTime = new JLabel("Nhập thời gian (giờ):");
        txtTime = new JTextField();

        JLabel lblSpeed = new JLabel("Vận tốc (km/h):");
        txtSpeed = new JTextField();
        txtSpeed.setEditable(false);

        btnCalculate = new JButton("Tính Toán");

        // Thêm sự kiện tính toán
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSpeed();
            }
        });

        // Thêm thành phần vào giao diện
        add(lblDistance);
        add(txtDistance);
        add(lblTime);
        add(txtTime);
        add(lblSpeed);
        add(txtSpeed);
        add(new JLabel());  // Ô trống
        add(btnCalculate);
    }

    private void calculateSpeed() {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double time = Double.parseDouble(txtTime.getText());

            if (time > 0) {
                double speed = distance / time;
                txtSpeed.setText(String.format("%.2f", speed) + " km/h");
            } else {
                txtSpeed.setText("Lỗi: Thời gian phải > 0");
            }
        } catch (NumberFormatException ex) {
            txtSpeed.setText("Lỗi: Nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SpeedCalculator().setVisible(true);
        });
    }
}
