import java.util.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class pr {

	private JFrame frmPageReplacements;
	private JTextField FIFOmiss;
	private JTextField Secondmiss;
	private JTextField LRUmiss;
	private JTextField Optimalmiss;

	public static class k
	{
		public int val;
		public boolean oc;
		public int index;
		public boolean ref;
		k()
		{
			val=0;
			oc=false;
			index=0;
			ref=false;
		}
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					pr window = new pr();
					window.frmPageReplacements.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmPageReplacements = new JFrame();
		frmPageReplacements.setTitle("Page Replacements");
		frmPageReplacements.getContentPane().setBackground(Color.DARK_GRAY);
		frmPageReplacements.setBounds(100, 100, 878, 688);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPageReplacements.getContentPane().setLayout(null);
		
		JSpinner nofra = new JSpinner();
		nofra.setBounds(31, 72, 46, 20);
		frmPageReplacements.getContentPane().add(nofra);
		
		JSpinner nopro = new JSpinner();
		nopro.setBounds(31, 138, 46, 20);
		frmPageReplacements.getContentPane().add(nopro);
		
		JTextPane PaneInput = new JTextPane();
		PaneInput.setBounds(182, 26, 84, 213);
		frmPageReplacements.getContentPane().add(PaneInput);
		
		JTextPane PaneOutput = new JTextPane();
		PaneOutput.setBounds(727, 66, 125, 487);
		frmPageReplacements.getContentPane().add(PaneOutput);
		
		JTextPane frame1 = new JTextPane();
		frame1.setBounds(31, 295, 35, 191);
		frmPageReplacements.getContentPane().add(frame1);
		
		JTextPane frame2 = new JTextPane();
		frame2.setBounds(76, 295, 35, 191);
		frmPageReplacements.getContentPane().add(frame2);
		
		JTextPane frame3 = new JTextPane();
		frame3.setBounds(121, 295, 35, 191);
		frmPageReplacements.getContentPane().add(frame3);
		
		JTextPane LRUframe1 = new JTextPane();
		LRUframe1.setBounds(231, 295, 35, 191);
		frmPageReplacements.getContentPane().add(LRUframe1);
		
		JTextPane LRUframe2 = new JTextPane();
		LRUframe2.setBounds(276, 295, 35, 191);
		frmPageReplacements.getContentPane().add(LRUframe2);
		
		JTextPane LRUframe3 = new JTextPane();
		LRUframe3.setBounds(321, 295, 35, 191);
		frmPageReplacements.getContentPane().add(LRUframe3);
		
		JTextPane Secframe1 = new JTextPane();
		Secframe1.setBounds(395, 295, 35, 191);
		frmPageReplacements.getContentPane().add(Secframe1);
		
		JTextPane Secframe2 = new JTextPane();
		Secframe2.setBounds(440, 295, 35, 191);
		frmPageReplacements.getContentPane().add(Secframe2);
		
		JTextPane Secframe3 = new JTextPane();
		Secframe3.setBounds(485, 295, 35, 191);
		frmPageReplacements.getContentPane().add(Secframe3);
		
		JTextPane Optframe1 = new JTextPane();
		Optframe1.setBounds(568, 295, 35, 191);
		frmPageReplacements.getContentPane().add(Optframe1);
		
		JTextPane Optframe2 = new JTextPane();
		Optframe2.setBounds(613, 295, 35, 191);
		frmPageReplacements.getContentPane().add(Optframe2);
		
		JTextPane Optframe3 = new JTextPane();
		Optframe3.setBounds(658, 295, 35, 191);
		frmPageReplacements.getContentPane().add(Optframe3);
		
		FIFOmiss = new JTextField();
		FIFOmiss.setBounds(55, 497, 86, 20);
		frmPageReplacements.getContentPane().add(FIFOmiss);
		FIFOmiss.setColumns(10);
		
		Secondmiss = new JTextField();
		Secondmiss.setBounds(412, 501, 86, 20);
		frmPageReplacements.getContentPane().add(Secondmiss);
		Secondmiss.setColumns(10);
		
		LRUmiss = new JTextField();
		LRUmiss.setBounds(251, 501, 86, 20);
		frmPageReplacements.getContentPane().add(LRUmiss);
		LRUmiss.setColumns(10);
		
		Optimalmiss = new JTextField();
		Optimalmiss.setBounds(578, 501, 86, 20);
		frmPageReplacements.getContentPane().add(Optimalmiss);
		Optimalmiss.setColumns(10);
		
		JLabel lblNoOfFrames = new JLabel("No. Of  FRAMES");
		lblNoOfFrames.setForeground(Color.ORANGE);
		lblNoOfFrames.setBounds(10, 40, 91, 16);
		frmPageReplacements.getContentPane().add(lblNoOfFrames);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblOutput.setForeground(Color.ORANGE);
		lblOutput.setBounds(730, 37, 59, 18);
		frmPageReplacements.getContentPane().add(lblOutput);
		
		JLabel lblNoOfProcesses = new JLabel("No. Of Processes");
		lblNoOfProcesses.setForeground(Color.ORANGE);
		lblNoOfProcesses.setBounds(10, 109, 91, 18);
		frmPageReplacements.getContentPane().add(lblNoOfProcesses);
		
		JLabel lblFifoOutput = new JLabel("FIFO Output");
		lblFifoOutput.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblFifoOutput.setForeground(Color.CYAN);
		lblFifoOutput.setBounds(55, 261, 101, 23);
		frmPageReplacements.getContentPane().add(lblFifoOutput);
		
		JLabel lblLruOutput = new JLabel("LRU Output");
		lblLruOutput.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblLruOutput.setForeground(Color.CYAN);
		lblLruOutput.setBounds(251, 265, 101, 14);
		frmPageReplacements.getContentPane().add(lblLruOutput);
		
		JLabel lblOptimal = new JLabel("Optimal Output");
		lblOptimal.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		lblOptimal.setForeground(Color.CYAN);
		lblOptimal.setBounds(576, 264, 127, 16);
		frmPageReplacements.getContentPane().add(lblOptimal);
		
		JLabel lblSecondChanceOutput = new JLabel("Second Chance Output");
		lblSecondChanceOutput.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblSecondChanceOutput.setForeground(Color.CYAN);
		lblSecondChanceOutput.setBounds(408, 257, 127, 30);
		frmPageReplacements.getContentPane().add(lblSecondChanceOutput);

		 String choose[]={"choose one Algorithm","FIFO","LRU","Optimal","second chance","Run ALL"};  
		JComboBox Algo = new JComboBox(choose);
		Algo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=Algo.getSelectedIndex();
				if(index==5)
				{
					int[] outs;
					//fifo========================================
					 String valu;
					  valu=String.valueOf(nofra.getValue());
					  int nof,nop,pg=0;
					  nof = Integer.parseInt(valu);
					  
					  
					  k[] pro=new k[nof];
					  Queue queue = new LinkedList();
					  String ans="";
					  String inp="";
					  String f1="";
					  String f2="";
					  String f3="";
					  String valu2;
					  valu2=String.valueOf(nopro.getValue());
					  nop = Integer.parseInt(valu2);
					  int[] arr=new int[nop];
					  for(int i=0;i<nop;i++)
					  {
						  arr[i]=(int)((Math.random()*10)+1);
						  inp=inp.concat(String.valueOf(arr[i])+'\n');
					  }
					  
					  PaneInput.setText(inp);

					 for(int l=0;l<nof;l++)
					 {
						 pro[l]=new k();
						 pro[l].index=l;
					 }
					  for(int i=0;i<nop;i++)
					  {
						  int flag=0;
						  for(int j=0;j<pro.length;j++){
							  if(pro[j].oc==false){
								  pro[j].val=arr[i];
								  pro[j].oc=true;
								  queue.add(j);
								  flag=1;
							//	  System.out.println("val"+pro[j].val+i);
								  break;
							  }
							  if(pro[j].oc==true&&pro[j].val==arr[i]){
								  flag=1;
								  pg++;
								  break;
								 
							  }
						  }
						  if(flag==0){
							  int k1=(int)queue.poll();
							  pro[k1].val=arr[i];
							  pro[k1].oc=true;
							  queue.add(k1);
						//	  System.out.println("val"+pro[k1].val+i);
						  }
						  int kk;
						  for(int y=0;y<pro.length;y++)
						  {
							  kk=pro[y].index+1;
							 ans=ans.concat("page "+pro[y].val+" in frame "+kk+'\n');
						  }
					if(nof==3)	  
					{	
						for(int y=0;y<pro.length;y=y+3)
						  {
							  f1=f1.concat(""+pro[y].val+'\n');
							  f2=f2.concat(""+pro[y+1].val+'\n');
							  f3=f3.concat(""+pro[y+2].val+'\n');
						  }
					  }
					 } 
					 PaneOutput.setText(ans);
					 frame1.setText(f1);
					 frame2.setText(f2);
					 frame3.setText(f3);
					 int answer=nop-pg;
					 outs=new int[4];
					 outs[0]=answer;
					 FIFOmiss.setText(String.valueOf(answer));
					//fifo=======================================
					//sc=========================================
					int c=0;
					  String valusc;
					  valusc=String.valueOf(nofra.getValue());
					  int nofsc,nopssc,pgsc=0;
					  nofsc = Integer.parseInt(valusc);
					  k[] prosc=new k[nofsc];
					  Queue queuesc = new LinkedList();
					  String anssc="";
					  String inpsc="";
					  String f1sc="";
					  String f2sc="";
					  String f3sc="";
					  String valu2sc;
					  valu2sc=String.valueOf(nopro.getValue());
					  nopssc = Integer.parseInt(valu2sc);

					 for(int l=0;l<nofsc;l++){
						 prosc[l]=new k();
						 prosc[l].index=l;
					 }
					  for(int i=0;i<nopssc;i++){
						  int flag=0;
						  for(int j=0;j<prosc.length;j++){
							  if(prosc[j].oc==false){
								  prosc[j].val=arr[i];
								  prosc[j].oc=true;
								  queuesc.add(j);
								  flag=1;
							//	  System.out.println("val"+prosc[j].val+i);
								  break;
							  }
							  if(prosc[j].oc==true&&prosc[j].val==arr[i]){
								  flag=1;
								  prosc[j].ref=true;
								  c++;
								  pgsc++;
								  break;
							  }
						  }
						  if(flag==0){
							  System.out.println("hi");
							  Queue s = new LinkedList();  //create a stack
							  	int count=0;
							  	if(c==3){
							  		for(int f=0;f<nofsc;f++){
							  			prosc[f].ref=false;
							  		}
							  	}
							    //while the queuesc is not empty
							    while(!queuesc.isEmpty())
							    {  //add the elements of the queuesc onto a stack
							    	int k1=(int)queuesc.element();

							    	if(count==0){
							    	if(prosc[k1].ref==true){
							       s.add(queuesc.poll());
							       prosc[k1].ref=false;
							       c--;
							       }
							    	else{
							    		int kk=(int)queuesc.poll();

							    		  prosc[kk].val=arr[i];
										  prosc[kk].oc=true;
										  queuesc.add(kk);
										  count=1;
							    	}
							    	}
							    	else{
							    		s.add(queuesc.poll());
							    	} 
							    } 

							    while(!s.isEmpty())
							    { 
							      queuesc.add(s.poll());
							    }
						  }
						  int kk;
						  for(int y=0;y<prosc.length;y++){
							  kk=prosc[y].index+1;
							  anssc=anssc.concat("page "+prosc[y].val+" in frame "+kk+'\n');
						  }
						  if(nofsc==3)
						  {
							for(int y=0;y<prosc.length;y=y+3)
						  	{
							  	f1sc=f1sc.concat(""+prosc[y].val+'\n');
							  	f2sc=f2sc.concat(""+prosc[y+1].val+'\n');
							  	f3sc=f3sc.concat(""+prosc[y+2].val+'\n');
						  	}
						  }
					  }
					  	 PaneOutput.setText(anssc);
						 Secframe1.setText(f1sc);
						 Secframe2.setText(f2sc);
						 Secframe3.setText(f3sc);	

						 int answerfifo=nopssc-pgsc;
						 outs[1]=answerfifo;
						 Secondmiss.setText(String.valueOf(answerfifo));
					//second chance======================================
					//lru==================================================
					  String valulru;
					  valulru=String.valueOf(nofra.getValue());
					  int noflru,noplru,pglru=0;
					  noflru = Integer.parseInt(valulru);
					  k[] prolru=new k[noflru];
					  Stack s = new Stack();
					  String anslru="";
					  String lruinp="";
					  String f1lru="";
					  String f2lru="";
					  String f3lru="";
					  String valu2lru;
					  valu2lru=String.valueOf(nopro.getValue());
					  noplru = Integer.parseInt(valu2lru);
					  
		
					 for(int l=0;l<noflru;l++){
						 prolru[l]=new k();
						 prolru[l].index=l;
					 }
					  for(int i=0;i<noplru;i++){
						  int flag=0;
						  for(int j=0;j<prolru.length;j++){
							  if(prolru[j].oc==false){
								  prolru[j].val=arr[i];
								  prolru[j].oc=true;
								  s.push(j);
								  flag=1;
								  break;
							  }
							  if(prolru[j].oc==true&&prolru[j].val==arr[i]){
								  flag=1;
								  pglru++;
								  break;
							  }
						  }
						  if(flag==0){
							  Stack tem=new Stack();
							  int k1=(int)s.pop();
							  prolru[k1].val=arr[i];
							  prolru[k1].oc=true;
							  for(int ki=0;ki<(noflru-1);ki++){
								  tem.push(s.pop());
							  }
							  s.push(k1);
							  for(int ki=0;ki<(noflru-1);ki++){
								  s.push(tem.pop());
							  }	  
						  }
						 int kk;
						  for(int y=0;y<prolru.length;y++){
							  kk=prolru[y].index+1;
							  anslru=anslru.concat("page "+prolru[y].val+" in frame "+kk+'\n');
						  }
						  if(noflru==3)
						  {
							for(int y=0;y<prolru.length;y=y+3)
						  	{
							  	f1lru=f1lru.concat(""+prolru[y].val+'\n');
							  	f2lru=f2lru.concat(""+prolru[y+1].val+'\n');
							  	f3lru=f3lru.concat(""+prolru[y+2].val+'\n');
						  	}
						  }
					  }
					  
					  	 PaneOutput.setText(anslru);
						 LRUframe1.setText(f1lru);
						 LRUframe2.setText(f2lru);
						 LRUframe3.setText(f3lru);
		
						 int answerlru=noplru-pglru;
						 outs[2]=answerlru;
						 LRUmiss.setText(String.valueOf(answerlru));

					//lru=======================================

					//optimal============================================
					String valuopt;
					  valuopt=String.valueOf(nofra.getValue());
					  int nofopt,nopopt,pgopt=0;
					  nofopt = Integer.parseInt(valuopt);
					  k[] proopt=new k[nofopt];
					  Queue queueopt=new LinkedList();
					  String ansopt="";
					  String inpopt="";
					  String f1opt="";
					  String f2opt="";
					  String f3opt="";
					  String valu2opt;
					  valu2opt=String.valueOf(nopro.getValue());
					  nopopt = Integer.parseInt(valu2opt);
		

				 for(int l=0;l<nofopt;l++){
					 proopt[l]=new k();
					 proopt[l].index=l;
				 }
				 for(int i=0;i<nopopt;i++){
					  int flag=0;
					  for(int j=0;j<proopt.length;j++){
						  if(proopt[j].oc==false){
							  proopt[j].val=arr[i];
							  proopt[j].oc=true;
							  queueopt.add(j);
							  flag=1;
							  break;
						  }
						  if(proopt[j].oc==true&&proopt[j].val==arr[i]){
							  flag=1;
							  pgopt++;
							  break;
						  }
					  }
					  if(flag==0){
						 int max=0,in=0,main=0;
						 for(int p=0;p<nofopt;p++){
							 int ind=100;
							 in=p;
							 for(int h=i+1;h<nopopt;h++){
								 if(arr[h]==proopt[p].val){
									 ind=h;
									 in=p;
									 break;
								 }
							 }
							 if(ind==100){
								 main=in;
								 max=ind;
								 break;
							 }
							 else if(ind>max)
								 max=ind;
							 main=in;
							 
						 }
						 if(max==0){
							 int k1=(int)queueopt.poll();
							  proopt[k1].val=arr[i];
							  proopt[k1].oc=true;
							  queueopt.add(k1);
						 }
						 else{
							 proopt[main].val=arr[i];
						 }
					  }
					  int kk;
					  for(int y=0;y<proopt.length;y++)
					  {
						  kk=proopt[y].index+1;
						  ansopt=ansopt.concat("page "+proopt[y].val+" in frame "+kk+'\n');
					  }
					  if(nofopt==3)
					  {
						for(int y=0;y<proopt.length;y=y+3)
					  	{
						  	f1opt=f1opt.concat(""+proopt[y].val+'\n');
						  	f2opt=f2opt.concat(""+proopt[y+1].val+'\n');
						  	f3opt=f3opt.concat(""+proopt[y+2].val+'\n');
					  	}
					  }
					  
					  
				  }
			  	 PaneOutput.setText(ansopt);
				 Optframe1.setText(f1opt);
				 Optframe2.setText(f2opt);
				 Optframe3.setText(f3opt);	


				 int answeropt=nopopt-pgopt;
				 outs[3]=answeropt;
				 Optimalmiss.setText(String.valueOf(answeropt));	
					
				Barchartpr.main(null, outs);
				}
				
				else if(index==1)
				{
					String valu;
					  valu=String.valueOf(nofra.getValue());
					  int nof,nop,pg=0;
					  nof = Integer.parseInt(valu);
					  k[] pro=new k[nof];
					  Queue queue = new LinkedList();
					  String ans="";
					  String inp="";
					  String f1="";
					  String f2="";
					  String f3="";
					  String valu2;
					  valu2=String.valueOf(nopro.getValue());
					  nop = Integer.parseInt(valu2);
					  
					  int[] arr=new int[nop];
					  for(int i=0;i<nop;i++)
					  {
						  arr[i]=(int)((Math.random()*10)+1);
						  inp=inp.concat(String.valueOf(arr[i])+'\n');
					  }
					  
					  PaneInput.setText(inp);
					 for(int l=0;l<nof;l++)
					 {
						 pro[l]=new k();
						 pro[l].index=l;
					 }
					  for(int i=0;i<nop;i++)
					  {
						  int flag=0;
						  for(int j=0;j<pro.length;j++){
							  if(pro[j].oc==false){
								  pro[j].val=arr[i];
								  pro[j].oc=true;
								  queue.add(j);
								  flag=1;
					
								  break;
							  }
							  if(pro[j].oc==true&&pro[j].val==arr[i]){
								  flag=1;
								  pg++;
								  break;
								 
							  }
						  }
						  if(flag==0){
							  int k1=(int)queue.poll();
							  pro[k1].val=arr[i];
							  pro[k1].oc=true;
							  queue.add(k1);
						//	  System.out.println("val"+pro[k1].val+i);
						  }
						  int kk;
						  for(int y=0;y<pro.length;y++)
						  {
							  kk=pro[y].index+1;
							 ans=ans.concat("page "+pro[y].val+" in frame "+kk+'\n');
						  }
					if(nof==3)	  
					{	
						for(int y=0;y<pro.length;y=y+3)
						  {
							  f1=f1.concat(""+pro[y].val+'\n');
							  f2=f2.concat(""+pro[y+1].val+'\n');
							  f3=f3.concat(""+pro[y+2].val+'\n');
						  }
					  }
					 } 
					 PaneOutput.setText(ans);
					 frame1.setText(f1);
					 frame2.setText(f2);
					 frame3.setText(f3);
					 LRUframe1.setText("");
					 LRUframe2.setText("");
					 LRUframe3.setText("");
					 Secframe1.setText("");
					 Secframe2.setText("");
					 Secframe3.setText("");
					 Optframe1.setText("");
					 Optframe2.setText("");
					 Optframe3.setText("");

					 Optimalmiss.setText("");
					 LRUmiss.setText("");
					 Secondmiss.setText("");
					 int answer=nop-pg;
					 FIFOmiss.setText(String.valueOf(answer));
				}
				
				else if(index==2)
				{
					  String valulru;
					  valulru=String.valueOf(nofra.getValue());
					  int noflru,noplru,pglru=0;
					  noflru = Integer.parseInt(valulru);
					  k[] prolru=new k[noflru];
					  Stack s = new Stack();
					  String anslru="";
					  String lruinp="";
					  String f1lru="";
					  String f2lru="";
					  String f3lru="";
					  String valu2lru;
					  valu2lru=String.valueOf(nopro.getValue());
					  noplru = Integer.parseInt(valu2lru);
					  int[] arr=new int[noplru];
					  for(int i=0;i<noplru;i++)
					  {
						  arr[i]=(int)((Math.random()*10)+1);
						  lruinp=lruinp.concat(String.valueOf(arr[i])+'\n');
					  }

					  PaneInput.setText(lruinp);
					 for(int l=0;l<noflru;l++){
						 prolru[l]=new k();
						 prolru[l].index=l;
					 }
					  for(int i=0;i<noplru;i++){
						  int flag=0;
						  for(int j=0;j<prolru.length;j++){
							  if(prolru[j].oc==false){
								  prolru[j].val=arr[i];
								  prolru[j].oc=true;
								  s.push(j);
								  flag=1;
								  break;
							  }
							  if(prolru[j].oc==true&&prolru[j].val==arr[i]){
								  flag=1;
								  pglru++;
								  break;
							  }
						  }
						  if(flag==0){
							  Stack tem=new Stack();
							  int k1=(int)s.pop();
							  prolru[k1].val=arr[i];
							  prolru[k1].oc=true;
							  for(int ki=0;ki<(noflru-1);ki++){
								  tem.push(s.pop());
							  }
							  s.push(k1);
							  for(int ki=0;ki<(noflru-1);ki++){
								  s.push(tem.pop());
							  }	  
						  }
						 int kk;
						  for(int y=0;y<prolru.length;y++){
							  kk=prolru[y].index+1;
							  anslru=anslru.concat("page "+prolru[y].val+" in frame "+kk+'\n');
						  }
						  if(noflru==3)
						  {
							for(int y=0;y<prolru.length;y=y+3)
						  	{
							  	f1lru=f1lru.concat(""+prolru[y].val+'\n');
							  	f2lru=f2lru.concat(""+prolru[y+1].val+'\n');
							  	f3lru=f3lru.concat(""+prolru[y+2].val+'\n');
						  	}
						  }
					  }
					  
					  	 PaneOutput.setText(anslru);
						 LRUframe1.setText(f1lru);
						 LRUframe2.setText(f2lru);
						 LRUframe3.setText(f3lru);
		
						 int answerlru=noplru-pglru;
						// outs[2]=answerlru;
						 LRUmiss.setText(String.valueOf(answerlru));
				}
				
				else if(index==3)
				{
					 String valu;
					  valu=String.valueOf(nofra.getValue());
					  int nof,nop,pg=0;
					  nof = Integer.parseInt(valu);
					  k[] pro=new k[nof];
					  Queue queue=new LinkedList();
					  String ans="";
					  String inp="";
					  String f1="";
					  String f2="";
					  String f3="";
					  String valu2;
					  valu2=String.valueOf(nopro.getValue());
					  nop = Integer.parseInt(valu2);
					  int[] arr=new int[nop];
					  for(int i=0;i<nop;i++){
						  arr[i]=(int)((Math.random()*10)+1);
						  inp=inp.concat(""+arr[i]+'\n');
					  }

					  PaneInput.setText(inp);
				 for(int l=0;l<nof;l++){
					 pro[l]=new k();
					 pro[l].index=l;
				 }
				 for(int i=0;i<nop;i++){
					  int flag=0;
					  for(int j=0;j<pro.length;j++){
						  if(pro[j].oc==false){
							  pro[j].val=arr[i];
							  pro[j].oc=true;
							  queue.add(j);
							  flag=1;
							  break;
						  }
						  if(pro[j].oc==true&&pro[j].val==arr[i]){
							  flag=1;
							  pg++;
							  break;
						  }
					  }
					  if(flag==0){
						 int max=0,in=0,main=0;
						 for(int p=0;p<nof;p++){
							 int ind=100;
							 in=p;
							 for(int h=i+1;h<nop;h++){
								 if(arr[h]==pro[p].val){
									 ind=h;
									 in=p;
									 break;
								 }
							 }
							 if(ind==100){
								 main=in;
								 max=ind;
								 break;
							 }
							 else if(ind>max)
								 max=ind;
							 main=in;
							 
						 }
						 if(max==0){
							 int k1=(int)queue.poll();
							  pro[k1].val=arr[i];
							  pro[k1].oc=true;
							  queue.add(k1);
						 }
						 else{
							 pro[main].val=arr[i];
						 }
					  }
					  int kk;
					  for(int y=0;y<pro.length;y++){
						  kk=pro[y].index+1;
						  ans=ans.concat("page "+pro[y].val+" in frame "+kk+'\n');
					  }
					  if(nof==3)
					  {
						for(int y=0;y<pro.length;y=y+3)
					  	{
						  	f1=f1.concat(""+pro[y].val+'\n');
						  	f2=f2.concat(""+pro[y+1].val+'\n');
						  	f3=f3.concat(""+pro[y+2].val+'\n');
					  	}
					  }
					  
					  
				  }
			  	 PaneOutput.setText(ans);
				 Optframe1.setText(f1);
				 Optframe2.setText(f2);
				 Optframe3.setText(f3);	
				 LRUframe1.setText("");
				 LRUframe2.setText("");
				 LRUframe3.setText("");
				 Secframe1.setText("");
				 Secframe2.setText("");
				 Secframe3.setText("");
				 frame1.setText("");
				 frame2.setText("");
				 frame3.setText("");

				 Secondmiss.setText("");
				 LRUmiss.setText("");
				 FIFOmiss.setText("");
				 int answer=nop-pg;
				 Optimalmiss.setText(String.valueOf(answer));
				}
				
				else if(index==4)
				{
					int c=0;
					  String valu;
					  valu=String.valueOf(nofra.getValue());
					  int nof,nop,pg=0;
					  nof = Integer.parseInt(valu);
					  k[] pro=new k[nof];
					  Queue queue = new LinkedList();
					  String ans="";
					  String inp="";
					  String f1="";
					  String f2="";
					  String f3="";
					  String valu2;
					  valu2=String.valueOf(nopro.getValue());
					  nop = Integer.parseInt(valu2);
					  int[] arr=new int[nop];

					  for(int i=0;i<nop;i++)
					  {
						  arr[i]=(int)((Math.random()*10)+1);
						  inp=inp.concat(String.valueOf(arr[i])+'\n');
				  	  }
					  PaneInput.setText(inp);
					 for(int l=0;l<nof;l++){
						 pro[l]=new k();
						 pro[l].index=l;
					 }
					  for(int i=0;i<nop;i++){
						  int flag=0;
						  for(int j=0;j<pro.length;j++){
							  if(pro[j].oc==false){
								  pro[j].val=arr[i];
								  pro[j].oc=true;
								  queue.add(j);
								  flag=1;
							//	  System.out.println("val"+pro[j].val+i);
								  break;
							  }
							  if(pro[j].oc==true&&pro[j].val==arr[i]){
								  flag=1;
								  pro[j].ref=true;
								  c++;
								  pg++;
								  break;
							  }
						  }
						  if(flag==0){

							  Queue s = new LinkedList();  //create a stack
							  	int count=0;
							  	if(c==3){
							  		for(int f=0;f<nof;f++){
							  			pro[f].ref=false;
							  		}
							  	}
							    //while the queue is not empty
							    while(!queue.isEmpty())
							    {  //add the elements of the queue onto a stack
							    	int k1=(int)queue.element();


							    	if(count==0){
							    	if(pro[k1].ref==true){
							       s.add(queue.poll());
							       pro[k1].ref=false;
							       c--;
							       }
							    	else{
							    		int kk=(int)queue.poll();
							    	//	System.out.println(kk);
							    		  pro[kk].val=arr[i];
										  pro[kk].oc=true;
										  queue.add(kk);
										  count=1;
							    	}
							    	}
							    	else{
							    		s.add(queue.poll());
							    	} 
							    } 

							    while(!s.isEmpty())
							    { 
							      queue.add(s.poll());
							    }
						  }
						  int kk;
						  for(int y=0;y<pro.length;y++){
							  kk=pro[y].index+1;
							  ans=ans.concat("page "+pro[y].val+" in frame "+kk+'\n');
						  }
						  if(nof==3)
						  {
							for(int y=0;y<pro.length;y=y+3)
						  	{
							  	f1=f1.concat(""+pro[y].val+'\n');
							  	f2=f2.concat(""+pro[y+1].val+'\n');
							  	f3=f3.concat(""+pro[y+2].val+'\n');
						  	}
						  }
					  }
					  	 PaneOutput.setText(ans);
						 Secframe1.setText(f1);
						 Secframe2.setText(f2);
						 Secframe3.setText(f3);	
						 LRUframe1.setText("");
						 LRUframe2.setText("");
						 LRUframe3.setText("");
						 frame1.setText("");
						 frame2.setText("");
						 frame3.setText("");
						 Optframe1.setText("");
						 Optframe2.setText("");
						 Optframe3.setText("");
						 Optimalmiss.setText("");
						 LRUmiss.setText("");
						 FIFOmiss.setText("");
						 int answer=nop-pg;
						 Secondmiss.setText(String.valueOf(answer));
				}
			}
		});
		Algo.setBounds(17, 198, 139, 20);
		frmPageReplacements.getContentPane().add(Algo);
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setForeground(Color.ORANGE);
		lblInput.setBounds(192, 1, 59, 20);
		frmPageReplacements.getContentPane().add(lblInput);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPageReplacements.dispose();
			}
		});
		btnHome.setBounds(318, 552, 139, 46);
		frmPageReplacements.getContentPane().add(btnHome);



		


	}
}
