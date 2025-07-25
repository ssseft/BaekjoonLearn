package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1285 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] coin = new String[n];
		
		for(int i = 0;i<n;i++) {
			coin[i] = br.readLine();
		}
		
		int min = n*n;
		int hcount;
		
		for(int i = 0;i<(1<<n);i++) {
			int cnt = 0;
			for(int j = 0;j<n;j++) {
				hcount = 0;
				for(int k =0;k<n;k++) {
					if((i&(1<<k))!=0) {
						if(coin[k].charAt(j)=='H') hcount++;
					}
					else {
						if(coin[k].charAt(j)=='T') {
							hcount++;
						}
					}
				}
				cnt += Math.min(hcount, n-hcount);
			}
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}
}
