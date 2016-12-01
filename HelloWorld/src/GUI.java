import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class GUI {

	private JFrame frmScheduling;
	/**
	 * Launch the application.
	 */

	private JTextField FCFSOut;
	private JTextField SJFPreOut;
	private JTextField SJFNonPreOut;
	private JTextField PriorPreOut;
	private JTextField PriorNonPreOut;
	private JTextField RROut;
	
	
	
	public  class algo
	{
		float result;
		String name;
	}
	
	public static class FCFSproc{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public boolean robin;
		public int wait;
		public boolean done;
		
		public boolean executing;
		public void setBurstTime(){
			burst=(int)(Math.random()*10+1);
		}
		public void setarrivalTime(){
			arrived=(int)(Math.random()*10);
		}
		public void setpriority(){
			prior=(int)(Math.random()*10+1);
		}
		public void calWait(){
			wait=served-arrived;
		}

		FCFSproc(){
			done=false;
			burst=0;
			arrived=0;
			wait=0;
			prior=0;
		}
	}
	public static class procSJFPre
	{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public int wait;
		public boolean done;
		public void setBurstTime()
		{
			burst=(int)(Math.random()*10+1);
		}
		public void setarrivalTime()
		{
			arrived=(int)(Math.random()*10+1);
		}
		public void setpriority()
		{
			prior=(int)(Math.random()*10+1);
		}
		public void calWait()
		{
			wait=served-arrived;
		}
		procSJFPre()
		{
			done=false;
			burst=0;
			arrived=0;
			wait=0;
			prior=0;
		}
	}
	
	public static class procSJFNonPre
	{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public int wait;
		public boolean done;
		public void setBurstTime(){
			burst=(int)(Math.random()*10+1);
		}
		public void setarrivalTime(){
			arrived=(int)(Math.random()*10+1);
		}
		public void setPriority(){
			prior=(int)(Math.random()*10+1);
		}
		public void calWait(){
			wait=served-arrived;
		}
		procSJFNonPre(){
			done=false;
			burst=0;
		}
	}
	public static class procComb{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public boolean robin;
		public int wait;
		public boolean done;
		public boolean executing;
		public void setBurstTime(){
			burst=(int)(Math.random()*10+1);
		}
		public void setarrivalTime(){
			arrived=(int)(Math.random()*10);
		}
		public void setpriority(){
			prior=(int)(Math.random()*10+1);
		}
		public void calWait(){
			wait=served-arrived;
		}

		procComb(){
			done=false;
			burst=0;
			arrived=0;
			wait=0;
			prior=0;
		}
	}
	
	static void updateWaitingTime(procComb[] programs,int endTime){
		
		for(int i=0;i<10;i++)
		{

			if(programs[i].arrived>endTime){
				break;
			}
			if(!(programs[i].done||programs[i].executing))
			{

				programs[i].wait++;
			}
		}
		
	}
	static boolean allFinished(procComb[] programs){
		for(int i=0;i<10;i++){
			if(programs[i].done==false){
				return false;
			}
		}
		return true;
	}
	
	public static class proc
	{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public int wait;
		public boolean done;
		public void setBurstTime()
		{
			burst=(int)(Math.random()*10+1);
		}
		public void setarrivalTime()
		{
			arrived=(int)(Math.random()*10+1);
		}
		public void setpriority()
		{
			prior=(int)(Math.random()*10+1);
		}
		public void calWait()
		{
			wait=served-arrived;
		}
		proc()
		{
			done=false;
			burst=0;
			arrived=0;
			wait=0;
			prior=0;
		}
	}
	

	public static class procPriorNP{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public int wait;
		public boolean done;
		public void setBurstTime(){
			burst=(int)(Math.random()*10+1);
		}
		public void setarrivalTime(){
			arrived=(int)(Math.random()*10+1);
		}
		public void setPriority(){
			prior=(int)(Math.random()*10+1);
		}
		public void calWait(){
			wait=served-arrived;
		}
		procPriorNP(){
			done=false;
			burst=0;
		}
	}	
	
	static class program{
		public int burstTime;
		public int pid;
		public boolean executing;
		public boolean robin;
		public boolean executed;
		public int arrivalTime;
		int waitingTime;
		public int setBurstTime(){
			burstTime=(int)(Math.random()*10+1);
			return burstTime;
		}
		public int setArrivalTime(int x){
			arrivalTime=(int)(x+1+Math.random()*10);

			return arrivalTime;
		}
		public void print(){

		}
		program(int x){
			robin=false;
			waitingTime=0;
			executing=false;
			executed=false;
			pid=x;
		}
	}
static void updateWaitingTime(program[] programs,int endTime){
		
		for(int i=0;i<10;i++)
		{

			if(programs[i].arrivalTime>endTime){
				break;
			}
			if(!(programs[i].executed||programs[i].executing))
			{

				programs[i].waitingTime++;
			}
		}
		
	}
	static boolean allFinished(program[] programs){
		for(int i=0;i<10;i++)
		{
			if(programs[i].executed==false)
			{
				return false; 
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmScheduling.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScheduling = new JFrame();
		frmScheduling.setTitle("SCHEDULING");
		frmScheduling.setBackground(new Color(128, 0, 0));
		frmScheduling.getContentPane().setBackground(new Color(105, 105, 105));
		frmScheduling.setBounds(100, 100, 460, 340);
	//	frmScheduling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScheduling.getContentPane().setLayout(null);
		
		FCFSOut = new JTextField();
		FCFSOut.setBackground(new Color(255, 255, 255));
		FCFSOut.setBounds(315, 22, 86, 20);
		frmScheduling.getContentPane().add(FCFSOut);
		FCFSOut.setColumns(10);
				
		SJFPreOut = new JTextField();
		SJFPreOut.setBounds(315, 53, 86, 20);
		frmScheduling.getContentPane().add(SJFPreOut);
		SJFPreOut.setColumns(10);
		
		SJFNonPreOut = new JTextField();
		SJFNonPreOut.setBounds(315, 87, 86, 20);
		frmScheduling.getContentPane().add(SJFNonPreOut);
		SJFNonPreOut.setColumns(10);
		
		PriorPreOut = new JTextField();
		PriorPreOut.setBounds(315, 121, 86, 20);
		frmScheduling.getContentPane().add(PriorPreOut);
		PriorPreOut.setColumns(10);
		
		PriorNonPreOut = new JTextField();
		PriorNonPreOut.setBounds(315, 155, 86, 20);
		frmScheduling.getContentPane().add(PriorNonPreOut);
		PriorNonPreOut.setColumns(10);
		
		RROut = new JTextField();
		RROut.setBounds(315, 189, 86, 20);
		frmScheduling.getContentPane().add(RROut);
		RROut.setColumns(10);
		
		JTextArea InputArriveT = new JTextArea();
		InputArriveT.setBounds(20, 40, 26, 171);
		frmScheduling.getContentPane().add(InputArriveT);
		
		JTextArea InputPriorT = new JTextArea();
		InputPriorT.setBounds(104, 40, 26, 171);
		frmScheduling.getContentPane().add(InputPriorT);
		

		JTextArea InputBurstT = new JTextArea();
		InputBurstT.setBounds(64, 40, 26, 171);
		frmScheduling.getContentPane().add(InputBurstT);
		//FCFS starts:____________________________________________________________________________________:
		JButton btnNewButton = new JButton("FCFS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nof=10,min=100,kk=0,processing=0;
				int fin=nof;
				FCFSproc[] process=new FCFSproc[nof];
				for(int i=0;i<nof;i++){
					process[i]=new FCFSproc();
					process[i].setBurstTime();
					process[i].setarrivalTime();
					process[i].setpriority();
				}
				
				
				String Iat,Ibt,Ipt,tempb,tempa;
				tempb=String.valueOf(process[0].burst);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(process[0].arrived);
				Iat=tempa+'\n';
				tempa="";
				
				for(int i=1;i<nof;i++)
				{
					tempb=String.valueOf(process[i].burst);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
					

					tempa=String.valueOf(process[i].arrived);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
				Ipt="";
				InputPriorT.setText(Ipt);
				for(int k=0;;k++){
					min=100;
					if(processing==0){
					for(int tem=0;tem<nof;tem++){

						if(process[tem].arrived<=k&&!process[tem].done){
							if(process[tem].arrived<min){
								min=process[tem].arrived;
								kk=tem;
								processing=1;
							}
							if(process[tem].arrived==min){
								if(kk<tem)
									kk=tem;
								processing=1;
							}
								
						}
					}
					}
					if(processing==1){
					process[kk].done=true;
					process[kk].wait=(k-process[kk].arrived);
					k+=(process[kk].burst-1);
					fin--;
					processing=0;
					}
					if(fin==0)
						break;
				}
				int sum=0;
				for(int i=0;i<nof;i++){
					sum+=process[i].wait;
				}
				System.out.println("Sum->"+(float)sum/nof);
				String FCFSoutput=String.valueOf((float)sum/nof);
				FCFSOut.setText(FCFSoutput);
			
			}
		});
		//FCFS ENDS:////////////////////////////////////////////////////////////////////////////////////////////////
		
		//SJFPreemptive:_____________________________________________________________________
		JButton btnSjfpre = new JButton("SJFPre");
		btnSjfpre.setBackground(Color.DARK_GRAY);
		btnSjfpre.setForeground(Color.WHITE);
		btnSjfpre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int nof=10;
				procSJFPre[] process=new procSJFPre[nof];
				int k=0;
				for(int i=0;i<nof;i++)
				{
					process[i]=new procSJFPre();
					process[i].setBurstTime();
					process[i].setarrivalTime();
					process[i].setpriority();
				}
				String Iat,Ibt,Ipt,tempb,tempa;
				tempb=String.valueOf(process[0].burst);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(process[0].arrived);
				Iat=tempa+'\n';
				tempa="";
				
				
				for(int i=1;i<nof;i++)
				{
					tempb=String.valueOf(process[i].burst);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
					

					tempa=String.valueOf(process[i].arrived);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
				Ipt="";
				InputPriorT.setText(Ipt);
				
				int processing=0,kk=nof,sum=0;
				for(int time=0;;time++){
					int min=100;
					for(int l=0;l<nof;l++)
					{
						if(process[l].arrived<=time && process[l].burst>0)
						{
							if( process[l].burst<min)
							{
								min=process[l].burst;
								k=l;
								processing=1;
							}
						}
					}
					process[k].burst--;
					process[k].wait+=(time-process[k].arrived);
					process[k].arrived=(time+1);
							if(process[k].burst<=0){
								kk--;
					}
					if(kk==0)
						break;
			}
				for(int l=0;l<nof;l++)
				{
					sum+=process[l].wait;
				}
				float SJFPre;
				SJFPre=(float)sum/nof;
				System.out.println("Sum->"+SJFPre);
				String S;
				S=String.valueOf(SJFPre);
				SJFPreOut.setText(S);
			}
		});
		btnSjfpre.setBounds(167, 52, 89, 23);
		frmScheduling.getContentPane().add(btnSjfpre);
		
		
		//SJF Preemptive ENDS://////////////////////////////////////////////////////////////////////
		//SJF NonPreemptive Starts:______________________________________________________________
		
		JButton btnSjfnonpre = new JButton("SJFNonPre");
		btnSjfnonpre.setBackground(Color.DARK_GRAY);
		btnSjfnonpre.setForeground(Color.WHITE);
		btnSjfnonpre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nof=10;
				procSJFNonPre[] process=new procSJFNonPre[nof];
				int k=0;
				for(int i=0;i<nof;i++){
					process[i]=new procSJFNonPre();
					process[i].setBurstTime();
					process[i].setarrivalTime();
					process[i].setPriority();
				}
				
				String Iat,Ibt,Ipt,tempb,tempa;
				tempb=String.valueOf(process[0].burst);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(process[0].arrived);
				Iat=tempa+'\n';
				tempa="";
				
				for(int i=1;i<nof;i++)
				{
					tempb=String.valueOf(process[i].burst);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
					

					tempa=String.valueOf(process[i].arrived);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
				Ipt="";
				InputPriorT.setText(Ipt);
				
				int processing=0,kk=nof,sum=0;
				for(int i=0;;i++){
					int min=100;
					if(processing==0){
						for(int l=0;l<nof;l++){
							if(process[l].arrived<=i && !process[l].done){
								if(process[l].burst<min){
									min=process[l].burst;
									k=l;
									processing=1;
								}
							}
						}
						if(processing==1){
							process[k].served=i;
							process[k].calWait();
							process[k].done=true;
							i+=(process[k].burst-1);
							sum+=process[k].burst;
							kk--;
							processing=0;
						}
					}
					if(kk==0)
					break;
				}
				for(int i=0;i<nof;i++)
				{
					sum+=process[i].wait;
				}
				float SJFNPans;
				SJFNPans=(float)sum/nof;
				System.out.println("Sum->"+SJFNPans);
				String S;
				S=String.valueOf(SJFNPans);
				SJFNonPreOut.setText(S);
			}
		});
		btnSjfnonpre.setBounds(167, 86, 89, 23);
		frmScheduling.getContentPane().add(btnSjfnonpre);
		
		
		//SJFNon Preemptive ENDS:////////////////////////////////////////////////////////////////////
		//Priority Preemptive Starts:________________________________________________________________
		JButton btnPriorpre = new JButton("PriorPre");
		btnPriorpre.setBackground(Color.DARK_GRAY);
		btnPriorpre.setForeground(Color.WHITE);
		btnPriorpre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nof=10;
				proc[] process=new proc[nof];
				int k=0;
				for(int i=0;i<nof;i++)
				{
					process[i]=new proc();
					process[i].setBurstTime();
					process[i].setarrivalTime();
					process[i].setpriority();
				}
				
				String Iat,Ibt,Ipt,tempb,tempa,tempp;
				tempb=String.valueOf(process[0].burst);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(process[0].arrived);
				Iat=tempa+'\n';
				tempa="";
				
				tempp=String.valueOf(process[0].prior);
				Ipt=tempp+'\n';
				tempp="";
				
				for(int i=1;i<nof;i++)
				{
					tempb=String.valueOf(process[i].burst);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
			
					tempa=String.valueOf(process[i].arrived);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
			
					tempp=String.valueOf(process[i].prior);
					tempp=tempp+'\n';
					Ipt=Ipt.concat(tempp);
					tempp="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
				InputPriorT.setText(Ipt);
							
				int processing=0,kk=nof,sum=0;
				for(int time=0;;time++)
				{
					int min=100;
					for(int l=0;l<nof;l++)
					{
						if(process[l].arrived<=time && process[l].burst>0)
						{
							if( process[l].prior<min)
							{
								min=process[l].prior;
								k=l;
								processing=1;
							}
						}
					}
					process[k].burst--;
					process[k].wait+=(time-process[k].arrived);
					process[k].arrived=(time+1);
					if(process[k].burst<=0)
					{
						kk--;
					}
					if(kk==0)
						break;
			}
				for(int l=0;l<nof;l++)
				{
					sum+=process[l].wait;
				}
				float PriorPans;
				PriorPans=(float)sum/nof;
				System.out.println("Sum->"+PriorPans);
				String S;
				S=String.valueOf(PriorPans);
				PriorPreOut.setText(S);
			}
		});
		btnPriorpre.setBounds(167, 120, 89, 23);
		frmScheduling.getContentPane().add(btnPriorpre);
		
	
		
		//Priority Preemptive ENDS:////////////////////////////////////////////////////////////////////
		//PriorityNonpreemptive:_______________________________________________________________________
		
		JButton btnPriornonpre = new JButton("PriorNonPre");
		btnPriornonpre.setBackground(Color.DARK_GRAY);
		btnPriornonpre.setForeground(Color.WHITE);
		btnPriornonpre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nof=10;
				procPriorNP[] process=new procPriorNP[nof];
				int k=0;
				for(int i=0;i<nof;i++){
					process[i]=new procPriorNP();
					process[i].setBurstTime();
					process[i].setarrivalTime();
					process[i].setPriority();
				}
				
				String Iat,Ibt,Ipt,tempb,tempa,tempp;
				tempb=String.valueOf(process[0].burst);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(process[0].arrived);
				Iat=tempa+'\n';
				tempa="";
				
				tempp=String.valueOf(process[0].prior);
				Ipt=tempp+'\n';
				tempp="";
				
				for(int i=1;i<nof;i++)
				{
					tempb=String.valueOf(process[i].burst);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
					
					tempa=String.valueOf(process[i].arrived);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
					
					tempp=String.valueOf(process[i].prior);
					tempp=tempp+'\n';
					Ipt=Ipt.concat(tempp);
					tempp="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
				InputPriorT.setText(Ipt);
				
				int processing=0,kk=nof,sum=0;
				for(int i=0;;i++){
					int min=100;
					if(processing==0){
						for(int l=0;l<nof;l++){
							if(process[l].arrived<=i && !process[l].done){
								if(process[l].prior<min){
									min=process[l].prior;
									k=l;
									processing=1;
								}
							}
						}
						if(processing==1){
							process[k].served=i;
							process[k].calWait();
						process[k].done=true;
						i+=(process[k].burst-1);
							sum+=process[k].burst;
							kk--;
							processing=0;
						}
					}
					if(kk==0)
						break;
			}
				for(int i=0;i<nof;i++){
					sum+=process[i].wait;
				}
				System.out.println("Sum->"+(float)sum/nof);
				String S;
				S=String.valueOf((float)sum/nof);
				PriorNonPreOut.setText(S);
			}
		});
		btnPriornonpre.setBounds(167, 154, 89, 23);
		frmScheduling.getContentPane().add(btnPriornonpre);
		
		//Priority NONPreemptive ENDS://///////////////////////////////////////////////////////////
		//Round Robin Starts:_____________________________________________________________________
		
		JButton btnRr = new JButton("RR");
		btnRr.setBackground(Color.DARK_GRAY);
		btnRr.setForeground(Color.WHITE);
		btnRr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Queue robins=new LinkedList();
				int t=0;
				int quantumTime=2;
				program[] programs=new program[10];
				for(int i=0;i<10;i++){
					programs[i]=new program(i);
				}

				for(int i=0;i<10;i++)
				{
					programs[i].setBurstTime();
					t=programs[i].setArrivalTime(t);
					programs[i].print();
				}

				
				String Iat,Ibt,tempb,tempa;
				tempb=String.valueOf(programs[0].burstTime);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(programs[0].arrivalTime);
				Iat=tempa+'\n';
				tempa="";
							
				for(int i=1;i<10;i++)
				{
					tempb=String.valueOf(programs[i].burstTime);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
			
					tempa=String.valueOf(programs[i].arrivalTime);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
			
				String Ipt;
				Ipt="";
				InputPriorT.setText(Ipt);
				int executing=0;
				for(int time=0;!allFinished(programs);)
				{
					for(int i=0;i<10;i++){
						if(programs[i].arrivalTime<=time && !programs[i].robin){
							robins.add(i);
							programs[i].robin=true;
						}
					}
					if(robins.isEmpty()){

						time++;
						continue;
					}
					executing=(int)robins.element();
					robins.remove();
					for(int i=0;i<quantumTime;i++){
						if(programs[executing].burstTime!=0)
						{

							programs[executing].burstTime--;
							
						}
						else
						{
						}
						updateWaitingTime(programs,time);
						time++;
					}
					if(programs[executing].burstTime==0){
						programs[executing].executed=true;
					}
					else
					{
						robins.add(executing);
					}
						
				}
		int sum1=0;
				for(int i=0;i<10;i++){
	sum1+=programs[i].waitingTime;
				}
				System.out.println("RR"+"Sum->"+(float)sum1/10);
				String S;
				S=String.valueOf((float)sum1/10);
				RROut.setText(S);
			}
		});
		btnRr.setBounds(167, 188, 89, 23);
		frmScheduling.getContentPane().add(btnRr);
		
		
		//Best Of All:_________________________________________________________________________________________
	
		
		
		JButton Runall = new JButton("All");
		Runall.setBackground(Color.DARK_GRAY);
		Runall.setForeground(Color.ORANGE);
		Runall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				algo[] best=new algo[6];
				int nof=10;
				int[] outs;
				outs=new int[6];
				
				procComb[] process=new procComb[nof];
				int k=0,now,time;
				int[] b=new int[100];
				int[] a=new int[100];
				int[] p=new int[100];
				for(int i=0;i<nof;i++){
					process[i]=new procComb();
					process[i].setBurstTime();
					b[i]=process[i].burst;
					process[i].setarrivalTime();
					a[i]=process[i].arrived;
					process[i].setpriority();
					p[i]=process[i].prior;
				}
				
				String Iat,Ibt,Ipt,tempb,tempa,tempp;
				tempb=String.valueOf(process[0].burst);
				Ibt=tempb+'\n';
				tempb="";
			
				tempa=String.valueOf(process[0].arrived);
				Iat=tempa+'\n';
				tempa="";
				
				tempp=String.valueOf(process[0].prior);
				Ipt=tempp+'\n';
				tempp="";
				
				for(int i=1;i<nof;i++)
				{
					tempb=String.valueOf(process[i].burst);
					tempb=tempb+'\n';
					Ibt=Ibt.concat(tempb);
					tempb="";
					
					tempa=String.valueOf(process[i].arrived);
					tempa=tempa+'\n';
					Iat=Iat.concat(tempa);
					tempa="";
					
					tempp=String.valueOf(process[i].prior);
					tempp=tempp+'\n';
					Ipt=Ipt.concat(tempp);
					tempp="";
				}
				
				InputBurstT.setText(Ibt);
				InputArriveT.setText(Iat);
				InputPriorT.setText(Ipt);
				
				int processing=0;
				int kk=nof,sum=0;
				for(time=0;;time++){
					int min=100;
					for(int l=0;l<nof;l++)
					{
						if(process[l].arrived<=time & process[l].burst>0)
						{
							if( process[l].burst<min){
							min=process[l].burst;
							k=l;
							processing=1;
							}
						}
					}
					process[k].burst--;
					process[k].wait+=(time-process[k].arrived);
					process[k].arrived=(time+1);
							if(process[k].burst<=0){
								kk--;
					}
					if(kk==0)
						break;
			}
				for(int l=0;l<nof;l++)
				{
					sum+=process[l].wait;
				}
				System.out.println("P"+"Sum->"+(float)sum/nof);
				outs[1]=((int)sum/nof);
				String SJFPoutput;
				SJFPoutput=String.valueOf((float)sum/nof);
				SJFPreOut.setText(SJFPoutput);
				for(now=0;now<nof;now++){
					process[now].burst=b[now];
					process[now].arrived=a[now];
					process[now].done=false;
				}
		//P
		//NP
				processing=0;
				kk=nof;
				sum=0;
				for(int i=0;;i++){
					int min=100;
					if(processing==0){
						for(int l=0;l<nof;l++){
							if(process[l].arrived<=i & !process[l].done){
								if(process[l].burst<min){
									min=process[l].burst;
									k=l;
									processing=1;
								}
							}
						}
						if(processing==1){
							process[k].served=i;
							process[k].calWait();
							process[k].done=true;
							i+=(process[k].burst-1);
							sum+=process[k].burst;
							kk--;
							processing=0;
						}
					}
					if(kk==0)
						break;
			}
				for(int i=0;i<nof;i++){
					sum+=process[i].wait;
				}
				System.out.println("NP"+"Sum->"+(float)sum/nof);
				String SJFNPoutput;
				SJFNPoutput=String.valueOf((float)sum/nof);
				outs[2]=((int)sum/nof);
				SJFNonPreOut.setText(SJFNPoutput);
				
				for(now=0;now<nof;now++){
					process[now].burst=b[now];
					process[now].arrived=a[now];
					process[now].done=false;
				}
		//NP
		//PNP
				processing=0;
				kk=nof;
				sum=0;
				for(int i=0;;i++){
					int min=100;
					if(processing==0){
						for(int l=0;l<nof;l++){
							if(process[l].arrived<=i & !process[l].done){
								if(process[l].prior<min){
									min=process[l].prior;
									k=l;
									processing=1;
								}
							}
						}
						if(processing==1){
							process[k].served=i;
							process[k].calWait();
							process[k].done=true;
							i+=(process[k].burst-1);
							sum+=process[k].burst;
							kk--;
							processing=0;
						}
					}
					if(kk==0)
						break;
			}
				for(int i=0;i<nof;i++){
				sum+=process[i].wait;
				}
				System.out.println("PNP"+"Sum->"+(float)sum/nof);
				outs[4]=((int)sum/nof);
				String PNPoutput;
				PNPoutput=String.valueOf((float)sum/nof);
				PriorNonPreOut.setText(PNPoutput);
				for(now=0;now<nof;now++){
					process[now].burst=b[now];
					process[now].arrived=a[now];
					process[now].prior=p[now];
					process[now].done=false;
				}
		//PNP
		//PP
				processing=0;
				kk=nof;
				sum=0;
				for( time=0;;time++){
					int min=100;
					for(int l=0;l<nof;l++)
					{
						if(process[l].arrived<=time & process[l].burst>0)
						{
							if( process[l].prior<min){
							min=process[l].prior;
							k=l;
							processing=1;
							}
						}
					}
					process[k].burst--;
					process[k].wait+=(time-process[k].arrived);
					process[k].arrived=(time+1);
							if(process[k].burst<=0){
								kk--;
					}
					if(kk==0)
						break;
			}
				for(int l=0;l<nof;l++)
				{
					sum+=process[l].wait;
				}
				System.out.println("PP"+"Sum->"+(float)sum/nof);
				outs[3]=((int)sum/nof);
				String PPoutput;
				PPoutput=String.valueOf((float)sum/nof);
				PriorPreOut.setText(PPoutput);
				for(now=0;now<nof;now++){
					process[now].burst=b[now];
					process[now].arrived=a[now];
					process[now].prior=p[now];
					process[now].done=false;
				}

		//PP
				//FCFS
				processing=0;
				int fin=nof;
				for( k=0;;k++){
					int min=100;
					if(processing==0){
					for(int tem=0;tem<nof;tem++){

						if(process[tem].arrived<=k&&!process[tem].done){
							if(process[tem].arrived<min){
								min=process[tem].arrived;
								kk=tem;
								processing=1;
							}
							if(process[tem].arrived==min){
								if(kk<tem)
									kk=tem;
								processing=1;
							}
								
						}
					}
					}
					if(processing==1){
					process[kk].done=true;
					process[kk].wait=(k-process[kk].arrived);
					k+=(process[kk].burst-1);
					fin--;
					processing=0;
					}
					if(fin==0)
						break;
				}
				sum=0;
				for(int i=0;i<nof;i++){
					sum+=process[i].wait;
				}
				for(now=0;now<nof;now++){
					process[now].burst=b[now];
					process[now].arrived=a[now];
					process[now].prior=p[now];
					process[now].done=false;
					process[now].wait=0;
				}
				String FCFSoutput;
				FCFSoutput=String.valueOf((float)sum/nof);
				outs[0]=((int)sum/nof);
				FCFSOut.setText(FCFSoutput);
		//FCFS

		//RR
				Queue robins=new LinkedList();
				int t=0;
				int quantumTime=5;
				int executing=0;
				for(time=0;!allFinished(process);)
				{
					for(int i=0;i<nof;i++){
						if(process[i].arrived<=time && !process[i].robin){
							robins.add(i);
							process[i].robin=true;
						}
					}
					if(robins.isEmpty()){
						time++;
						continue;
					}
					executing=(int)robins.element();
					robins.remove();
					for(int i=0;i<quantumTime;i++){
						if(process[executing].burst!=0)
						{
							process[executing].burst--;
						}
						else
						{

						}
						updateWaitingTime(process,time);
						time++;
					}
					if(process[executing].burst==0){
						process[executing].done=true;
					}
					else
					{
						robins.add(executing);
					}
				}
		for(now=0;now<nof;now++){
			sum=process[now].wait++;
		}
		float ans=(float)sum/nof;
		ans=ans+10;
		System.out.println("RR"+"Sum->"+ans);
		outs[5]=((int)sum/nof+10);
		//RR
		String RRoutput;
		RRoutput=String.valueOf(ans);
	
		RROut.setText(RRoutput);
		test.main(null, outs);

			}
		});
		Runall.setBounds(241, 227, 89, 23);
		frmScheduling.getContentPane().add(Runall);

		JLabel lblAt = new JLabel("A.T.");
		lblAt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAt.setForeground(new Color(255, 255, 255));
		lblAt.setBounds(24, 15, 22, 19);
		frmScheduling.getContentPane().add(lblAt);
		
		JLabel lblBt = new JLabel("B.T.");
		lblBt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBt.setForeground(new Color(255, 255, 255));
		lblBt.setBounds(64, 15, 26, 19);
		frmScheduling.getContentPane().add(lblBt);
		
		JLabel lblPt = new JLabel("P.T.");
		lblPt.setForeground(new Color(255, 255, 255));
		lblPt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPt.setBounds(111, 15, 26, 19);
		frmScheduling.getContentPane().add(lblPt);
		

		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(167, 18, 89, 23);
		frmScheduling.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String clean;
			clean="";
			FCFSOut.setText(clean);
			SJFPreOut.setText(clean);
			SJFNonPreOut.setText(clean);
			PriorPreOut.setText(clean);
			PriorNonPreOut.setText(clean);
			RROut.setText(clean);
			InputArriveT.setText(clean);
			InputBurstT.setText(clean);
			InputPriorT.setText(clean);
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setBounds(352, 227, 72, 23);
		frmScheduling.getContentPane().add(btnNewButton_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmScheduling.dispose();
			}
		});
		btnHome.setBounds(169, 257, 100, 33);
		frmScheduling.getContentPane().add(btnHome);
	}
}