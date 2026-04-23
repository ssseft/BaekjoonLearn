import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int a = 0; a < t; a++) {
            String words = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String rd = br.readLine().replaceAll("[\\[\\]]", "");
            StringTokenizer st = new StringTokenizer(rd, ",");
            deque = new ArrayDeque<>();
            boolean check =true;
            boolean front = true;
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            for(int i =0; i<words.length(); i++) {
            	if(words.charAt(i) == 'R') {
            		if(!deque.isEmpty()) {
            			front = !front;
            		}
            	}
            	else {
            		if(deque.isEmpty()) {
            			System.out.println("error");
            			check = false;
            			break;
            		}
            		else {
            			if(front) {
            				deque.removeFirst();
            			}
            			else {
            				deque.removeLast();
            			}
            		}
            	}
            }
            if(check) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!deque.isEmpty()) {
                if(front) {
                	sb.append(deque.pollFirst());
                	if (!deque.isEmpty()) {
                		sb.append(",");
                	}
                }
                else {
                	sb.append(deque.pollLast());
                	if(!deque.isEmpty()) {
                		sb.append(",");
                	}
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
            }
        }
    }
}
