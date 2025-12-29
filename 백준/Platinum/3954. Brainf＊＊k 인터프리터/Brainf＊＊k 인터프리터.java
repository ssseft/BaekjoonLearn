import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int msize = Integer.parseInt(st.nextToken());
			int csize = Integer.parseInt(st.nextToken());
			int isize = Integer.parseInt(st.nextToken());
			
			int pointer = 0;
			int[] arr = new int[msize];
			
			String code = br.readLine();
			Stack<Integer> stack = new Stack<>();
			int[] pair = new int[csize];
			Arrays.fill(pair, -1);
			
			for(int j = 0;j<csize;j++) {
				char c = code.charAt(j);
				if(c=='[') stack.add(j);
				if(c==']') {
					int p = stack.pop();
					pair[p] = j;
					pair[j] = p;
				}
			}
			
			String input = br.readLine();
			int iidx = 0;
			int cnt = 0;
			int s = 0;
			while(cnt<50000000&&s<csize) {
				char c = code.charAt(s);
				if(c=='-') {
					if(arr[pointer]==0) arr[pointer]=256;
					arr[pointer]--;
				}
				else if(c=='+') {
					if(arr[pointer]==255) arr[pointer]= -1;
					arr[pointer]++;
				}
				else if(c=='<') {
					if(pointer==0) pointer = msize;
					pointer--;
				}
				else if(c=='>') {
					if(pointer==msize-1) pointer = -1;
					pointer++;
				}
				else if(c=='[') {
					if(arr[pointer]==0) s = pair[s];
				}
				else if(c==']') {
					if(arr[pointer]!=0) s = pair[s];
				}
				else if(c==',') {
					if(iidx==isize) arr[pointer] = 255;
					else arr[pointer] = input.charAt(iidx++);
				}
				s++;
				cnt++;
			}
			int maxidx = -1;
			if(s==csize) sb.append("Terminates\n");
			else {
				while(cnt<100000000&&s<csize) {
					char c = code.charAt(s);
					if(c=='-') {
						if(arr[pointer]==0) arr[pointer]=256;
						arr[pointer]--;
					}
					else if(c=='+') {
						if(arr[pointer]==255) arr[pointer]= -1;
						arr[pointer]++;
					}
					else if(c=='<') {
						if(pointer==0) pointer = msize;
						pointer--;
					}
					else if(c=='>') {
						if(pointer==msize-1) pointer = -1;
						pointer++;
					}
					else if(c=='[') {
						if(arr[pointer]==0) s = pair[s];
					}
					else if(c==']') {
						if(arr[pointer]!=0) s = pair[s];
					}
					else if(c==',') {
						if(iidx==isize) arr[pointer] = 255;
						else arr[pointer] = input.charAt(iidx++);
					}
					s++;
					cnt++;
					if(s<csize&&maxidx<s) maxidx = s;
				}
				sb.append("Loops "+pair[maxidx]+" "+maxidx+"\n");
			}
		}
		System.out.print(sb);
	}
}
