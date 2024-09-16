package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                    System.out.println(queue.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (A.equals("size")) {
                System.out.println(queue.size());
            } else if (A.equals("empty")) {
                if (!queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (A.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (A.equals("back")) {
                System.out.println(back);
            }

            N--;
        }
    }
}
