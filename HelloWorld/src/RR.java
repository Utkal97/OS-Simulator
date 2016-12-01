	import java.util.*;
public class RR {


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
			for(int i=0;i<10;i++){
				if(programs[i].executed==false){
					return false;

				}
			}
			return true;
		}
		public static void main(String args[]){
			Queue robins=new LinkedList();
			int t=0;
			int quantumTime=2;//Change this to change the quantum time
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
		}
	}

