import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine().trim());

        out.println("? 1");
        out.flush();
        long s = Long.parseLong(br.readLine().trim());

        long total=s+n;

        int left = 1;
        int right = 100000;
        while(left<right) {
            int mid = (left+right)/2;
            out.println("? "+mid);
            out.flush();
            long ans = Long.parseLong(br.readLine().trim());
            long ex =(long)mid*n-total;
            if(ans==ex) right = mid;
            else left = mid + 1;
        }
        out.println("! "+left);
        out.flush();
    }
}