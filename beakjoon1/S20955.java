package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S20955 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<t;i++) {
			String S = br.readLine();
			String E = br.readLine();
			int s_size = S.length();
			int e_size = E.length();
			for(int j = 0; j<e_size-s_size;j++) {
				if(E.charAt(E.length()-1)=='X') {
					E = E.substring(0,E.length()-1);
				}
				else {
					E = new StringBuilder(E.substring(0,E.length()-1)).reverse().toString();
				}
			}
			sb.append("#"+(i+1)+" ");
			if(S.equals(E)) {
				sb.append("Yes\n");
			}
			else {
				sb.append("No\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
}
