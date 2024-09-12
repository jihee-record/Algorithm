package 백준.백준_1000_1999.백준_1351_무한수열_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_1351_무한수열_G5_84ms {
	static HashMap<Long, Long> sequence = new HashMap<>();
	
	public static long calculate(long N, int P, int Q) {
		if (N == 0) return 1;
		if (sequence.containsKey(N)) return sequence.get(N);
		
		long result = calculate(N/P, P, Q) + calculate(N/Q, P, Q);
		sequence.put(N, result);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long N = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		System.out.println(calculate(N, P, Q));
		br.close();
	}
}
