package Bai_ToaDo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CT_VeToaDo extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtX, txtY;
    private DrawPanel drawPanel;

    public CT_VeToaDo() {
        setTitle("Vẽ tọa độ điểm");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel nhập tọa độ
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel lblX = new JLabel("Nhập X:");
        txtX = new JTextField(5);
        JLabel lblY = new JLabel("Nhập Y:");
        txtY = new JTextField(5);
        JButton btnDraw = new JButton("Vẽ");

        inputPanel.add(lblX);
        inputPanel.add(txtX);
        inputPanel.add(lblY);
        inputPanel.add(txtY);
        inputPanel.add(btnDraw);

        // Panel vẽ
        drawPanel = new DrawPanel();
        drawPanel.setPreferredSize(new Dimension(400, 400));

        // Sự kiện click nút "Vẽ"
        btnDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(txtX.getText());
                    int y = Integer.parseInt(txtY.getText());
                    drawPanel.setPoint(x, y);
                    drawPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
    }

    // Lớp vẽ sơ đồ tọa độ
    private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}

	class DrawPanel extends JPanel {
        private int x = 0, y = 0;
        private boolean hasPoint = false;

        public void setPoint(int x, int y) {
            this.x = x;
            this.y = y;
            this.hasPoint = true;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;

            // Vẽ trục tọa độ
            g.setColor(Color.BLACK);
            g.drawLine(centerX, 0, centerX, height); // Trục Y
            g.drawLine(0, centerY, width, centerY); // Trục X

            g.drawString("X", width - 10, centerY - 5);
            g.drawString("Y", centerX + 5, 10);
            g.drawString("(0,0)", centerX + 5, centerY + 15);

            // Vẽ điểm nếu có
            if (hasPoint) {
                int drawX = centerX + x * 20;
                int drawY = centerY - y * 20;

                g.setColor(Color.RED);
                g.fillOval(drawX - 5, drawY - 5, 10, 10);
                g.drawString("(" + x + "," + y + ")", drawX + 5, drawY - 5);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CT_VeToaDo().setVisible(true);
        });
    }
}
