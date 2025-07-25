package beakjoon1;
import java.io.*;

public class B10775 {
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
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int result = p;
		arr = new int[g+1];
		for(int i = 1; i<g+1;i++) {
			arr[i] = i;
		}
		for(int i = 0; i<p;i++) {
			int c = Integer.parseInt(br.readLine());
			int gate = find(c);
			if(gate == 0) {
				result = i;
				break;
			}
			union(gate,gate-1);
		}
		
		System.out.print(result);
		
	}
}
