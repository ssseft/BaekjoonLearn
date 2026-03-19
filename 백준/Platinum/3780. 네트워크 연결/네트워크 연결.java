import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int find(int x) {
		if(x==parent[x]) return x;
		int temp = find(parent[x]);
		value[x] += value[parent[x]];
		parent[x] = temp;
		return parent[x];
	}
	static int[] parent,value;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n+1];
			value = new int[n+1];
			for(int j = 1;j<=n;j++)	parent[j] = j;
			while(true) {
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				if(op=='O') break;
				if(op=='E') {
					int v = Integer.parseInt(st.nextToken());
					find(v);
					sb.append(value[v]+"\n");
				}
				else {
					int s = Integer.parseInt(st.nextToken());
					int e = Integer.parseInt(st.nextToken());
					parent[s] = e;
					value[s] += Math.abs(s-e)%1000;
				}
			}
		}
		System.out.print(sb);
	}
}
