package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B5430 {
	public static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int a = 0; a < T; a++) {
            String words = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String rd = br.readLine().replaceAll("[\\[\\]]", "");
            StringTokenizer st = new StringTokenizer(rd, ",");
            deque = new ArrayDeque<>();
            boolean check =true;
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            for(int i =0; i<words.length(); i++) {
            	if(words.charAt(i) == 'R') {
            		reverse();
            	}
            	else {
            		if(deque.isEmpty()) {
            			System.out.println("error");
            			check = false;
            			break;
            		}
            		else {
            			deque.removeFirst();
            		}
            	}
            }
            if(check) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
            }
        }
    }

    public static void reverse() {
        Deque<Integer> d2 = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            d2.add(deque.pollLast());
        }
        while (!d2.isEmpty()) {
            deque.add(d2.pollFirst());
        }
    }
}
