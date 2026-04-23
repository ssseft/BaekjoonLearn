import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int k = sc.nextInt();
		
		List<int[]> list = new ArrayList<>();
		for(int i =0;i<t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new int[] {x,y});
		}
		int max = 0;
		int[] result = new int[2];
		for(int[] c : list) {
			int cx = c[0];
			int cy = c[1];
			for(int[] s : list) {
				int sx = s[0];
                int sy = s[1];
                int cnt = 0;
                int ix = Math.min(sx,cx);
                int iy = Math.max(sy,cy);
                if(ix<0) ix=0;
                if(ix>n-k) ix = n-k;
                if(iy<k) iy=k;
                if(iy>m) iy = m;
                for(int[] a : list){
                    if(ix<=a[0]&&ix+k+1>a[0]&&iy>=a[1]&&iy-k<=a[1]) cnt++;
                }
                if(max<cnt) {
				result[0] = ix;
				result[1] = iy;
				max = cnt;
    			}
			}
		}
		System.out.println(result[0]+" "+result[1]);
		System.out.print(max);
	}
}