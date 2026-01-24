import java.io.*;
import java.util.*;

public class Main {
    static int[] time;
    static int[] score;
    static int n,t,w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        time = new int[n];
        score = new int[n];
        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = t;
        int ans = -1;
        while(left<=right) {
            int mid = (left+right)>>1;
            if(cal(mid)) {
                right = mid-1;
                ans = mid;
            }
            else left = mid+1;
        }
        System.out.print(ans);
    }
    static boolean cal(int d) {
        if(t-d<0) return false;
        int[] dp = new int[t+1];
        for(int i = 0;i<n;i++) {
        	int c = time[i]-d;
        	if(c<0) c = 0;
            for(int j= t;j>=c;j--) {
                dp[j] = Math.max(dp[j], dp[j-c]+score[i]);
            }
        }
        return dp[t-d>0?t-d:0]>=w;
    }
}
