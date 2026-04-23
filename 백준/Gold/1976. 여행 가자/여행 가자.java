import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			arr[a] = b;
		}
	}
	static int find(int x) {
		if(x==arr[x]) {
			return x;
		}
		return arr[x] = find(arr[x]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = i;
		}
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				int c = Integer.parseInt(st.nextToken());
				if(c==1) union(arr[i],arr[j]);
			}
		}
		boolean check = false;
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken())-1;
		int standard = find(first);
		
		for(int i =1;i<m;i++) {
			int c = Integer.parseInt(st.nextToken())-1;
			if(find(c) != standard) {
				check = true;
				break;
			}
		}
		if(!check) System.out.print("YES");
		else System.out.print("NO");
	}
}
