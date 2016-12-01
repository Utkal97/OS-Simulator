public class FCFS {
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
	public static void main(String []args) {
		int nof=3,min=100,kk=0,processing=0;
		int fin=nof;
		FCFSproc[] process=new FCFSproc[nof];
		for(int i=0;i<nof;i++){
			process[i]=new FCFSproc();
			process[i].setBurstTime();
		process[i].setarrivalTime();
			System.out.println(process[i].arrived);
			process[i].setpriority();

		}
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
//System.out.println(fin);
			if(fin==0)
				break;
		}
		int sum=0;
		for(int i=0;i<nof;i++){
			System.out.println(process[i].wait);
			sum+=process[i].wait;
		}
		System.out.println("Sum->"+(float)sum/nof);
	}
}