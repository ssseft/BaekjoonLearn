package beakjun;
import java.io.*;

public class B1992 {
	static String[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new String[n];
		for(int i = 0; i<n;i++) {
			arr[i] = br.readLine();
		}
		System.out.print(conquer(n,0,0));
		
	}
	static String conquer(int size,int x, int y) {
		if(size == 1) {
			return String.valueOf(arr[x].charAt(y));
		}
		int newsize = size/2;
		
		String st1 = conquer(newsize,x,y);
		String st2 = conquer(newsize,x,y+newsize);
		String st3 = conquer(newsize,x+newsize,y);
		String st4 = conquer(newsize,x+newsize,y+newsize);
		
		return check(st1,st2,st3,st4);
		
	}
	static String check(String st1, String st2, String st3, String st4) {
		if (st1.length() == 1 && st1.equals(st2) && st1.equals(st3) && st1.equals(st4)) {
	        return st1;
	    }
		else {
			return "("+st1+st2+st3+st4+")";
		}
	}
}
