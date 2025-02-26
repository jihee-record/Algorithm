package SWEA.SWEA_25SSAFY프로연습.no1_두수의곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			// 고정
			// r1:x, r2:y, r3:1, r4:x+y, r5:(x+y)^k, r6:x^k, r7:y^k, r8 :x^k+y^k
			sb.append("+ 1 2 4\n^ 4 5\n^ 1 6\n^ 2 7\n+ 6 7 8\n");
			
			                                                                  
			
			
		}
		
		
		System.out.println(sb.toString());
		System.out.println(Integer.toBinaryString(1000000001-2));
		br.close();
	}
	
	// k=2
	static void operation2(StringBuilder sb, int P) {
		String p_1 = Integer.toBinaryString(P-1); // p-1을 2진법으로 전환 
		
		int p_1_length = p_1.length() - 1; // sigma : 2^a -> 가장 큰 a 값  (ex: 11001 -> a=4) : length -1
		
		// r8 : (x^2 + y^2)
		// P-1의 역원 이용 => -(x^2 + y^2) = (p-1)(x^2 + y^2) 
		// 각각의 자리에 (2^i)*(x^2 + y^2)
		getBinaryPlus(sb, p_1_length, p_1);
		
		// 8번에 저장된 것 부터 시작
		// 작은 자리 + 큰 자리 => 큰 자리에 저장
		// 가장 작은 자리부터 차근 차근 더해가며 마지막 자리에는 아래 
		// r(p_1_lenght + 8) = (p-1)(x^2 + y^2) 
		// r(p_1_length) 에는 (p-1)(x^2 + y^2) 이 저장되어 있음
		// r(5) : (x+y)^2
		// => r(9) = ((x+y)^2) + ((p-1)(x^2 + y^2))
		// 모두 사용완료되었으므로 R9번에 덮어 씌움
		
		// 자 이제 2의 역원 2^(-1) = 2^(p-2)를 구해야한다. 
		// p-2를 2진법으로 변환하여 ^ 연산을 이용하고자 한다
		String p_2 = Integer.toBinaryString(P-2);
		
		int p_2_length = p_2.length() - 1; 
		
		
		// r(10) : 2
		// 각각의 자리에 2^(2^i)
		for(int i = 10 ; i < p_2_length + 10 ; i++) {
			sb.append("^ ").append(i).append(" ").append(i+1).append("\n");
		}
		  
		// r(p_2_length + 10) = 2^(2^(p-2))
		// p-2의 2진법에 따라 2^a + 2^b + 2^c , 2^(2^a+2^b+2^c) = 2^(2^a) * 2^(2^b) * 2^(2^c) > 덧셈 연산 이용
		// 연산 횟수를 줄이기 위해 storage를 가장 큰 수부터 진행
		int storage = p_2_length + 10;
		for(int i = p_2_length + 9 ; i > 10; i--) {
			
		}
		
		
		
	}
	
	// ((x+y)^k) -(x^k + y^k)
	// ((x+y)^k) + ((p-1)(x^k + y^k)) : 분자 고정
	static void getBinaryPlus(StringBuilder sb, int end, String binaryStr) {
		for(int i = 8; i < end + 8 ; i++) {
			sb.append("+ ").append(i).append(" " ).append(i).append(" ").append(i+1).append("\n");
		}
		
		int storage = 0; // 8번에 저장된 것 부터 시작
		// 작은 자리 + 큰 자리 => 큰 자리에 저장
		// 가장 작은 자리부터 차근 차근 더해가며 마지막 자리에는 아래 
		// r(p_1_lenght + 8) = (p-1)(x^2 + y^2) 
		for(int i = 0 ; i <= end ; i++) {
			if(binaryStr.charAt(end - i) == '0') continue; // 2진법에서 0인 자리는 더하지 않음 
			if(storage == 0) { // 이번이 첫번째 1일 경우
				storage = 8+i; // 더할 값이 아직 없으므로 storage 만 지정하고 끝냄
			}
			
			// 더하기 이전값은 r(storage)
			sb.append("+ ").append(storage).append(" ").append(i).append(" ").append(i).append("\n");
		}
		
		// r(5) : (x+y)^k
		// => r(9) = ((x+y)^k) + ((p-1)(x^k + y^k))
		// 모두 사용완료되었으므로 R9번에 덮어 씌움
		sb.append("+ 5 ").append(end).append(" ").append(9).append("\n");
		
		// 10번 칸까지 고정
		sb.append("+ 3 3 10\n");
	}
	
	static void getBinaryMultiple(StringBuilder sb, int start, int end) {
		
	}
	
	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      

}
