import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    String line = sc.next();
	    boolean[] use = new boolean[n+1];
	    int cnt = 0;
	    for(int i = 0;i<n;i++) {
	    	char c = line.charAt(i);
	    	if(c=='S') {
	    		if(!use[i]) {
	    			use[i] = true;
	    			cnt++;
	    		}
	    		else if(!use[i+1]) {
	    			use[i+1] = true;
	    			cnt++;
	    		}
	    	}
	    	else {
	    		if(!use[i]) {
	    			use[i] = true;
	    			cnt++;
	    		}
	    		i++;
	    		if(!use[i+1]) {
	    			use[i+1] = true;
	    			cnt++;
	    		}
	    	}
	    }
	    System.out.print(cnt);
	}
}
