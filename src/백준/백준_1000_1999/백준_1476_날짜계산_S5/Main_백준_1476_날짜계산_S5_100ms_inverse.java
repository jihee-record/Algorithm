package 백준.백준_1000_1999.백준_1476_날짜계산_S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 역원 써먹기
public class Main_백준_1476_날짜계산_S5_100ms_inverse {
	
	// a의 mod m에 대한 역원
	// m : 15, 28, 19 (쌍마다 gcd = 1)
	// (28*19)^-1 = 13 mod 15 
	// (15*19)^-1 = 17 mod 28 
	// (15*28)^-1 = 10 mod 19 
//	static int modInverse(int a, int m) {
//		int m0 = m;
//        int x0 = 0, x1 = 1;
//
//        if (m == 1) return 0;
//
//        while (a > 1) {
//            int q = a / m;
//            int t = m;
//
//            m = a % m;
//            a = t;
//            t = x0;
//
//            x0 = x1 - q * x0;
//            x1 = t;
//        }
//
//        if (x1 < 0) x1 += m0;
//        return x1;
//	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken()) % 15;
		int s = Integer.parseInt(st.nextToken()) % 28;
		int m = Integer.parseInt(st.nextToken()) % 19;

		int result = 0;
		
		result += (e * 28 * 19 * 13);
		result += (s * 15 * 19 * 17);
		result += (m * 15 * 28 * 10);
		
		result %= 7980;
		
		System.out.println(result == 0? 7980 : result); // 15 * 28 * 19
		br.close();
		
	}

}
