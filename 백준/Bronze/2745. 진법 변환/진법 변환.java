import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String n = sc.next();
        int b = sc.nextInt();
        
        int result = convertToDecimal(n, b);
        
        System.out.print(result);
    }
    
    public static int convertToDecimal(String n, int b) {
        int decimal = Integer.parseInt(n, b);
        return decimal;
    }
    
}