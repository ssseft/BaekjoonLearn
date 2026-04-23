import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            maxHeap.offer(num);

            if (i==0) {
                sb.append(maxHeap.peek()).append("\n");
            } 
            else if (i==1) {
                minHeap.offer(maxHeap.poll());
                sb.append(maxHeap.peek()).append("\n");
            } 
            else {
                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeap.poll());
                }
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                }
                sb.append(maxHeap.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
