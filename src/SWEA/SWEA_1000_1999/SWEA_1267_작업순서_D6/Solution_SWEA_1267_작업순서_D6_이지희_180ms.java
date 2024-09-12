package SWEA.SWEA_1000_1999.SWEA_1267_작업순서_D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1267_작업순서_D6_이지희_180ms {
	static class Vertex{
		int number;
		List<Vertex> after;
		
		Vertex(){}
		Vertex(int number){
			this.number = number;
			this.after = new LinkedList<>();
		}
	}

	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static Map<Integer, Vertex> map;
	static int[] degree; // 이전에 수행해야할 작업 수
	
	static void work() {
		Queue<Vertex> queue = new LinkedList<>();
		
		for(int i : map.keySet()) {
			if(degree[i] == 0) queue.add(map.get(i));
		}
		
		while(!queue.isEmpty()) {
			Vertex now = queue.poll();
			sb.append(now.number).append(" ");
			for(Vertex after : now.after) {
				degree[after.number]--; //now 작업을 수행했으므로 연결된 애들의 차수를 1 줄임
				if(degree[after.number] == 0) { //선행 작업이 다 끝났으면
					queue.add(after); // 다음 작업에 추가함
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1 ; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			degree = new int[V+1]; // 1부터
			map = new HashMap<>();
			
			for (int i = 1; i <= V; i++) {
	            map.put(i, new Vertex(i));
	        }
			
			st = new StringTokenizer(br.readLine());
			for(int e=0; e<E; e++) {
				int number = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				
				Vertex nowV = map.get(number);
				Vertex afterV = map.get(after);
				
				nowV.after.add(afterV);
				degree[afterV.number]++; //연결된 수
			}// for e 종료
			
			work();
			sb.append("\n");
		}// for t 종료
		
		System.out.println(sb.toString());
		br.close();
	}

}
