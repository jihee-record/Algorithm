package SWEA.SWEA_Event.No1_프로젝트의견조율자임스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_No1_프로젝트의견조율자임스_이지희_106ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		for(int n=0; n<N; n++) {
			set.add(br.readLine());
		}
		
		for(int m=0; m<M; m++) {
			String key = br.readLine();
			if(set.contains(key)) {
				sb.append(key).append("\n");
				set.remove(key);
			}
		}
		
		if(set.size() == N) sb.append("NO!!");
		
		System.out.println(sb.toString());
		br.close();
	}

}
