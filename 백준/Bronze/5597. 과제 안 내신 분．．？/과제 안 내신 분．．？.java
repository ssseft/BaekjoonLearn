import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> students = new HashSet<>();

        for(int i = 1; i <= 30; i++) {
            students.add(i);
        }
        for (int i = 0; i < 28; i++) {
            students.remove(sc.nextInt());
        }
        for (int student : students) {
            System.out.println(student);
        }
    }
}