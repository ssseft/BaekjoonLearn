import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextLine();
        }
        Set<String> set = new HashSet<>();
        for(int i = 1;i<=arr[0].length();i++){
            boolean ch = false;
            for(int j = 0;j<n;j++){
                String c = arr[j].substring(arr[j].length()-i,arr[j].length());
                if(set.contains(c))ch = true;
                else set.add(c);
            }
            if(!ch){
                System.out.print(i);
                return;
            }
        }
        
    }
}