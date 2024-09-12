package 백준.백준_1000_1999.백준_1354_무한수열2_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_1354_무한수열_G5_4936ms {
	//n, An
	static HashMap<Long, Long> sequence = new HashMap<>();
	public static long calculate(long N, int P, int Q, int X, int Y) {
		if (N <= 0) return 1;
		if (sequence.containsKey(N)) return sequence.get(N);
		
		// (n/p, n/q) : 소수점을 버리고 반환 하므로 가우스의 역할
		long result = calculate((N/P)-X, P, Q, X, Y) + calculate((N/Q)-Y, P, Q, X, Y);
		sequence.put(N, result);
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long N = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		System.out.println(calculate(N, P, Q, X, Y));
		br.close();
	}
}