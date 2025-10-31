import java.io.*;

public class Main {
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static char[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0;i<n;i++) {
            String word = br.readLine();
            m = word.length();
            arr = new int[26];
            ans = new char[m];
            for(int j = 0;j<m;j++) arr[word.charAt(j)-'a']++;
            recur(0);
        }
        
        System.out.print(sb);
    }
    static void recur(int cnt) {
        if(cnt==m) {
            sb.append(new String(ans)+"\n");
            return;
        }
        
        for(int j = 0;j<26;j++) {
            if(arr[j]>0) {
                arr[j]--;
                ans[cnt] = (char)(j+'a');
                recur(cnt+1);
            	arr[j]++;
            }
        }
    }
}
