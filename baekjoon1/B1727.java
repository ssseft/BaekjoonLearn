package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1727 {
    static int n;
    static int m;
    static int minSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
       
        int[] arr = new int[n];
        int[] arr2 = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<m;i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        Arrays.sort(arr2);
        
        int[] longarr, shortarr;
        if (n > m) {
            longarr = arr;
            shortarr = arr2;
        } else {
            longarr = arr2;
            shortarr = arr;
        }
        
        int lo = longarr.length;
        int sh = shortarr.length;
        
        int[][] dp = new int[sh+1][lo+1];
        
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<dp[0].length; i++) {
            dp[0][i] = 0;
        }
        
        for(int i=1; i<=sh; i++) {
            for(int j=1; j<=lo; j++) {
                if(i == j) {
                    dp[i][j] = Math.abs(shortarr[i-1]-longarr[j-1]) + dp[i-1][j-1];
                } else if(i > j) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]+Math.abs(shortarr[i-1]-longarr[j-1]));
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j-1]+Math.abs(shortarr[i-1]-longarr[j-1]));
                }
            }
        }
        System.out.println(dp[sh][lo]);

    }
}
