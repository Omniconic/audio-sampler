import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.jidesoft.swing.RangeSlider;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class UI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RangeSlider slider1 = new RangeSlider(0, 100, 0, 100);
		slider1.setBounds(6, 6, 200, 40);
		slider1.setPaintTicks(true);
		frame.getContentPane().add(slider1);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.add()
		
	}
	public void paint(Graphics g)
	{
		g.drawString("Hello", 20, 20);
	}

}
