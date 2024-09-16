package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        br.close();
        int sum = 0;

        for (int i = 0; i < a; i++) {
        	sum += Character.getNumericValue(b.charAt(i));
        }

        System.out.print(sum);
    }
}