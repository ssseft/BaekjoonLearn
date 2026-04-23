import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb= new StringBuilder();
    	int[] arr = new int[n];
    	for(int i = 0 ;i<n;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int[] dp = new int[n];
    	ArrayList<Integer> list = new ArrayList<>();
    	list.add(Integer.MIN_VALUE);
    	for(int i = 0; i<n;i++) {
    		int left = 1;
    		int right = list.size()-1;
    		if(arr[i]>list.get(list.size()-1)) {
    			list.add(arr[i]);
    			dp[i] = list.size()-1;
    		}
    		else {
    			while(left<right) {
    				int mid = (left+right)>>1;
    				if(list.get(mid) >=arr[i]) {
    					right = mid;
    				}
    				else {
    					left = mid+1;
    				}
    			}
    			list.set(right, arr[i]);
				dp[i] = right;
    		}
    	}
    	int count = list.size() - 1;
    	String[] result = new String[list.size() - 1]; 
    	int resultIndex = result.length - 1;
    	for (int i = n - 1; i >= 0; i--) {
    	    if (dp[i] == count) {
    	        result[resultIndex--] = arr[i] + " ";
    	        count--;
    	        if (count < 0) {
    	            break;
    	        }
    	    }
    	}
    	for (int j = 0; j < result.length; j++) {
    	    sb.append(result[j]);
    	}
    	
    	sb.insert(0, list.size()-1+"\n");
    	bw.write(sb.toString().trim());
    	bw.close();
        br.close();
    }
}