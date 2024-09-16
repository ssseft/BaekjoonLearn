package beakjun;

public class B4673 {
	public static void main(String[] args) {
		boolean[] numbers = new boolean[10001];
		
		for(int i =0; i<=10000;i++) {
			int a = SN(i);
			if(a<=10000) {
				numbers[a] = true;
			}
			
		}
		
		for(int i=0;i<=10000;i++) {
			if(!numbers[i])
			System.out.println(i);
		}
		
		
	}
	
	public static int SN(int n) {
		int num = n;
		while(n>0) {
			num+=n%10;
			n/=10;
		}
		return num;
	}
}