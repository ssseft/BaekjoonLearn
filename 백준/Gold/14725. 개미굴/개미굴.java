import java.io.*;
import java.util.*;

public class Main {
	static class node{
		Map<String,node> child = new HashMap<>();
		boolean end;
	}
	static class trie{
		node root = new node();
		
		void insert(StringTokenizer word) {
			node node = root;
			int size = word.countTokens();
			
			for(int i = 0;i<size;i++) {
				String c = word.nextToken();
				node = node.child.computeIfAbsent(c, key->new node());
			}
			node.end = true;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        trie t = new trie();
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int m = Integer.parseInt(st.nextToken());
        	
        	t.insert(st);
        }
        
        print(t.root,"");
        System.out.print(sb);
	}
	static void print(node c,String s) {
		List<String> list = new ArrayList<>(c.child.keySet());
		Collections.sort(list);
		
		for(String str : list) {
			sb.append(s+str+"\n");
			print(c.child.get(str),s+"--");
		}
		
	}
}
