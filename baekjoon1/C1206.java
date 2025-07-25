package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<10;i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st=  new StringTokenizer(br.readLine());
			for(int j= 0; j<n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int j = 2; j<n-2;j++) {
				int max = 0;
				if(arr[j-1]<arr[j]&&arr[j-2]<arr[j]&&arr[j+1]<arr[j]&&arr[j+2]<arr[j]) {
					int a = Math.max(arr[j-1], arr[j-2]);
					int b = Math.max(arr[j+1], arr[j+2]);
					max = Math.max(a, b);
					cnt += (arr[j]-max);
				}
				
			}
			sb.append("#"+(i+1)+" "+cnt+"\n");
		}
		System.out.print(sb.toString().trim());
		
	}
}
