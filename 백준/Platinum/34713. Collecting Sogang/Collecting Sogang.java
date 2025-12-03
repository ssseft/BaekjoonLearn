import java.util.*;

public class Main {
	static String word;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		word = sc.next();
		
		int left = 0;
		int right = n/6;
		int max = 0;
		
		while(left<=right){
			int mid = (left+right)/2;
			if(cal(mid)) {
				max = mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		System.out.print(max);
	}
	static boolean cal(int mid) {
		int sog = 0;
		int cnt = 0;
		int[] arr = new int[6];
		//각각 s,so,sog,soga,sogan의 개수
		
		for(int i = 0;i<n;i++) {
			char c = word.charAt(i);
			if(c=='g') {
				if(sog<mid&&arr[2]>0) {
					arr[2]--;
					arr[3]++;
					sog++;
				}
				else {
					if(arr[5]>0) {
						arr[5]--;
						cnt++;
					}
				}
			}
			else if(c=='s') {
				arr[1]++;
			}
			else if(c=='o') {
				if(arr[1]>0) {
					arr[1]--;
					arr[2]++;
				}
			}
			else if(c=='a') {
				if(arr[3]>0) {
					arr[3]--;
					arr[4]++;
				}
			}
			else if(c=='n') {
				if(arr[4]>0) {
					arr[4]--;
					arr[5]++;
				}
			}
		}
		return cnt>=mid;
	}
}
