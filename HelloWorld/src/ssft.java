
public class ssft {
	public static class n{
		int dt;
		int fl;
		n(){
			dt=0;
			fl=0;
		}
	}
	public static void main(String[]args){
		int nof=8,mmin=1000,iin=0;
		n[] nod=new n[nof];
		//hi.arr=new int[nof];
		for(int i=0;i<nof;i++){
			int l=(int)((Math.random()*100)+1);
			nod[i]=new n();
			nod[i].dt=l;
			System.out.println(nod[i].dt);
		}
		int head=40,fl=0;
		//nod[head].fl=1;
		for(int i=0;i<nof;i++){
			int min=1000;
			int in=0;
			int count=0;
			System.out.println("head"+head);
			if(i==0){
				for(int j=0;j<(nof);j++){
					if(nod[j].fl==0){
						if((nod[j].dt-head)>=0){
							if(nod[j].dt-head<=min){
						min=(nod[j].dt-head);
						in=j;
						count=1;}
				//		System.out.println("s"+j+"dt"+nod[j].dt);
					}
						else{
							if(head-nod[j].dt<=min){
								min=(head-nod[j].dt);
								in=j;
								count=1;}
						}
						}
				}
				//System.out.println("a"+min);
				if(count==1){
					nod[in].fl=1;
					head=in;
					System.out.println("inda"+nod[in].dt);
				}
				else if(count==0&&fl==0){
					head=iin;
					fl=1;
					System.out.println("indaa"+nod[iin].dt);
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
					in=j;
					count=1;}
			//		System.out.println("s"+j+"dt"+nod[j].dt);
				}
					else{
						if(nod[head].dt-nod[j].dt<=min){
							min=(nod[head].dt-nod[j].dt);
							in=j;
							count=1;}
					}
					}
			}
			//System.out.println("a"+min);
			if(count==1){
				nod[in].fl=1;
				head=in;
				System.out.println("inda"+nod[in].dt);
			}
			else if(count==0&&fl==0){
				head=iin;
				fl=1;
				System.out.println("inda"+nod[iin].dt);
			}	
			else
				break;
		}
			}
}
}
