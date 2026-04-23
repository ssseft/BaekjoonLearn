import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startmonth = Integer.parseInt(st.nextToken());
            int startday = Integer.parseInt(st.nextToken());
            int endmonth = Integer.parseInt(st.nextToken());
            int endday = Integer.parseInt(st.nextToken());
            list.add(new int[]{startmonth, startday, endmonth, endday});
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int currentmonth = 3;
        int currentday = 1;
        int maxmonth = 0;
        int maxday = 0;
        int result = 0;
        boolean check = false;
        for (int i = 0; i < n; i++) {
            int days[] = list.get(i);
            int startmonth = days[0];
            int startday = days[1];
            int endmonth = days[2];
            int endday = days[3];
            
            
            if (startmonth < currentmonth || (startmonth == currentmonth && startday <= currentday)) {
                if (maxmonth < endmonth || (maxmonth == endmonth && maxday < endday)) {
                    maxmonth = endmonth;
                    maxday = endday;
                    check = true;
                }
            } else {
            	if(!check) {
            		System.out.print(0);
            		return;
            	}
                result++;
                currentmonth = maxmonth;
                currentday = maxday;
                check = false;
                i--;
                if (currentmonth>11) {
                    break;
                }
            }
        }

        if (check) {
            result++;
            currentmonth = maxmonth;
            currentday = maxday;
        }

        if (currentmonth>11) {
            System.out.print(result);
        } else {
            System.out.print(0);
        }
    }
}
