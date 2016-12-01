

public class preemptive {
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
	public static void main(String args[]){
		int nof=10;
		procSJFPre[] process=new procSJFPre[nof];
		int k=0;
		for(int i=0;i<nof;i++){
			process[i]=new procSJFPre();
			process[i].setBurstTime();
			process[i].setarrivalTime();
			process[i].setpriority();
		}
		int processing=0,kk=nof,sum=0;
		for(int time=0;;time++){
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
		System.out.println("Sum->"+(float)sum/nof);
	}
}
