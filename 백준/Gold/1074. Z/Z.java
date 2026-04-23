import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        recursion(size, r, c);
        System.out.print(count);
    }

    public static void recursion(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        int newsize = size/2;
        int size2 = newsize*newsize;
        
        if(r<newsize&&c<newsize) {
        	recursion(newsize,r,c);
        }
        else if(r>=newsize&&c<newsize) {
        	count+= size2*2;
        	recursion(newsize,r-newsize,c);
        }
        else if(r<newsize&&c>=newsize) {
        	count+= size2;
        	recursion(newsize,r,c-newsize);
        }
        else {
        	count+=size2*3;
        	recursion(newsize,r-newsize,c-newsize);
        }
    }
}