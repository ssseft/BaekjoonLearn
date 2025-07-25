package beakjoon1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16496 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n;i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr,(a,b)-> (b+a).compareTo(a+b));
		
		if(arr[0].equals("0")) {
			System.out.print(0);
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<n;i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
		}
		
	}
}
