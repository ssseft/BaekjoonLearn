package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B7490 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ' ' =32 '+' = 43, '-' = 45
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			List<Character> list = new ArrayList<>();
			recursion(1,num,list);
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
	public static int cal(int a,int b,char c) {
		if(c==' ') {
			return a*10+b;
		}
		else if(c=='+') {
			return a+b;
		}
		else {
			return a-b;
		}
	}
	public static void recursion(int num,int cnt,List<Character> list) {
		if(num==cnt) {
			List<Integer> nums = new ArrayList<>();
			List<Character> list2 = new ArrayList<>(list);
			
			
			return;
		}
		for(int i = 0; i<3;i++) {
			if(i==0) {
				list.add(' ');
				recursion(num+1,cnt,list);
			}
			else if(i==1) {
				list.add('+');
				recursion(num+1,cnt,list);
			}
			else {
				list.add('-');
				recursion(num+1,cnt,list);
			}
			list.remove(list.size()-1);
		}
	}
}
