import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        int left = 1;
        int right = n;
        int max = 1;
        
        while(left<=right) {
            int mid = (left+right)/2;
            int cur = mid-1+mid*l;
            if(cur<=c) {
            	left = mid+1;
            	max = mid;
            }
            else right = mid-1;
        }
        if(max%13==0) max--;
        
        int total = 0;
        while(n>0) {
        	if(n<max&&n%13==0) {
        		n+=2;
        		continue;
        	}
        	n -= max;
        	total++;
        }
        		
        System.out.print(total);
    }
}