package 백준.백준_21000_21999.백준_21939_문제추천시스템Version1_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_21939_문제추천시스템Version1_G4_468ms {
	static class Problem {
		int p, l;
		Problem(int p, int l){this.p = p; this.l = l;}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 초기 추천 문제 리스트 수
		
		HashMap<Integer, Integer> pMap = new HashMap<>();
		
		PriorityQueue<Problem> easyPQ = new PriorityQueue<>((a, b) -> {
			if(a.l == b.l) return Integer.compare(a.p, b.p);
			else return Integer.compare(a.l, b.l);
		});
		
		PriorityQueue<Problem> hardPQ = new PriorityQueue<>((a, b) -> {
			if(a.l == b.l) return Integer.compare(b.p, a.p);
			else return Integer.compare(b.l, a.l);
		});
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			Problem p = new Problem(P, L);
			easyPQ.add(p);
			hardPQ.add(p);
			
			pMap.put(P, L);
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			if(command.equals("recommend")) {
				String order = st.nextToken(); // 1 or -1
				
				if(order.equals("1")){
					while(true) {
						Problem pro = hardPQ.poll();
						if(pMap.containsKey(pro.p)) { 
							if(pMap.get(pro.p) != pro.l) {
								continue;
							}else {
								sb.append(pro.p).append('\n');
								hardPQ.add(pro);
								break;
							}
						}
					}
				}
				
				else { // if(order.equals("-1"))
					while(true) {
						Problem pro = easyPQ.poll();
						if(pMap.containsKey(pro.p)) { 
							if(pMap.get(pro.p) != pro.l) {
								continue;
							}else {
								sb.append(pro.p).append('\n');
								easyPQ.add(pro);
								break;
							}
						}
					}
				}
			}
			
			else if(command.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				
				Problem p = new Problem(P, L);
				easyPQ.add(p);
				hardPQ.add(p);
				
				pMap.put(P, L);
			}
			
			else { // if (command.equals("solved")) 
				int P = Integer.parseInt(st.nextToken());
				pMap.remove(P);
			}
			
		}
		
		
		
		System.out.println(sb);
		br.close();
	}

}
