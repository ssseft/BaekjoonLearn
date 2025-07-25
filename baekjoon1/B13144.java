package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B13144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		boolean[] duplication = new boolean[100001];
		for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
		int left = 0;
		long cnt = 0;
		
		for(int i = 0; i<n;i++) {
			while(duplication[arr[i]]) {
				duplication[arr[left]] = false;
				left++;
			}
			duplication[arr[i]] = true;
			cnt+= i-left+1;
		}
		
		System.out.print(cnt);
	}
}
