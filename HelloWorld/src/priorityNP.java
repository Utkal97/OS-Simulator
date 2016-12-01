
public class priorityNP {
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
	public static void main(String args[]){
		int nof=10;
		procPriorNP[] process=new procPriorNP[nof];
		int k=0;
		for(int i=0;i<nof;i++){
			process[i]=new procPriorNP();
			process[i].setBurstTime();
			process[i].setarrivalTime();
			process[i].setPriority();
		}
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
	}
}
