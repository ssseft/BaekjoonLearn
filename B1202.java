package beakjun;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202 {
	static class stone implements Comparable<stone>{

		int weight, value;
		public stone(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
		@Override
		public int compareTo(stone s) {
			if(this.weight == s.weight) {
				return s.value - this.value;
			}
			return this.weight-s.weight;
		}
	}
	
	public static void main(String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		stone[] stones = new stone[n];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            stones[i] = new stone(M, V);
		}
		int[] C = new int[k]; //가방 최대 ㄴ수용무게
		for(int i =0; i<k;i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(C);
		Arrays.sort(stones);
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		long result = 0;
		
		for(int i=0,j=0;i<k;i++){
            while(j<n){
                if(C[i] >= stones[j].weight) {
                	q.add(stones[j].value);
                	j++;
                }
                else {
                	break;
                }
                
            }
            if(!q.isEmpty())
                result += q.poll();
        }
		System.out.print(result);
	}
}
