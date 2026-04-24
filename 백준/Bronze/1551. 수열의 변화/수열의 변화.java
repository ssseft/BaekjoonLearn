import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] arr = str.split(",");
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) list.add(arr[i]);

        for(int i=0; i<K; i++) {
            ArrayList<String> result = solution(list);
            list = result;
        }
        for(int i=0; i<list.size(); i++) {
            if(i==list.size()-1)
                System.out.println(list.get(i));
            else
                System.out.print(list.get(i)+",");
        }
    }
    public static ArrayList<String> solution(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<list.size()-1; i++) {
            result.add(Integer.toString(Integer.parseInt(list.get(i+1))-Integer.parseInt(list.get(i))));
        }
        return result;
    }
}