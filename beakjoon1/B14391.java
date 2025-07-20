package beakjoon1;

import java.util.*;

public class B14391 {
    static int N, M;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }
        sc.close();
        
        int totalcase = (int)Math.pow(2, N*M);
        int max = 0;
        for(int i = 0;i<totalcase;i++) {
        	max = Math.max(max, cal(i));
        }
        
        System.out.print(max);
        
    }
    static int cal(int bit) {
    	int sum = 0;
    	
    	for(int i = 0;i<N;i++) {
    		int rowsum = 0;
    		for(int j = 0;j<M;j++) {
    			if((bit&(1<<i*M+j))!=0) {
    				rowsum = rowsum*10+grid[i][j];
    			}
    			else {
    				sum+= rowsum;
    				rowsum = 0;
    			}
    		}
    		sum += rowsum;
    	}
    	
    	for(int i = 0;i<M;i++) {
    		int colsum = 0;
    		for(int j = 0;j<N;j++) {
    			if((bit&(1<<j*M+i))==0) {
    				colsum = colsum*10+grid[j][i];
    			}
    			else {
    				sum+=colsum;
    				colsum = 0;
    			}
    		}
    		sum+= colsum;
    	}
    	return sum;
    }
}
