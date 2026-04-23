import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int[] cnt = new int[5];
		int[][] arr = new int[6][2];
		
		for(int i = 0;i<6;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			cnt[arr[i][0]]++;
		}
		
		List<Integer> two = new ArrayList<>();
		int idx = 0;
		int[] one = new int[2];
		
		for(int i = 1;i<=4;i++) {
			if(cnt[i]==2) two.add(i);
			else one[idx++] = i;
		}
		
		int a = 0;
		int b = 0;
		
		for(int i = 0;i<6;i++) {
			if(two.contains(arr[((i-1)+6)%6][0])&&two.contains(arr[(i+2)%6][0])&&two.contains(arr[(i)%6][0])) {
				a = arr[i][1];
				b = arr[(i+1)%6][1];
			}
		}
		
		int m1 = 0;
		int m2 = 0;
		for(int i = 0;i<6;i++) {
			if(arr[i][0]==one[0]) m1 = arr[i][1];
			if(arr[i][0]==one[1]) m2 = arr[i][1];
		}
		int total = m1*m2;
		int r = a*b;
		int ans = total-r;
		
		System.out.print(ans*k);
	}

}