import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        Set<Point> set = new HashSet<>();
        
        for(int i = 0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	set.add(new Point(x,y));
        }
        
        int cnt = 0;
        for(Point c : set) {
        	int x = c.x;
        	int y = c.y;
        	int cx = x+a;
        	int cy = y+b;
        	if(set.contains(new Point(x,cy))&&set.contains(new Point(cx,y))&&set.contains(new Point(cx,cy))) {
        		cnt++;
        	}
        }
        
        System.out.print(cnt);
	}
}
