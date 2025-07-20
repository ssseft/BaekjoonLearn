package beakjoon1;
import java.io.*;

public class B2138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String start = br.readLine();
		String end = br.readLine();
		boolean[] co1 = new boolean[n];
		
		for(int i =0 ;i<n;i++) {
			if(start.charAt(i)==end.charAt(i)) {
				co1[i] = true;
			}
		}
		boolean[] co2 = co1.clone();
		
		int cnt1 = 0;
		//첫 촛불이 꺼진상태
		for(int i = 1; i<n-1;i++) {
			if(!co1[i-1]) {
				co1[i-1] = true;
				cnt1++;
				co1[i] = !co1[i];
				co1[i+1] = !co1[i+1];
			}
		}
		if(co1[n-2]==co1[n-1]) {
			if(!co1[n-2]) {
				cnt1++;
			}
		}
		else {
			cnt1 = -1;
		}
		int cnt2 = 1;
		//첫 촛불이 켜진상태
		co2[0] = !co2[0];
		co2[1] = !co2[1];
		for(int i = 1 ;i<n-1;i++) {
			if(!co2[i-1]) {
				co2[i-1] = true;
				cnt2++;
				co2[i] = !co2[i];
				co2[i+1] = !co2[i+1];
			}
		}
		if(co2[n-2]==co2[n-1]) {
			if(!co2[n-2]) {
				cnt2++;
			}
		}
		else {
			cnt2 = -1;
		}
		
		
		int result = -1;
		if(cnt1>=0&&cnt2>=0) {
			result = Math.min(cnt1, cnt2);
		}
		else {
			if(cnt1>=0) {
				result = cnt1;
			}
			else if(cnt2>=0) {
				result = cnt2;
			}
			else {
				result = -1;
			}
		}
		
		System.out.println(result);
	}
}