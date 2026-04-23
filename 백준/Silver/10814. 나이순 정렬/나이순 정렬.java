import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 회원 수
        ArrayList<Member> members = new ArrayList<>();

        // 회원 정보 입력
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members.add(new Member(age, name));
        }

        // 나이순 정렬 (람다식 사용)
        members.sort((m1, m2) -> Integer.compare(m1.age, m2.age));

        // 출력
        members.forEach(member -> System.out.println(member.age + " " + member.name));

        sc.close();
    }
}
