package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int[] two = new int[25];
		int index = 0;
		while(n>=1) {
			if(n%2==1) {
				two[index] = 1;
				cnt++;
			}
			n/=2;
			index++;
		}
		int result = 0;
		int startindex = 0;
		int endindex = 0;
		while(cnt>m) {
			for(int i = 0; i<25;i++) {
				if(two[i]==1) {
					startindex = i;
					two[i] = 0;
					cnt--;
					break;
				}
			}
			for(int i = startindex+1;i<25;i++) {
				if(two[i]==1) {
					endindex= i;
					two[i] = 0;
					cnt--;
					break;
				}
			}
			for(int i = startindex;i<endindex;i++) {
				result+= (int)Math.pow(2, i);
			}
			int a = 1;
			while(true) {
				if(two[endindex+a] == 0) {
					two[endindex+a] = 1;
					cnt++;
					break;
				}
				else {
					two[endindex+a] = 0;
					a++;
					cnt--;
				}
			}
			startindex = endindex+a;
		}
		System.out.print(result);
	}
}
