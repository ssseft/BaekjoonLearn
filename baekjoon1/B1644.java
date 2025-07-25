package beakjoon1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1644 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 sc.close();
		 boolean[] dec = new boolean[n+1];
		 dec[1] = true;
		 dec[0] = true;
		 
		 for(int i =2; i<=(int)Math.sqrt(n);i++) {
			 if(dec[i]) continue;
			 for(int j = i*i;j<n+1;j+=i) {
				 dec[j] = true;
			 }
		 }
		 List<Integer> list = new ArrayList<>();
		 for(int i = 2;i<=n;i++) {
			 if(!dec[i]) {
				 list.add(i);
			 }
		 }
		 
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		while(right<list.size()) {
			 if(sum==n) {
				 cnt++;
				 sum+= list.get(right++);
			 }
			 else if(sum<n) {
				 sum += list.get(right++);
			 }
			 else {
				 sum -= list.get(left++);
			 }
		}
		if(!dec[n]) {
			cnt++;
		}
		System.out.print(cnt);
		 
		 
	}
}
