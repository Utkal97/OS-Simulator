import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;

public class Diskalgos {

	private JFrame frmDiskScheduling;
	private JTextPane OutputPane;
	private JButton btnNewButton;
	private JTextField headl;
	public static class n{
		int dt;
		int fl;
		n(){
			dt=0;
			fl=0;
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diskalgos window = new Diskalgos();
					window.frmDiskScheduling.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Diskalgos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiskScheduling = new JFrame();
		frmDiskScheduling.setTitle("Disk Scheduling");
		frmDiskScheduling.getContentPane().setBackground(Color.DARK_GRAY);
		frmDiskScheduling.setBounds(100, 100, 515, 341);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDiskScheduling.getContentPane().setLayout(null);
		
		JSpinner nor = new JSpinner();
		nor.setBounds(164, 28, 55, 20);
		frmDiskScheduling.getContentPane().add(nor);
		
		headl = new JTextField();
		headl.setBounds(64, 86, 86, 20);
		frmDiskScheduling.getContentPane().add(headl);
		headl.setColumns(10);
		
		JTextPane InputPane = new JTextPane();
		InputPane.setBounds(64, 117, 86, 174);
		frmDiskScheduling.getContentPane().add(InputPane);
		
		OutputPane = new JTextPane();
		OutputPane.setBounds(350, 28, 86, 222);
		frmDiskScheduling.getContentPane().add(OutputPane);
		
		String choose[]={"choose one Algorithm","FCFS","Scan","C-Scan","C-LOOK","SSTF"};  
		JComboBox chosen = new JComboBox(choose);
		chosen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int index=chosen.getSelectedIndex();
			int outs[];
			int sum;
			int head1=Integer.valueOf(headl.getText());
			String th="";
		//	int nof=5;
			String bull=String.valueOf(nor.getValue());
			int nof=Integer.valueOf(bull);
			outs=new int[nof+2];
			if(index==1)
			{
				sum=0;
				String input="";
				Queue queue = new LinkedList();

				for(int i=0;i<nof;i++)
				{
					int l=(int)((Math.random()*100)+1);
					System.out.println(l);
					input=input.concat(String.valueOf(l)+'\n');
					queue.add(l);
				}
				InputPane.setText(input);
				String out="";
				int l;
				System.out.println("OUTPUT" + '\n');
				for(int i=0;i<nof;i++){
					l=(int) queue.poll();
					//System.out.println(queue.poll());
					outs[i]=l;
					out=out.concat(String.valueOf(outs[i])+'\n');
				}
				OutputPane.setText(out);
				linechartsdisk.main(null, outs, nof, index,head1);
				//output.setText(String.valueOf(sum));
			}
			else if(index==3)
			{
				sum=0;
				String out="";
				String input="";
				Queue queue = new LinkedList();
				n[] nod=new n[nof+2];
				for(int i=0;i<nof;i++)
				{
					int l=(int)((Math.random()*100)+1);
					nod[i]=new n();
					nod[i].dt=l;
				//	System.out.println(nod[i].dt);
					input=input.concat(String.valueOf(nod[i].dt)+'\n');
				}
				InputPane.setText(input);
				nod[nof]=new n();
				nod[nof+1]=new n();
				nod[nof].dt=0;
				nod[nof+1].dt=100;
				int head=Integer.valueOf(headl.getText());
				head1=head;
				//nod[head].fl=1;
				if(head>50)
				{
					System.out.println(head+"is the HEAD"+'\n');
					for(int i=0;i<(nof+2);i++){
					//System.out.println(nod[head].dt-10+'\n');
					int min=1000;
					int in=0;
					int count=0,fl=0;
					if(i==0){
						
						for(int j=0;j<(nof+2);j++){
							if(nod[j].fl==0&&nod[j].dt>=head){
								if((nod[j].dt-head)<=min&&(nod[j].dt-head)>0){
								min=(nod[j].dt-head);
								sum=sum+min;
								in=j;
								count=1;
							}
								}
						}
						if(count==1){
							nod[in].fl=1;
							head=in;
							//System.out.println(""+in);
							//System.out.println("head"+(nod[head].dt));
							outs[i]=nod[head].dt;
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
						}
						else if(count==0&&fl==0){
							head=nof;
							outs[i]=nod[head].dt;
							fl++;
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
						}	
						else
							break;
					}
					else
					{
						
					for(int j=0;j<(nof+2);j++)
					{
						if(nod[j].fl==0&&nod[j].dt>=nod[head].dt)
						{
							if((nod[j].dt-nod[head].dt)<=min&&(nod[j].dt-nod[head].dt)>0){
							min=(nod[j].dt-nod[head].dt);
							sum=sum+min;
							in=j;
							count=1;
							}
						}
					}
					if(count==1){
						nod[in].fl=1;
						head=in;
						//System.out.println(""+in);
						System.out.println("head"+(nod[head].dt));
						int hh=i+1;
						outs[i]=(nod[head].dt);
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
					}
					else if(count==0&&fl==0){
						head=nof;
						fl=1;
						//System.out.println("inda"+nof);
						System.out.println("head"+(nod[head].dt));
						int hh=i+1;
						outs[i]=(nod[head].dt);
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
					}	
					else
						break;
				}
				}				//OutputPane.setText(String.valueOf(sum));
				}
				
				else
				{
					System.out.println(head+"is the HEAD"+'\n');
					for(int i=0;i<(nof+2);i++){
						int min=1000;
						int in=0;
						int count=0,fl=0;
						if(i==0){
							
							for(int j=0;j<(nof+2);j++){
								if(nod[j].fl==0&&nod[j].dt<head){
									if((head-nod[j].dt)<=min&&(head-nod[j].dt)>0){
									min=(head-nod[j].dt);
									sum=sum+min;
									in=j;
									count=1;
								}
									}
							}
							if(count==1){
								nod[in].fl=1;
								head=in;
								//System.out.println(""+in);
								System.out.println("head"+(nod[head].dt));
								int hh=i+1;
								outs[i]=(nod[head].dt);
								out=out.concat(String.valueOf(nod[head].dt)+'\n');
							}
							else if(count==0&&fl==0){
								head=nof+1;
								fl++;
								//System.out.println("inda"+nof);
								System.out.println("head"+(nod[head].dt));
								int hh=i+1;
								outs[i]=(nod[head].dt);
								out=out.concat(String.valueOf(nod[head].dt)+'\n');
							}	
							else
								break;
						}
						else{
							
						for(int j=0;j<(nof+2);j++){
							if(nod[j].fl==0&&nod[j].dt<nod[head].dt){
								if((nod[head].dt-nod[j].dt)<=min&&(nod[head].dt-nod[j].dt)>0){
								min=(nod[head].dt-nod[j].dt);
								sum=sum+min;
								in=j;
								count=1;
							}
								}
						}
						if(count==1){
							nod[in].fl=1;
							head=in;
							//System.out.println(""+in);
							System.out.println("head"+(nod[head].dt));
							int hh=i+1;
							outs[i]=(nod[head].dt);
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
						}
						else if(count==0&&fl==0){
							head=nof+1;
							fl=1;
							//System.out.println("inda"+nof);
							System.out.println("head"+(nod[head].dt));
							int hh=i+1;
							outs[i]=(nod[head].dt);
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
						}	
						else
							break;
					}
					}				//OutputPane.setText(String.valueOf(sum));
				}
				OutputPane.setText(out);
				linechartsdisk.main(null, outs, nof+2, index,head1);

			}
			
			else if(index==2)
			{
				sum=0;
				String out="";
				String input="";
				Queue queue = new LinkedList();
				
				n[] nod=new n[nof+2];
				for(int i=0;i<nof;i++){
					int l=(int)((Math.random()*100)+1);
					nod[i]=new n();
					nod[i].dt=l;
					System.out.println(nod[i].dt);
					input=input.concat(String.valueOf(nod[i].dt)+'\n');
				}
				InputPane.setText(input);
				nod[nof]=new n();
				nod[nof+1]=new n();
				nod[nof].dt=0;
				nod[nof+1].dt=100;
				int head=Integer.valueOf(headl.getText());
				head1=head;
				System.out.println(head+"is the HEAD"+'\n');
				//nod[head].fl=1;
				for(int i=0;;i++){
					int min=1000;
					int in=0;
					int count=0;
					if(i==0){
						for(int j=0;j<(nof+2);j++){
							if(nod[j].fl==0&&nod[j].dt<=head){
								if((head-nod[j].dt)<min&&(head-nod[j].dt)>0){
								min=(head-nod[j].dt);
								sum=sum+min;
								in=j;
								count=1;
					}
								}
						}
		
						if(count==1){
							nod[in].fl=1;
							head=in;
							System.out.println(""+(nod[head].dt));
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
							outs[i]=nod[head].dt;
						}
						else{
							int max=1000;
							int inn=0;
							int coun=0;
							for(int j=0;j<(nof+2);j++){
								if(nod[j].fl==0&&nod[j].dt>=head&&(nod[j].dt-head)<max){
									max=(nod[j].dt-head);
									inn=j;
									coun=1;
								}
							}
						if(coun==0){
							break;}
						else{
							nod[inn].fl=1;
							head=inn;
							System.out.println("head"+(nod[head].dt));
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
							outs[i]=nod[head].dt;
						}
						}	
					}
					else{
					for(int j=0;j<(nof+2);j++){
						if(nod[j].fl==0&&nod[j].dt<=nod[head].dt){
							if((nod[head].dt-nod[j].dt)<min&&(nod[head].dt-nod[j].dt)>0){
							min=(nod[head].dt-nod[j].dt);
							sum=sum+min;
							in=j;
							count=1;
				}
							}
					}
	
					if(count==1){
						nod[in].fl=1;
						head=in;
						System.out.println("head"+(nod[head].dt));
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
						outs[i]=nod[head].dt;
					}
					else{
						int max=1000;
						int inn=0;
						int coun=0;
						for(int j=0;j<nof+2;j++){
							if(nod[j].fl==0&&nod[j].dt>=nod[head].dt&&(nod[j].dt-nod[head].dt)<max){
								max=(nod[j].dt-nod[head].dt);
								inn=j;
								coun=1;
								//System.out.println("heada"+(nod[head].dt));
							}
						}
						//System.out.println("heada"+(nod[head].dt));
					if(coun==0){
						//System.out.println("head"+i+(nod[head].dt));
						break;
					}
					else{
						nod[inn].fl=1;
						head=inn;
						//System.out.println("indb"+inn);
						System.out.println(""+(nod[head].dt));
						outs[i]=nod[head].dt;
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
					}
					}	
				}
				}
				OutputPane.setText(out);
				linechartsdisk.main(null, outs,2+nof, index,head1);
				//OutputPane.setText(String.valueOf(sum));
			}
		
			else if(index==4)
			{	sum=0;
			String out="";
			String input="";
			Queue queue = new LinkedList();
			int mmin=1000,mmax=0,iin=0,inn=0;
			n[] nod=new n[nof];

			for(int i=0;i<nof;i++){
				int l=(int)((Math.random()*100)+1);
				nod[i]=new n();
				nod[i].dt=l;
				System.out.println(nod[i].dt);
				input=input.concat(String.valueOf(nod[i].dt)+'\n');
				if(mmin>l){
					mmin=l;
					iin=i;
				}
				if(mmax<l){
					mmax=l;
					inn=i;
				}
			}
			InputPane.setText(input);
			int head=Integer.valueOf(headl.getText()),fl=0;
			head1=head;
			if(head>50)
			{
			System.out.println(head+"is the HEAD"+'\n');
			
			for(int i=0;i<nof;i++){
				int min=1000;
				int in=0;
				int count=0;
				
				if(i==0){
					for(int j=0;j<(nof);j++){
						if(nod[j].fl==0&&nod[j].dt>=head){
							if((nod[j].dt-head)<=min&&(nod[j].dt-head)>0){
							min=(nod[j].dt-head);
							sum=sum+min;
							in=j;
							count=1;
						}
							}
					}
					if(count==1){
						nod[in].fl=1;
						head=in;
						System.out.println(""+(nod[head].dt));
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
						outs[i]=nod[head].dt;
					}
					else if(count==0&&fl<2){
						head=iin;
						fl++;
						System.out.println(""+(nod[head].dt));
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
						outs[i]=nod[head].dt;
					}	
					else
						break;
				}
				
				else{
				for(int j=0;j<(nof);j++){
					if(nod[j].fl==0&&nod[j].dt>=nod[head].dt){
						if((nod[j].dt-nod[head].dt)<=min&&(nod[j].dt-nod[head].dt)>0){
						min=(nod[j].dt-nod[head].dt);
						sum=sum+min;
						in=j;
						count=1;
					}
						}
				}
				if(count==1){
					nod[in].fl=1;
					head=in;
					System.out.println(""+(nod[head].dt));
					out=out.concat(String.valueOf(nod[head].dt)+'\n');
					outs[i]=nod[head].dt;
				}
				else if(count==0&&fl<2){
					head=iin;
					fl++;
					System.out.println(""+(nod[head].dt));
					out=out.concat(String.valueOf(nod[head].dt)+'\n');
					outs[i]=nod[head].dt;
				}	
				else
					break;
			}
		}				//output.setText(String.valueOf(sum));
		}
			else
			{
				System.out.println(head+"is the HEAD"+'\n');
				
				for(int i=0;i<nof;i++){
					int min=1000;
					int in=0;
					int count=0;
					
					if(i==0){
						for(int j=0;j<(nof);j++){
							if(nod[j].fl==0&&nod[j].dt<head){
								if((head-nod[j].dt)<=min&&(head-nod[j].dt)>0){
								min=(head-nod[j].dt);
								sum=sum+min;
								in=j;
								count=1;
							}
								}
						}
						if(count==1){
							nod[in].fl=1;
							head=in;
							System.out.println(""+(nod[head].dt));
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
							outs[i]=nod[head].dt;
						}
						else if(count==0&&fl<2){
							head=inn;
							fl++;
							System.out.println(""+(nod[head].dt));
							out=out.concat(String.valueOf(nod[head].dt)+'\n');
							outs[i]=nod[head].dt;
						}	
						else
							break;
					}
					
					else{
					for(int j=0;j<(nof);j++){
						if(nod[j].fl==0&&nod[j].dt<nod[head].dt){
							if((nod[head].dt-nod[j].dt)<=min&&(nod[head].dt-nod[j].dt)>0){
							min=(nod[head].dt-nod[j].dt);
							sum=sum+min;
							in=j;
							count=1;
						}
							}
					}
					if(count==1){
						nod[in].fl=1;
						head=in;
						System.out.println(""+(nod[head].dt));
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
						outs[i]=nod[head].dt;
					}
					else if(count==0&&fl<2){
						head=inn;
						fl++;
						System.out.println(""+(nod[head].dt));
						out=out.concat(String.valueOf(nod[head].dt)+'\n');
						outs[i]=nod[head].dt;
					}	
					else
						break;
				}
			}				//output.setText(String.valueOf(sum));
			}
	
			linechartsdisk.main(null, outs, nof, index,head1);
			OutputPane.setText(out);
			}
			
			else if(index==5)
			{
				sum=0;
				String input="";
				String out="";
				int mmin=1000,iin=0;
				n[] nod=new n[nof];
				for(int i=0;i<nof;i++){
					int l=(int)((Math.random()*100)+1);
					nod[i]=new n();
					nod[i].dt=l;
					System.out.println(nod[i].dt);
					input=input.concat(String.valueOf(nod[i].dt)+'\n');
				}
				InputPane.setText(input);
				int head=Integer.valueOf(headl.getText()),fl=0;
				head1=head;
				for(int i=0;i<nof;i++){
					int min=1000;
					int in=0;
					int count=0;
					if(i==0){
						for(int j=0;j<(nof);j++){
							if(nod[j].fl==0){
								if((nod[j].dt-head)>=0){
									if(nod[j].dt-head<=min){
								min=(nod[j].dt-head);
								sum=sum+min;
								in=j;
								count=1;}
							}
								else{
									if(head-nod[j].dt<=min){
										min=(head-nod[j].dt);
										sum=sum+min;
										in=j;
										count=1;}
								}
								}
						}
						if(count==1){
							nod[in].fl=1;
							head=in;
							System.out.println(""+nod[in].dt);
							outs[i]=nod[in].dt;
							out=out.concat(String.valueOf(nod[in].dt)+'\n');
						}
						else if(count==0&&fl==0){
							head=iin;
							fl=1;
							System.out.println(""+nod[iin].dt);
							out=out.concat(String.valueOf(nod[iin].dt)+'\n');
							outs[i]=nod[iin].dt;
						}	
						else
							break;
					}
					else{
					for(int j=0;j<(nof);j++){
						if(nod[j].fl==0){
							if((nod[j].dt-nod[head].dt)>=0){
								if(nod[j].dt-nod[head].dt<=min){
							min=(nod[j].dt-nod[head].dt);
							sum=sum+min;
							in=j;
							count=1;}
						}
							else{
								if(nod[head].dt-nod[j].dt<=min){
									min=(nod[head].dt-nod[j].dt);
									sum=sum+min;
									in=j;
									count=1;}
							}
							}
					}
					if(count==1){
						nod[in].fl=1;
						head=in;
						System.out.println(""+nod[in].dt);
						out=out.concat(String.valueOf(nod[in].dt)+'\n');
						outs[i]=nod[in].dt;
					}
					else if(count==0&&fl==0){
						head=iin;
						fl=1;
						System.out.println(""+nod[iin].dt);
						out=out.concat(String.valueOf(nod[iin].dt)+'\n');
						outs[i]=nod[iin].dt;
					}	
					else
						break;
				}
					}				
				linechartsdisk.main(null, outs,nof,index,head1);
				OutputPane.setText(out);				
			//	OutputPane.setText(String.valueOf(sum));
			}
			}
		});
		chosen.setBounds(160, 111, 128, 20);
		frmDiskScheduling.getContentPane().add(chosen);
		
		btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDiskScheduling.dispose();
			}
		});
		btnNewButton.setBounds(303, 261, 133, 30);
		frmDiskScheduling.getContentPane().add(btnNewButton);
		
		JLabel lblNumberOfProcesses = new JLabel("    Number of processes");
		lblNumberOfProcesses.setForeground(Color.ORANGE);
		lblNumberOfProcesses.setBounds(17, 28, 133, 14);
		frmDiskScheduling.getContentPane().add(lblNumberOfProcesses);
		
		JLabel lblHeader = new JLabel("Header");
		lblHeader.setForeground(Color.ORANGE);
		lblHeader.setBounds(24, 89, 46, 14);
		frmDiskScheduling.getContentPane().add(lblHeader);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(Color.ORANGE);
		lblInput.setBounds(8, 153, 46, 14);
		frmDiskScheduling.getContentPane().add(lblInput);
		

		

	}
}
