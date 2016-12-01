import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.Collections;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.Font;
public class newg {

	private JFrame frame;
	private JTextArea textArea;
	int cc=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newg window = new newg();
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
	public newg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 767);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(401, 178, 547, 390);
		textArea.setForeground(Color.ORANGE);
		textArea.setBackground(Color.BLACK);
		//textArea.setCaretPosition((textArea.getDocument().getLength()));
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char ch = arg0.getKeyChar();
				if(ch=='\n'){
					String kk="clear";
					String k1="cpu";
					String k2="disk",k3="deadlock",k4="ram",k5="shutdown";
					String text = textArea.getText();
					String[] lines = text.split("\n");
					String lastLine = lines[lines.length-1];
					String[] words=lastLine.split("/");
					String word=words[words.length-1];
					if(word.equals(kk)){
						textArea.setText("");
						textArea.setText("koushik/pc/");
						//textArea.setCaretPosition(textArea.getDocument().getLength());
					}
					else if(word.equals(k1)){
						GUI.main(null);
						
						//textArea.setCaretPosition((textArea.getDocument().getLength()));
					}
					else if(word.equals("close")){
						textArea.setText("koushik/pc/");
						textArea.setVisible(false);
					}
					else if(word.equals(k2)){
						Diskalgos.main(null);
					}
else if(word.equals(k3)){
						dinphilo.main(null);
					}
else if(word.equals(k4)){
	pr.main(null);
}
else if(word.equals(k5)){
	System.exit(0);
}
					else{
						textArea.append("error"+"\n"+"yourname/pc/");
					}
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(textArea);
		textArea.setWrapStyleWord(true);
		//JScrollPane areaScrollPane = new JScrollPane(textArea);
		textArea.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));

		panel.setBounds(0, 121, 144, 607);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		//textField.addActionListener(this);

		ImageIcon ter=new ImageIcon("C:\\Users\\Wayne\\Downloads\\ter.jpg");
		JButton btnNewButton = new JButton(ter);
		btnNewButton.setBounds(10, 11, 124, 98);
		panel.add(btnNewButton);
		
		ImageIcon ram=new ImageIcon("C:\\Users\\Wayne\\Downloads\\ram.png");
		JButton btnRam = new JButton(ram);
		btnRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr.main(null);
			}
		});
		btnRam.setBounds(10, 120, 124, 111);
		panel.add(btnRam);
		
		ImageIcon disk=new ImageIcon("C:\\Users\\Wayne\\Downloads\\disk.png");
		JButton btnNewButton_2 = new JButton(disk);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Diskalgos.main(null);
			}
		});
		btnNewButton_2.setBounds(10, 242, 124, 111);
		panel.add(btnNewButton_2);
		
		ImageIcon lock=new ImageIcon("C:\\Users\\Wayne\\Downloads\\lock.png");
		JButton btnNewButton_3 = new JButton(lock);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dinphilo.main(null);
			}
		});
		btnNewButton_3.setBounds(10, 369, 124, 111);
		panel.add(btnNewButton_3);
		
		ImageIcon cpu=new ImageIcon("C:\\Users\\Wayne\\Downloads\\cpu.png");
		JButton btnNewButton_4 = new JButton(cpu);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.main(null);
			}
		});
		btnNewButton_4.setBounds(10, 491, 124, 105);
		panel.add(btnNewButton_4);
		
		ImageIcon shut=new ImageIcon("C:\\Users\\Wayne\\Downloads\\shut.png");
		
		//test

		
		
		ImageIcon img = new ImageIcon("C:\\Users\\Wayne\\Downloads\\rain.jpg");
		JLabel lblNewLabel = new JLabel(img);
		lblNewLabel.setBounds(-11, -34, 1373, 773);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon start = new ImageIcon("C:\\Users\\Wayne\\Downloads\\start.png");
		JButton btnHi = new JButton(start);
		btnHi.setVisible(true);	
		btnHi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cc==0){
				panel.setVisible(true);
				btnHi.setVisible(true);
				cc=1;
				}
				else{
					panel.setVisible(false);
					cc=0;
				}
				//btnHi.setVisible(false);
			}
		});

		btnHi.setBounds(0, 0, 144, 121);
		frame.getContentPane().add(btnHi);
		JButton btnNewButton_1 = new JButton(shut);
		btnNewButton_1.setBounds(1230, 11, 110, 109);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
				
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setVisible(true);
				textArea.setText("koushik/pc/");
			}
		});
	}
}