import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> map = new HashSet<>();
		
		for(int i = 0;i<n;i++) {
			String s = br.readLine();
			String d = "";
			for(int j = 0;j<s.length();j++) {
				d+=s.charAt(j);
				map.add(d);
			}
		}
		int cnt = 0;
		for(int i = 0;i<m;i++) {
			if(map.contains(br.readLine())) {
				cnt++;
			}
		}
		System.out.print(cnt);
	}
}
