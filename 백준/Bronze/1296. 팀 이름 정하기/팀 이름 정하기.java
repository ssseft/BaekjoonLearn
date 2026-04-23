import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String yeondu = br.readLine();
        int[] LOVE = new int[4];

        LOVE[0] = yeondu.length() - yeondu.replace("L", "").length();
        LOVE[1] = yeondu.length() - yeondu.replace("O", "").length();
        LOVE[2] = yeondu.length() - yeondu.replace("V", "").length();
        LOVE[3] = yeondu.length() - yeondu.replace("E", "").length();

        int n = Integer.parseInt(br.readLine());
        double max = -1;
        String winner = "";
        for(int i = 0; i<n; i++){
            int[] TEAM = new int[4];
            String team = br.readLine();
            TEAM[0] = LOVE[0] + team.length() - team.replace("L", "").length();
            TEAM[1] = LOVE[1] + team.length() - team.replace("O", "").length();
            TEAM[2] = LOVE[2] + team.length() - team.replace("V", "").length();
            TEAM[3] = LOVE[3] + team.length() - team.replace("E", "").length();

            double prob = ((TEAM[0]+TEAM[1]) * (TEAM[0]+TEAM[2]) * (TEAM[0]+TEAM[3])
            * (TEAM[1]+TEAM[2]) * (TEAM[1]+TEAM[3]) * (TEAM[2]+TEAM[3]))%100;

            if(max<prob){
                max = prob; winner = team;
            } else if (max == prob){
                String[] winners = new String[2];
                winners[0] = winner; winners[1] = team;
                Arrays.sort(winners);
                winner = winners[0];
            }
        }
        System.out.println(winner);
    }
}