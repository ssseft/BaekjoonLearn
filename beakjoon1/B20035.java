package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20035 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int xmax = -1;
		int ymax = -1;
		int xidx1 = 999999999;
		int xidx2 = 999999999;
		int yidx1 = 999999999;
		int yidx2 = 999999999;
		int xsum = 0;
		int ysum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			xsum += c;
			if(c>xmax) {
				xmax = c;
				xidx1 = i;
				xidx2 = 999999999;
			}
			else if(c==xmax) {
				xidx2 = i;
			}
		}
//		xsum += xidx1*(xfir);
//		xsum += (xidx2-xidx1-1)*xmax ;
		xsum += (m-1) * xmax;
		System.out.println(xsum);
		st = new StringTokenizer(br.readLine());
		int yfir = 0;
		int yend = 0;
		for(int i = 0;i<m;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(i==0) yfir = c;
			if(i==m-1) yend = c;
			ysum += c;
			if(ymax<c) {
				ymax = c;
				yidx1 = i;
				yidx2 = 999999999;
			}
			else if(c==ymax) {
				yidx2 = i;
			}
		}
		if(yidx2!=999999999) {
			ysum += (yidx2-yidx1)*(ymax);
		}
		else {
			ysum += (m-yidx1)*ymax;
		}
		System.out.println(ysum);
		ysum += (xidx1 - 1) * yfir;
		ysum += (n-xidx2) * yend;
		System.out.println(ysum);
		
	}
}
