import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int[] arr;
        int value;

        public Node(int[] arr, int value) {
            this.arr = arr;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortarr = arr.clone();
        Arrays.sort(sortarr);

        List<int[]>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new int[]{e, v});
            list[e].add(new int[]{s, v});
        }

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.value-b.value);

        q.add(new Node(arr, 0));

        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        map.put(Arrays.toString(arr), 0);

        while (!q.isEmpty()) {
            Node c = q.poll();
            if (Arrays.equals(c.arr, sortarr)) {
                min = c.value;
                break;
            }
            
            if(map.get(Arrays.toString(c.arr))<c.value) continue;

            for (int i = 1; i <= n; i++) {
            	for (int[] next : list[i]) {
                    int nextnode = next[0];
                    int nextvalue = next[1];
                    
                    int[] newarr = c.arr.clone();
                    int temp = newarr[i];
                    newarr[i] = newarr[nextnode];
                    newarr[nextnode] = temp;
                    
                    if(!map.containsKey(Arrays.toString(newarr))||map.get(Arrays.toString(newarr))>c.value+nextvalue) {
                    	q.add(new Node(newarr, c.value + nextvalue));
                    	map.put(Arrays.toString(newarr), c.value+nextvalue);
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}