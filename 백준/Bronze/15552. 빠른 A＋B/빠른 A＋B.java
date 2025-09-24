import java.io.*;
import java.util.*;
class Main{
	public static void main(String[] a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0;i<t;i++) {
        	st = new StringTokenizer(br.readLine());
        	sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
        }
        System.out.println(sb);
	}
}
