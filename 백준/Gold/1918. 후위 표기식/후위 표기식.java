import java.util.Scanner;

public class Main{
	static int n;
	static int[] dep;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		n = l.length();
		dep = new int[n];
		
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			char c = l.charAt(i);
			if(c=='(') cnt++;
			dep[i] = cnt;
			if(c==')') cnt--;
		}
		
		System.out.print(recur(l,0,n-1));
	}
	static String recur(String s, int Lidx, int Ridx) {
		
		//괄호처리
		if(s.charAt(Lidx) == '(') {
		    int base = dep[Lidx];
		    int match = 0;
		    for(int k = Lidx+1; k<=Ridx;k++) {
		        if(s.charAt(k)==')'&&dep[k]==base){
		        	match = k; 
		        	break; 
		        }
		    }
		    if(match==Ridx) return recur(s, Lidx+1,Ridx-1);
		}
		
		int base = 100;
	    for(int i = Lidx; i <= Ridx; i++) base = Math.min(base, dep[i]);
	    
		for(int i = Ridx-1;i>=Lidx;i--) {
			if(dep[i]==base) {
				char c = s.charAt(i);
				if(c=='+'||c=='-') {
					return recur(s,Lidx,i-1)+recur(s,i+1,Ridx)+c;
				}
			}
		}
		
		for(int i = Ridx-1;i>=Lidx;i--) {
			if(dep[i]==base) {
				char c = s.charAt(i);
				if(c=='*'||c=='/') {
					return recur(s,Lidx,i-1)+recur(s,i+1,Ridx)+c;
				}
			}
		}
		
		return String.valueOf(s.charAt(Lidx));
	}
}