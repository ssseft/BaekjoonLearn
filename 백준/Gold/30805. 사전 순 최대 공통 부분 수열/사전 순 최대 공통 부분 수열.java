import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i = 0;i<n;i++) A[i] = sc.nextInt();
		
		int m = sc.nextInt();
		int[] B = new int[m];
		for(int i = 0;i<m;i++) B[i] = sc.nextInt();
		
		List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i<n&&j<m){
            int v = -1;
            int curi = -1;
            int curj = -1;

            for(int k = 100;k>=1;k--) {
                int a = -1;
                int b = -1;

                for(int x = i;x<n;x++) {
                    if (A[x]==k) {
                    	a = x; 
                    	break; 
                    }
                }
                
                for(int y = j;y<m;y++) {
                    if (B[y]==k){
                    	b = y; 
                    	break;
                    }
                }
                
                if (a==-1||b==-1) continue;

                v = k;
                curi = a;
                curj = b;
                break;
            }
            if(v==-1) break;
            ans.add(v);
            i = curi+1;
            j = curj+1;
        }

        System.out.println(ans.size());
        for(int v : ans) System.out.print(v + " ");
	}
}
