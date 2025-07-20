package beakjoon1;

import java.io.*;
import java.util.*;

public class B32634 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());

        long[] diff=new long[n+2];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int L = t-k+1;
            if(L<1)L=1;
            int R=t;
            if(R>n)R=n;
            diff[L]++;
            diff[R+1]--;
        }
        int curr = 0;
        long sum = 0;
        long answer = 0;

        for(int t=1;t<=n;t++) {
            curr += diff[t];
            sum += curr;
            long r = (sum+t-1)/t;
            answer = Math.max(answer, r);
        }
        System.out.print(answer);
    }
}