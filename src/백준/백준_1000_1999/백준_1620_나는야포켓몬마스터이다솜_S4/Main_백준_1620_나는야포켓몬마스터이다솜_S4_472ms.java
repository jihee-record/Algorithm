package 백준.백준_1000_1999.백준_1620_나는야포켓몬마스터이다솜_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_1620_나는야포켓몬마스터이다솜_S4_472ms {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 포켓몬 수
		int M = Integer.parseInt(st.nextToken()); // 문제 수
		
		HashMap<String, Integer> nameToNo = new HashMap<>();
		HashMap<Integer, String> noToName = new HashMap<>();
		
		for(int n=1; n<=N; n++) {
			String name = br.readLine();
			nameToNo.put(name, n);
			noToName.put(n, name);
		}
		
		for(int m=0; m<M; m++) {
			String input = br.readLine();
			if(nameToNo.containsKey(input)) sb.append(nameToNo.get(input));
			else sb.append(noToName.get(Integer.parseInt(input)));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
		
	}

}
