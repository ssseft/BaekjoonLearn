import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String a = sc.next();
        sc.close();
        int count = 0;
        int n = a.length();
        for(int i =0; i<n; i++) {
            char letter = a.charAt(i);
            if(letter == 'c' && i<n-1) {
                if(a.charAt(i+1) == '=' || a.charAt(i+1) == '-') {
                    i++;
                }
            }
            else if(letter == 'd' && i <n-1) {
                if(i < n-2 && a.charAt(i+1) == 'z' && a.charAt(i+2) == '=') {
                    i+=2;
                } else if(a.charAt(i+1) == '-') {
                    i++;
                }
            }
            else if((letter =='l' || letter =='n') && i<n-1 && a.charAt(i+1) == 'j') {
                i++;
            }
            else if((letter == 's' || letter == 'z') && i<n-1 && a.charAt(i+1) == '=') {
                i++;
            }
            count++;
        }
        
        System.out.print(count);
    }
}
