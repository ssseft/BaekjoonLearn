import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int one = 0;
        int zero = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]=='1') one++;
            else zero++;
        }
        one/=2;
        zero/=2;
        for(int i = 0;i<arr.length;i++){
            if(one==0) break;
            if(arr[i]=='1'){
                arr[i] = 'a';
                one--; 
            }
        }

        for(int i = arr.length-1;i>=0;i--){
            if(zero==0) break;
            if(arr[i]=='0'){
                arr[i] = 'a';
                zero--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char d : arr){
            if(d=='a') continue;
            sb.append(d);
        }
        System.out.print(sb);
    }
}