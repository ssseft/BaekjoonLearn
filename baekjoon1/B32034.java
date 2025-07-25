package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B32034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			String coin = br.readLine();
			for(int j= 0;j<n;j++) {
				char c = coin.charAt(j);
				if(c=='T') {
					st.add(j);
				}
			}
			int cnt = cal(st);
			sb.append(cnt+"\n");
			
		}
		System.out.print(sb.toString().trim());
	}
	static int cal(Stack<Integer> st) {
		
		int count = 0;
		while(true) {
			Stack<Integer> nst = new Stack<>();
			int match=0;
			while(!st.isEmpty()){
	            int a = st.pop();
	            if(st.isEmpty()){
	            	nst.push(a);
	                break;
	            }
	            int b = st.pop();

	            if((a-b)%2==1) {
	                count += (a-b);
	                match++;
	            } else {
	            	nst.push(a);
	            	nst.push(b);
	            }
	        }
			if(nst.isEmpty()) {
				break;
			}

	        if(nst.size()%2!=0||match==0) {
	        	return -1;
	        }
	        st = nst;
		}
		
        return count;
	}
}
