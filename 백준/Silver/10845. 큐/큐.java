import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        while (N > 0) {
            String[] input = br.readLine().split(" ");
            String A = input[0];

            if (A.equals("push")) {
                int num = Integer.parseInt(input[1]);
                queue.add(num);
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
                if (!queue.isEmpty()) {
                    int back = 0;
                    for (int i = 0; i < queue.size(); i++) {
                        back = queue.poll();
                        queue.add(back);
                    }
                    System.out.println(back);
                } else {
                    System.out.println(-1);
                }
            }

            N--;
        }
    }
}
