package SWEA.SWEA_Event.No2_SSAFY에간임스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_No2_SSAFY에간임스_189ms_pq {
	static class Type {
		String skill;
		int order;
		public Type(String skill, int order){
			this.skill = skill;
			this.order = order;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Type> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1.order != o2.order) return o1.order - o2.order;
			else return o1.skill.compareTo(o2.skill);
		});
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Type(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll().skill).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
