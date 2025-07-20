package beakjoon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P84512 {
	public static void main(String[] args) {
		System.out.print(solution("EIO"));
	}
	static public int solution(String word) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        String[] alp = new String[] {"A","E","I","O","U"};
        //1자리
        for(int i = 0;i<5;i++) {
        	list.add(alp[i]);
        }
        //2자리
        for(int i = 0;i<5;i++) {
        	for(int j = 0;j<5;j++) {
        		list.add(alp[i]+alp[j]);
        	}
        }
        //3자리
        for(int i = 0;i<5;i++) {
        	for(int j = 0;j<5;j++) {
        		for(int k =0 ;k<5;k++) {
            		list.add(alp[i]+alp[j]+alp[k]);
        		}
        	}
        }
        //4자리
        for(int i = 0;i<5;i++) {
        	for(int j = 0;j<5;j++) {
        		for(int k =0 ;k<5;k++) {
        			for(int l = 0;l<5;l++) {
                		list.add(alp[i]+alp[j]+alp[k]+alp[l]);	
        			}
        		}
        	}
        }
        //5자리
        for(int i = 0;i<5;i++) {
        	for(int j = 0;j<5;j++) {
        		for(int k =0 ;k<5;k++) {
        			for(int l = 0;l<5;l++) {
        				for(int m = 0;m<5;m++) {
                    		list.add(alp[i]+alp[j]+alp[k]+alp[l]+alp[m]);	
        				}
        			}
        		}
        	}
        }
        
        Collections.sort(list);
        for(int i = 0;i<list.size();i++) {
        	if(list.get(i).equals(word)) {
        		answer = i;
        		break;
        	}
        }
        return answer+1;
    }
}
