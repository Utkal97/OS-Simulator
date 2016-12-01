
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;



import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class dinphilo extends JApplet{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

int l=0;
	/**
	 * Launch the application.
	 */
ImageIcon icon = new ImageIcon("");
ImageIcon eat= new ImageIcon("C:\\Users\\Wayne\\Downloads\\eat.png");
ImageIcon hungry= new ImageIcon("C:\\Users\\Wayne\\Downloads\\hungry.png");
ImageIcon think= new ImageIcon("C:\\Users\\Wayne\\Downloads\\think.jpg");

public class S1 
{
		int think=0,hung=1,eat=2,wait=3,clic=0,c=0;
		int mutex=0;
		int[] state=new int[5];
		void S1()
		{
			for(int i=0;i<5;i++){
				state[i]=think;
			}
		}
	public void  pickup(int p){
		mutex=1;
		state[p]=hung;
		System.out.println("hung"+p);
		ready(p);
		if(state[p]==hung){

			System.out.println("wait"+p);
		}
		mutex=0;
	}
	public void ready(int p)
	{
		if(state[p]==hung&&state[(p+1)%5]!=eat&&state[(p+4)%5]!=eat){
			state[p]=eat;
			System.out.println("eat"+p);
		}
	}
	public void drop(int p)
	{
			if(state[p]==eat)
			{
			state[p]=think;
			System.out.println("think"+p);
			ready((p+1)%5);
			ready((p+4)%5);
			}
		}
	public void philos1(int p)
	{
		pickup(p);
		//Eat

	}
	public void philos2(int p)
	{
		//Eat
		drop(p);
	}
	}
	String[] ans=new String[5];
	ImageIcon[] I=new ImageIcon[5];
	S1 k=new S1();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dinphilo window = new dinphilo();
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
	public dinphilo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */	

	//	lblIm.setText("OK!");

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 976, 642);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel Label0 = new JLabel("\\");
		Label0.setBounds(316, 65, 243, 212);
		frame.getContentPane().add(Label0);
		Label0.setIcon(think);
		
		JLabel Label1 = new JLabel("");
		Label1.setBounds(654, 112, 243, 209);
		frame.getContentPane().add(Label1);
		Label1.setIcon(think);
		
		JLabel Label2 = new JLabel("");
		Label2.setBounds(587, 364, 243, 212);
		frame.getContentPane().add(Label2);
		Label2.setIcon(think);
		
		JLabel Label3 = new JLabel("");
		Label3.setBounds(131, 364, 243, 212);
		frame.getContentPane().add(Label3);
		Label3.setIcon(think);
		
		JLabel Label4 = new JLabel("");
		Label4.setBounds(10, 96, 243, 212);
		frame.getContentPane().add(Label4);
		Label4.setIcon(think);
		
		//lblIm.setText("HI");
				
		JButton btnNext = new JButton("Randomize");
		btnNext.setBackground(UIManager.getColor("Button.highlight"));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//JLabel.setText("OK!");
			//	lblIm.setText("OK!");
			//	for(int i=0;i<5;i++){
				int i=(int)(Math.random()*5);
				int prev=i;
				
					k.philos1(i);		
					for(int j=0;j<5;j++)
					{
						if(k.state[j]==1)
						{
							ans[j]="hungry";
							I[j]=hungry;
						}
						else if(k.state[j]==2)
						{
							ans[j]="eat";
							I[j]=eat;
						}
						else if(k.state[j]==0)
						{
							ans[j]="think";
							I[j]=think;
						}
					}
					textField.setText(ans[0]);
					Label0.setIcon(I[0]);
					textField_1.setText(ans[1]);
					Label1.setIcon(I[1]);
					textField_2.setText(ans[2]);
					Label2.setIcon(I[2]);					
					textField_3.setText(ans[3]);
					Label3.setIcon(I[3]);
					textField_4.setText(ans[4]);
					Label4.setIcon(I[4]);
					
					//	}


		//		for(int i=0;i<5;i++){
					i=(int)(Math.random()*5);
					if(prev==i)
					{
						i=(int)(Math.random()*5);
					}
					k.philos2(i);
					for(int j=0;j<5;j++)
					{
						if(k.state[j]==1)
						{
							ans[j]="hungry";
							I[j]=hungry;
						}
						else if(k.state[j]==2)
						{
							ans[j]="eat";
							I[j]=eat;
						}
						else if(k.state[j]==0)
						{
							ans[j]="think";
							I[j]=think;
						}
					}
					
						textField.setText(ans[0]);
						Label0.setIcon(I[0]);
						textField_1.setText(ans[1]);
						Label1.setIcon(I[1]);
						textField_2.setText(ans[2]);
						Label2.setIcon(I[2]);
						textField_3.setText(ans[3]);
						Label3.setIcon(I[3]);
						textField_4.setText(ans[4]);
						Label4.setIcon(I[4]);
				}

		//	}
		});
		btnNext.setBounds(421, 379, 89, 23);
		frame.getContentPane().add(btnNext);
		
		textField = new JTextField();
		textField.setBounds(421, 34, 89, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(789, 65, 89, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(722, 332, 89, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(230, 333, 89, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(136, 65, 89, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ans="think";
				Label0.setIcon(think);
				if(k.state[0]==0)
				{
					k.pickup(0);
				}
				else if(k.state[0]==1)
				{
					
				}
				else if(k.state[0]==2){
					k.drop(0);
					if(k.state[4]==2)
					{
						textField_4.setText("eat");
						Label4.setIcon(eat);
					}
					if(k.state[1]==2)
					{
						textField_1.setText("eat");
						Label1.setIcon(eat);
					}
				}
				if(k.state[0]==1)
				{
					ans="hungry";
					I[0]=hungry;
				}
				else if(k.state[0]==2)
				{
					ans="eat";
					I[0]=eat;
				}
				else if(k.state[0]==0)
				{
					ans="think";
					I[0]=think;
				}
				textField.setText(ans);
				Label0.setIcon(I[0]);
			}
		});
		
		btnNewButton.setBounds(316, 33, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans="think";
				Label1.setIcon(think);
				if(k.state[1]==0)
				{
					k.pickup(1);			
				}
				else if(k.state[1]==1)
				{
					
				}
				else if(k.state[1]==2)
				{
					k.drop(1);
					if(k.state[0]==2)
					{
						textField.setText("eat");
						Label0.setIcon(eat);
					}
					if(k.state[2]==2)
					{
						textField_2.setText("eat");
						Label2.setIcon(eat);
					}
				}
				if(k.state[1]==1)
				{
					ans="hungry";
					I[1]=hungry;
				}
				else if(k.state[1]==2)
				{
					ans="eat";
					I[1]=eat;
				}
				else if(k.state[1]==0)
				{
					ans="think";
					I[1]=think;
				}
				textField_1.setText(ans);
				Label1.setIcon(I[1]);
			}
		});
		
		btnNewButton_1.setBounds(690, 64, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans="think";
				I[3]=think;
				Label3.setIcon(think);
				if(k.state[3]==0)
				{
					k.pickup(3);	
				}
				else if(k.state[3]==1)
				{
					
				}
				else if(k.state[3]==2)
				{
					k.drop(3);
					if(k.state[2]==2)
					{
						textField_2.setText("eat");
						Label2.setIcon(eat);
					}
					if(k.state[4]==2)
					{
						textField_4.setText("eat");
						Label4.setIcon(eat);
					}
				}
				if(k.state[3]==1)
				{
					ans="hungry";
					I[3]=hungry;
				}
				else if(k.state[3]==2)
				{
					ans="eat";
					I[3]=eat;
				}
				else if(k.state[3]==0)
				{
					ans="think";
					I[3]=think;
				}
				textField_3.setText(ans);
				Label3.setIcon(I[3]);
			}
		});
		
		btnNewButton_2.setBounds(121, 331, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans="think";
				Label4.setIcon(think);
				
				if(k.state[4]==0)
				{
					k.pickup(4);
				}
				else if(k.state[4]==1)
				{
					
				}
				else if(k.state[4]==2){
					k.drop(4);
					
					if(k.state[0]==2)
					{
						textField.setText("eat");
						Label0.setIcon(eat);
					}
					if(k.state[3]==2)
					{
						textField_3.setText("eat");
						Label3.setIcon(eat);
					}
				}
				if(k.state[4]==1)
				{	ans="hungry";
					I[4]=hungry;
				}
				else if(k.state[4]==2)
				{
					ans="eat";
					I[4]=eat;
				}
				else if(k.state[4]==0)
				{
					ans="think";
					I[4]=think;		
				}
				textField_4.setText(ans);
				Label4.setIcon(I[4]);
			}
		});
		btnNewButton_3.setBounds(37, 64, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans="think";
				if(k.state[2]==0)
				{
					k.pickup(2);
				}
				else if(k.state[2]==1)
				{
					
				}
				else if(k.state[2]==2){
					k.drop(2);
					if(k.state[1]==2)
					{
						textField_1.setText("eat");
						Label1.setIcon(eat);
					}
					if(k.state[3]==2)
					{
						textField_3.setText("eat");
						Label3.setIcon(eat);
					}
				}
				if(k.state[2]==1)
				{
					ans="hungry";
					I[2]=hungry;
				}
				else if(k.state[2]==2)
				{
					ans="eat";
					I[2]=eat;
				}
				else if(k.state[2]==0)
				{
					ans="think";
					I[2]=think;
				}
					textField_2.setText(ans);
					Label2.setIcon(I[2]);
			}
		});
		btnNewButton_4.setBounds(602, 330, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblIm = new JLabel("");
		lblIm.setForeground(Color.WHITE);
		lblIm.setBackground(Color.CYAN);
		lblIm.setBounds(349, 273, 243, 236);
		frame.getContentPane().add(lblIm);
		lblIm.setIcon(icon);


	}
}