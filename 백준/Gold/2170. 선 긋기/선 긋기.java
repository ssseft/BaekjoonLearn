import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>();
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		Collections.sort(list,(a,b)->Integer.compare(a[0], b[0]));
		int result = 0;
		int currentend = list.get(0)[1];
		int currentstart = list.get(0)[0];
		for(int i = 1;i<n;i++) {
			int[] arr = list.get(i);
			int start = arr[0];
			int end = arr[1];
			
			if(start<=currentend) {
				currentend = Math.max(currentend, end);
			}
			else {
				result+=currentend-currentstart;
				currentstart=start;
				currentend= end;
			}
			
		}
		
		result += currentend-currentstart;
		
		System.out.print(result);
		
	}
}