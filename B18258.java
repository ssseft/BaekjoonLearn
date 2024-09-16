package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int back = -1;
        while (N > 0) {
            String[] input = br.readLine().split(" ");
            String A = input[0];

            if (A.equals("push")) {
                int num = Integer.parseInt(input[1]);
                queue.add(num);
                back = num;
            } else if (A.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if (A.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (A.equals("empty")) {
                if (!queue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(1).append('\n');
                }
            } else if (A.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if (A.equals("back")) {
                sb.append(back).append('\n');
            }

            N--;
        }
        System.out.print(sb.toString());
    }
}
