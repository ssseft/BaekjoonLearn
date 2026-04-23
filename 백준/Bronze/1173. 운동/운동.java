import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());   // 시간
		int m = Integer.parseInt(st.nextToken());   // 초기 맥박
		int M = Integer.parseInt(st.nextToken());   // 최대 맥박    
		int T = Integer.parseInt(st.nextToken());   // 맥박 증가
		int R = Integer.parseInt(st.nextToken());   // 맥박 감소
        
        int cnt = 0;    // 필요한 시간
        int cnt2 = 0;   // N분 확인
        int m2 = m;     // 최소 맥박
        
        while(cnt2 != N){
            
            if(m + T <= M){
                m += T;
                cnt2++;
            }else{
                m -= R;
                if(m < m2){
                    m = m2;
                }
                
            }   
            cnt++;
            if((m + T > M) && (m == m2)){
                break;
            }
        }
        
        if(cnt2 != N){
            System.out.print(-1);
        }else{
            System.out.print(cnt);
        }
        
	}
	
}