import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr = new char[n];
        char[] arr2 = new char[2*n];
        
        for(int i = 0;i<n;i++) 
        	arr[i] = st.nextToken().charAt(0);
        
        int s = 0;
        int[] pi = new int[n];
        for(int i = 1;i<n;i++) {
        	while(s>0&&arr[i]!=arr[s]) {
        		s = pi[s-1];
        	}
        	if(arr[i]==arr[s]) pi[i] = ++s;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
        	arr2[i] = st.nextToken().charAt(0);
        	arr2[i+n] = arr2[i];
        }
        
        int ans = 0;
        
        s = 0;
        for(int i = 0;i<2*n-1;i++) {
        	while(s>0&&arr2[i]!=arr[s]) {
        		s = pi[s-1];
        	}
        	if(arr2[i]==arr[s]) {
        		if(s==n-1) {
        			ans++;
        			s = pi[s];
        		}
        		else s++;
        	}
        }
        int g = gcd(ans, n);
        System.out.println((ans/g)+"/"+(n/g));
	}
	static int gcd(int a,int b) {
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
}
