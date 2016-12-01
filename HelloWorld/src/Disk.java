import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Disk {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disk window = new Disk();
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
	public Disk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 480, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDiningPhilosphers = new JButton("Dining philosphers");
		btnDiningPhilosphers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dinphilo.main(null);
			}
		});
		btnDiningPhilosphers.setBounds(42, 75, 179, 77);
		frame.getContentPane().add(btnDiningPhilosphers);
		
		JButton btnNewButton = new JButton("Disk management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Diskalgos.main(null);
			}
		});
		btnNewButton.setBounds(248, 75, 138, 89);
		frame.getContentPane().add(btnNewButton);
	}
}
