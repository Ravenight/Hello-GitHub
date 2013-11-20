import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.swing.border.*;

public class ColorShape {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MyFrame extends JFrame {

	private LeftPanel leftPanel;
	private RightPanel rightPanel;

	public MyFrame() {
		setTitle("ColorShape");
		setLayout(new GridLayout(1, 2));

		leftPanel = new LeftPanel();
		rightPanel = new RightPanel();
		leftPanel.setRightPanel(rightPanel);

		add(leftPanel);
		add(rightPanel);
		pack();

	}

	class LeftPanel extends JPanel {
		int colorSelector = -1;
		TitledBorder title;
		RightPanel rp;

		public LeftPanel() {

			setPreferredSize(new Dimension(200, 400));
			setLayout(new GridLayout(2, 1, 10, 10));

			title = BorderFactory.createTitledBorder("Color Selection");
			setBorder(title);

			JButton btn_blue = new JButton("Blue");
			JButton btn_yellow = new JButton("Yellow");
			add(btn_blue);
			add(btn_yellow);

			btn_blue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorSelector = 0;
					rp.changeColor(colorSelector);
				}
			});
			this.add(btn_blue);

			btn_yellow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorSelector = 1;
					rp.changeColor(colorSelector);
				}
			});
			this.add(btn_yellow);
		}
		
		public void setRightPanel(RightPanel rp) {
			this.rp = rp;
		}

	}

	class RightPanel extends JPanel {
		TitledBorder title;
		Color rectColor = Color.BLUE;

		public void changeColor(int colorSelector) {
			if (colorSelector == 0) {
				rectColor = Color.BLUE;
			}
			if (colorSelector == 1) {
				rectColor = Color.YELLOW;
			}

			repaint();
		}

		public RightPanel() {
			setPreferredSize(new Dimension(400, 200));

			title = BorderFactory.createTitledBorder("Shape");
			setBorder(title);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(rectColor);
			Rectangle2D rect = new Rectangle2D.Double(100, 150, 200, 150);
			g2.fill(rect);
		}

	}
}

