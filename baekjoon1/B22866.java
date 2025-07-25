package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B22866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		
		Stack<int[]> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		List<Integer> bdnum = new ArrayList<>();
		
		
		for(int i = 0;i<n;i++) {
			int[] c = {list.get(i),i+1};
			while(!stack.isEmpty()&&stack.peek()[0]<=c[0]) {
				stack.pop();
			}
			result.add(stack.size());
			if(!stack.isEmpty()) {
				bdnum.add(stack.peek()[1]);
			}
			else {
				bdnum.add(0);
			}
			stack.push(c);
			
		}
		
		stack.clear();
		
		for(int i = n-1;i>=0;i--) {
			int[] c = {list.get(i),i+1};
			while(!stack.isEmpty()&&stack.peek()[0]<=c[0]) {
				stack.pop();
			}
			int s = result.get(i);
			result.set(i, s+stack.size());
			if(!stack.isEmpty()) {
				int right= stack.peek()[1];
				int left = bdnum.get(i);
				if(left==0)bdnum.set(i, right);
				else {
					int a = (-1)*(left-(i+1));
					int b = right-(i+1);
					if(b<a) {
						bdnum.set(i, right);
					}
				}
			}
			stack.push(c);
		}
		
		for(int i = 0;i<n;i++) {
			int c = result.get(i);
			if(c==0) {
				sb.append(result.get(i)+"\n");
			}
			else {
				sb.append(result.get(i)+" "+bdnum.get(i)+"\n");
			}
		}
		
		System.out.print(sb.toString().trim());
		
	}
}
