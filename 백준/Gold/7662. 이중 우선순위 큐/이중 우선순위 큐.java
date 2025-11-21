import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=  new StringBuilder();
		
		for(int a = 0;a<t;a++) {
			TreeMap<Integer,Integer> map = new TreeMap<>();
			int q = Integer.parseInt(br.readLine());
			for(int i = 0;i<q;i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(op.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}
				else {
					int cnt;
					if(map.isEmpty()) continue;
					if(num==1) {
						cnt = map.lastKey();
					}
					else {
						cnt = map.firstKey();
					}
					map.put(cnt, map.get(cnt)-1);
					if(map.get(cnt)==0) {
						map.remove(cnt);
					}
				}
			}
			if(map.isEmpty()) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(map.lastKey()+" "+map.firstKey()+"\n");
			}
		}
		
		System.out.print(sb);
	}
}
