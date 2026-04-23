import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s= Integer.parseInt(st.nextToken());
		int p= Integer.parseInt(st.nextToken());
		
		String line = br.readLine();
		
		char[] arr = new char[] {'A','C','G','T'};
		
		st = new StringTokenizer(br.readLine());
		int[] poss = new int[4];
		for(int i = 0;i<4;i++) {
			poss[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] nums = new int[4];
		int cnt = 0;
		for(int i = 0;i<p;i++) {
			for(int j= 0;j<4;j++) {
				if(line.charAt(i)==arr[j]) {
					nums[j]++;
					break;
				}
			}
		}
		if(have(poss,nums)) cnt++;
		
		for(int i = 0;i<s-p;i++) {
			char c = line.charAt(i);
			for(int j = 0;j<4;j++) {
				if(c==arr[j]) {
					nums[j]--;
					break;
				}
			}
			char add = line.charAt(i+p);
			for(int j = 0;j<4;j++) {
				if(add==arr[j]) {
					nums[j]++;
					break;
				}
			}
			if(have(poss,nums)) cnt++;
		}
		
		System.out.print(cnt);
	}
	static boolean have(int[] poss, int[] nums) {
		for(int i = 0;i<4;i++) {
			if(poss[i]>nums[i]) return false;
		}
		return true;
	}
}