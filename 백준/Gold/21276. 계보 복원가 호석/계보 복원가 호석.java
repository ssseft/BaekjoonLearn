import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        String[] names = br.readLine().split(" ");

        Arrays.sort(names);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(names[i], i);
        }
        List<Integer>[] children = new ArrayList[n];
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i<n;i++) {
        	graph[i] = new ArrayList<>();
        	children[i] = new ArrayList<>();
        }

        int[] degree = new int[n];
        int m = Integer.parseInt(br.readLine());
        
        for(int i = 0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int end = map.get(st.nextToken());
        	int start = map.get(st.nextToken());
        	
        	graph[start].add(end);
        	degree[end]++;
        }
        
        List<Integer> root = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0;i<n;i++) {
        	if(degree[i]==0) {
        		root.add(i);
        		q.add(i);
        	}
        }
        
        sb.append(root.size()+"\n");
        for(int i : root) {
        	sb.append(names[i]+" ");
        }
        sb.append("\n");
        
        while(!q.isEmpty()) {
        	int c = q.poll();
        	for(int next : graph[c]) {
        		degree[next]--;
        		if(degree[next]==0) {
        			children[c].add(next);
        			q.add(next);
        		}
        	}
        }
        
        for(int i = 0;i<n;i++) {
        	List<String> list = new ArrayList<>();
        	for(int c : children[i]) {
        		list.add(names[c]);
        	}
        	Collections.sort(list);
        	sb.append(names[i]+" "+list.size());
        	for(String c : list) {
        		sb.append(" "+c);
        	}
        	sb.append("\n");
        }
        System.out.print(sb);
    }
}
