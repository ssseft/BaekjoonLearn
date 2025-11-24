import java.util.*;

public class Main {
	static int n,k,max;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		for(int i = 0;i<n;i++) arr[i] = sc.nextInt();
		max = 0;
		
		//N<=20이라 완탐
		recur(0,0,0,false);
		System.out.print(max);
		
		
	}
	static void recur(int idx, int sum, int cur,boolean eating) {
		//eating을 static으로 선언해서 백트래킹도 가능
		if(idx==n) {
			max = Math.max(sum, max);
			return;
		}
		
		if(eating) {
			int c = cur+arr[idx];
			if(c>=k) recur(idx+1,sum+(c-k),0,false);
			else recur(idx+1,sum,c,true);
		}
		else {
			//먹는경우랑 안먹는경우
			recur(idx+1,sum,0,false);
			
			int c = arr[idx];
			if(c>=k) recur(idx+1,sum+(c-k),0,false);
			else recur(idx+1,sum,c,true);
		}
	}
}
