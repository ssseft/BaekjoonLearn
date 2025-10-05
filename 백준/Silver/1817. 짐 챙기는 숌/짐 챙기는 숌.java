import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n==0) {
        	System.out.print(0);
        	return;
        }
        
        st = new StringTokenizer(br.readLine());
        
        
        int cnt = 0;
        int w = 0;
        for(int i = 0;i<n;i++) {
        	int c = Integer.parseInt(st.nextToken());
        	
        	if(w+c>m){
        		cnt++;
        		w=c;
        	}
        	else {
        		w+=c;
        	}
        }
        if(w!=0) cnt++;
        System.out.println(cnt);
	}
}
