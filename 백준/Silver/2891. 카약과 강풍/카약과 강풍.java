import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		boolean[] broken = new boolean[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0;i<s;i++) {
			broken[Integer.parseInt(st.nextToken())-1] = true; //부셔졌다면 true;
		}
		boolean[] addone = new boolean[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i =0; i<r;i++) {
			addone[Integer.parseInt(st.nextToken())-1] = true; // 하나 더 있다면 true;
		}
		
		for(int i =0; i<n;i++) {
			if(broken[i]&&addone[i]) {
				addone[i] = false;
				broken[i] = false;
			}
		}
		
		for(int i =0; i<n;i++) {
			if(broken[i]) {
				if(i!=0&&addone[i-1]) {
					addone[i-1] = false;
					broken[i] = false;
				}
				else if(i!=n-1&&addone[i+1]) {
					addone[i+1] = false;
					broken[i] = false;
				}
			}
		}
		int count =0;
		for(int i =0; i<n;i++) {
			if(broken[i]) {
				count++;
			}
		}
		System.out.print(count);
	}
}
