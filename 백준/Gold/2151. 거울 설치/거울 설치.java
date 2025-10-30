import java.util.*;
import java.io.*;

class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            int startx = 0;
            int starty = 0;
            int endx = 0;
            int endy = 0;
            boolean check = true;
            char[][] arr = new char[n][n];
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0;i<n;i++){
                String l = sc.nextLine();
                for(int j = 0;j<n;j++){
                    arr[i][j] = l.charAt(j);
                    if(arr[i][j]=='#'){
                        if(check){
                            startx = i;
                            starty = j;
                            check = false;
                            q.add(new int[]{i,j,0,0});
                            q.add(new int[]{i,j,0,1});
                            q.add(new int[]{i,j,0,2});
                            q.add(new int[]{i,j,0,3});
                        }
                        else{
                            endx = i;
                            endy = j;
                        }
                    }
                }
            }
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};
            int ans = Integer.MAX_VALUE;
            int[][][] min = new int[n][n][4];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    Arrays.fill(min[i][j],999);
                }
            }
            
            while(!q.isEmpty()){
                int[] c = q.poll();
                int x = c[0];
                int y = c[1];
                int cnt = c[2];
                int d = c[3];
                if(x==endx&&y==endy){
                    ans = Math.min(cnt,ans);
                }
                if(arr[x][y]=='!'){
                    for(int i = 0;i<4;i++){
                        int cx = x+dx[i];
                        int cy = y+dy[i];
                        if(cx>=0&&cy>=0&&cx<n&&cy<n){
                            if(arr[cx][cy]=='*') continue;
                            if(d==i&&min[cx][cy][i]>cnt){
                                q.add(new int[]{cx,cy,cnt,d});
                                min[cx][cy][d] = cnt;
                            }
                            else{
                                if(min[cx][cy][i]>cnt+1){
                                    q.add(new int[]{cx,cy,cnt+1,i});
                                    min[cx][cy][i] = cnt+1;
                                }
                                
                            }
                        }
                    }
                }
                else{
                    int cx = x+dx[d];
                    int cy = y+dy[d];
                    if(cx>=0&&cy>=0&&cx<n&&cy<n&&min[cx][cy][d]>cnt){
                        if(arr[cx][cy]=='*') continue;
                        q.add(new int[]{cx,cy,cnt,d});
                        min[cx][cy][d] = cnt;
                    }
                }
            }
        
            System.out.print(ans);
        
    }
}