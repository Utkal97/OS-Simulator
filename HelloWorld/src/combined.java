import java.util.LinkedList;
import java.util.Queue;

public class combined {
	public static class procComb{
		public int burst;
		public int arrived;
		public int served;
		public int prior;
		public boolean robin;
		public int wait;
		public boolean done;
		
		//root_edit
		
		public boolean executing;
		//root_edit
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
		/*root_edit
		
		public int runTime;
		public boolean processed;
		public int waiting;
		public int timeOfFormation;

		public void setTimeOfFormation(int input){
			timeOfFormation=input;
		}
		
		/Root_edit
	*/
	
	
	public static void main(String args[]){
		int nof=10;
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
			System.out.println(process[i].burst+"b");
			System.out.println(process[i].arrived+"a");
		}
		int processing=0;
		int kk=nof,sum=0;
		for(time=0;;time++){
			int min=100;
			for(int l=0;l<nof;l++)
			{
				if(process[l].arrived<=time && process[l].burst>0)
				{
					if( process[l].burst<min){
					min=process[l].burst;
					k=l;
					processing=1;
					}
				}
			}	process[k].burst--;
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
		for(now=0;now<nof;now++){
			process[now].burst=b[now];
			process[now].arrived=a[now];
			process[now].done=false;
			process[now].wait=0;
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
			//		System.out.println(i);
					process[k].calWait();
			//		System.out.println(process[k].wait+"w");
					process[k].done=true;
				//	System.out.println(process[k].burst+"b");
					i+=(process[k].burst-1);
					sum+=process[k].burst;
					kk--;
					processing=0;
				}
			}
		//	System.out.println(i+"s");
			if(kk==0)
				break;
	}
		for(int i=0;i<nof;i++){
		//	System.out.println(process[i].burst+"b");
		//	System.out.println(process[i].wait+"w");
			sum+=process[i].wait;
		}
		System.out.println("NP"+"Sum->"+(float)sum/nof);
		for(now=0;now<nof;now++){
			process[now].burst=b[now];
			process[now].arrived=a[now];
			process[now].done=false;
			process[now].wait=0;
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
			//		System.out.println(i);
					process[k].calWait();
			//		System.out.println(process[k].wait+"w");
					process[k].done=true;
				//	System.out.println(process[k].burst+"b");
					i+=(process[k].burst-1);
					sum+=process[k].burst;
					kk--;
					processing=0;
				}
			}
		//	System.out.println(i+"s");
			if(kk==0)
				break;
	}
		for(int i=0;i<nof;i++){
		//	System.out.println(process[i].burst+"b");
		//	System.out.println(process[i].wait+"w");
			sum+=process[i].wait;
		}
		System.out.println("PNP"+"Sum->"+(float)sum/nof);
		for(now=0;now<nof;now++){
			process[now].burst=b[now];
			process[now].arrived=a[now];
			process[now].prior=p[now];
			process[now].done=false;
			process[now].wait=0;
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
				if(process[l].arrived<=time && process[l].burst>0)
				{
					if( process[l].prior<min){
					min=process[l].prior;
					k=l;
					processing=1;
					}
				}
			}
	//		System.out.println(k+"k");
			process[k].burst--;
			process[k].wait+=(time-process[k].arrived);
			//System.out.println(time+"s"+k);
			//System.out.println(process[k].wait+"w"+k);
			process[k].arrived=(time+1);
					if(process[k].burst<=0){
						kk--;
			}
				//	System.out.println(kk);
			if(kk==0)
				break;
	}
		//System.out.println((float)sum/nof);
		for(int l=0;l<nof;l++)
		{
			//System.out.println(process[l].burst+"b");
			//System.out.println(process[l].wait+"w");
			sum+=process[l].wait;
		}
		System.out.println("PP"+"Sum->"+(float)sum/nof);
		for(now=0;now<nof;now++){
			process[now].burst=b[now];
			process[now].arrived=a[now];
			process[now].prior=p[now];
			process[now].done=false;
			process[now].wait=0;
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
		System.out.println("FCFSSum->"+(float)sum/nof);
		for(now=0;now<nof;now++){
			process[now].burst=b[now];
			process[now].arrived=a[now];
			process[now].prior=p[now];
			process[now].done=false;
			process[now].wait=0;
		}
				
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
System.out.println("RR"+"Sum->"+(float)sum/nof);
//RR

	}
}
