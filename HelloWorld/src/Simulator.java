import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simulator {

	private JFrame frmGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulator window = new Simulator();
					window.frmGroup.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Simulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		ImageIcon cpu=	new ImageIcon("C:\\Users\\Wayne\\Pictures\\OS\\CPU.png") ;
		ImageIcon ram= new ImageIcon("C:\\Users\\Wayne\\Pictures\\OS\\RAM.png");
		ImageIcon disk= new ImageIcon("C:\\Users\\Wayne\\Pictures\\OS\\DISK.png");
		frmGroup = new JFrame();
		
		frmGroup.setTitle("Group- 4");
		frmGroup.getContentPane().setBackground(Color.DARK_GRAY);
		frmGroup.setBounds(100, 100, 460, 340);
		//frmGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroup.getContentPane().setLayout(null);
		
		JButton gotoram = new JButton("");
		gotoram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pr.main(null);
			}
		});
		gotoram.setBounds(214, 11, 140, 121);
		gotoram.setIcon(ram);
		frmGroup.getContentPane().add(gotoram);
		
		JButton gotodisk = new JButton("");
		gotodisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Diskalgos.main(null);
				
			}
		});
		gotodisk.setBounds(120, 154, 140, 137);
		gotodisk.setIcon(disk);
		frmGroup.getContentPane().add(gotodisk);
		
		JButton gotocpu = new JButton("");
		gotocpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.main(null);
			}
		});
		gotocpu.setBounds(23, 11, 140, 121);
		gotocpu.setIcon(cpu);
		frmGroup.getContentPane().add(gotocpu);
		
		JToggleButton theme = new JToggleButton("Theme");

		theme.addActionListener(new ActionListener() {
			int i=1;
			public void actionPerformed(ActionEvent arg0){
				i++;
				if (i%2==0)
					frmGroup.getContentPane().setBackground(Color.WHITE);	
				else
					frmGroup.getContentPane().setBackground(Color.DARK_GRAY);	
			}
		});
		
		theme.setBounds(310, 227, 121, 23);
		frmGroup.getContentPane().add(theme);
	}
}
