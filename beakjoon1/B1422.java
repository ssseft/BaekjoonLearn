package beakjoon1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[k];
		int maxlength = 0;
		for(int i = 0; i<k;i++) {
			arr[i] = br.readLine();
			if(arr[i].length()>maxlength) {
				maxlength = arr[i].length();
			}
		}
		
		Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
		StringBuilder sb = new StringBuilder();
		boolean check = false;
		
		for(int i = 0; i<k;i++) {
			String c = arr[i];
			if(!check&&c.length()==maxlength) {
				for(int j = 0; j<n-k;j++) {
					sb.append(c);
				}
				check = true;
			}
			sb.append(c);
		}
		System.out.print(sb.toString());
		
	}
}
