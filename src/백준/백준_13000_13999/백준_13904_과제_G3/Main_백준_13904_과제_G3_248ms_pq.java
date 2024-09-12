package 백준.백준_13000_13999.백준_13904_과제_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_13904_과제_G3_248ms_pq {
	
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
		
		PriorityQueue<Assignment> pq = new PriorityQueue<>((a, b) -> {
			if(a.score != b.score) {
				return Integer.compare(b.score, a.score);
			}else {
				return Integer.compare(b.deadline, a.deadline);
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Set<Integer> set = new HashSet<>();
		int result = 0;
		while(!pq.isEmpty()) {
			Assignment assignment = pq.poll();
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
