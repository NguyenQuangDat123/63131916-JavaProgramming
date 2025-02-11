package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbCategory, cbUnit;
    private JTextField txtInput, txtResult;
    private JButton btnConvert;

    public UnitConverter() {
        setTitle("Chuyển Đổi Đơn Vị");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Dropdown chọn loại đơn vị
        JLabel lblCategory = new JLabel("Chọn loại đơn vị:");
        String[] categories = {"Khối lượng", "Độ dài"};
        cbCategory = new JComboBox<>(categories);

        JLabel lblUnit = new JLabel("Chọn đơn vị:");
        cbUnit = new JComboBox<>();

        JLabel lblInput = new JLabel("Nhập giá trị:");
        txtInput = new JTextField();

        JLabel lblResult = new JLabel("Kết quả:");
        txtResult = new JTextField();
        txtResult.setEditable(false);

        btnConvert = new JButton("Chuyển Đổi");

        // Thêm sự kiện cho dropdown chọn loại đơn vị
        cbCategory.addActionListener(e -> updateUnitOptions());

        // Thêm sự kiện cho nút chuyển đổi
        btnConvert.addActionListener(e -> convertUnit());

        // Thêm thành phần vào giao diện
        add(lblCategory);
        add(cbCategory);
        add(lblUnit);
        add(cbUnit);
        add(lblInput);
        add(txtInput);
        add(lblResult);
        add(txtResult);
        add(new JLabel()); // Ô trống
        add(btnConvert);

        updateUnitOptions(); // Cập nhật danh sách đơn vị ban đầu
    }

    private void updateUnitOptions() {
        cbUnit.removeAllItems();
        if (cbCategory.getSelectedItem().equals("Khối lượng")) {
            cbUnit.addItem("Gram → Dag");
            cbUnit.addItem("Dag → Hg");
            cbUnit.addItem("Hg → Kg");
            cbUnit.addItem("Kg → Yến");
            cbUnit.addItem("Yến → Tạ");
            cbUnit.addItem("Tạ → Tấn");
        } else {
            cbUnit.addItem("mm → cm");
            cbUnit.addItem("cm → dm");
            cbUnit.addItem("dm → m");
            cbUnit.addItem("m → Dam");
            cbUnit.addItem("Dam → Hm");
            cbUnit.addItem("Hm → Km");
        }
    }

    private void convertUnit() {
        try {
            double input = Double.parseDouble(txtInput.getText());
            String selectedUnit = (String) cbUnit.getSelectedItem();
            double result = 0;

            switch (selectedUnit) {
                // Chuyển đổi khối lượng
                case "Gram → Dag": result = input / 10; break;
                case "Dag → Hg": result = input / 10; break;
                case "Hg → Kg": result = input / 10; break;
                case "Kg → Yến": result = input / 10; break;
                case "Yến → Tạ": result = input / 10; break;
                case "Tạ → Tấn": result = input / 10; break;
                
                // Chuyển đổi độ dài
                case "mm → cm": result = input / 10; break;
                case "cm → dm": result = input / 10; break;
                case "dm → m": result = input / 10; break;
                case "m → Dam": result = input / 10; break;
                case "Dam → Hm": result = input / 10; break;
                case "Hm → Km": result = input / 10; break;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtResult.setText("Lỗi: Nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnitConverter().setVisible(true));
    }
}
