package 백준.백준_13000_13999.백준_13904_과제_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_13904_과제_G3_100ms_list {
	
	static class Assignment {
		int deadline;
		int score;
		
		Assignment(int deadline, int score){
			this.deadline = deadline;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Assignment> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Assignment>() {
			@Override
			public int compare(Assignment a, Assignment b) {
				if(a.score != b.score) {
					return Integer.compare(b.score, a.score);
				}else {
					return Integer.compare(b.deadline, a.deadline);
				}
			}
		});
		
		Set<Integer> set = new HashSet<>();
		int result = 0;
		for(int i=0; i<N; i++) {
			Assignment assignment = list.get(i);
			int deadline = assignment.deadline;
			while(deadline>0) {
				if(!set.contains(deadline)) {
					result += assignment.score;
					set.add(deadline);
					break;
				}else {
					deadline--;
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
