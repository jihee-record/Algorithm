package 백준.백준_2000_2999.백준_2138_전구와스위치_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2138_전구와스위치_G4_172ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] lights1 = new boolean[N];
		boolean[] lights2 = new boolean[N];

		String asis = br.readLine();
		String tobe = br.readLine();
		
		for(int n=0; n<N; n++) {
			if(asis.charAt(n) == tobe.charAt(n)) {
				lights1[n] = true;
				lights2[n] = true;
			}
		}
		
		boolean flag = false;
		// case1
		int cnt1 = 1;
		lights1[0] = !lights1[0];
		lights1[1] = !lights1[1];
		
		for(int n=1; n<N-1;  n++) { // 0 -> N-3
			if(!lights1[n-1]) { // n-1번째가 다르면 n을 누름  
				lights1[n] = !lights1[n];
				lights1[n+1] = !lights1[n+1];
				cnt1++;
			}
		}
		
		if(!lights1[N-2]) {
			lights1[N-1] = !lights1[N-1];
			cnt1++;
		}
		
		if(lights1[N-1]) flag = true;
		else cnt1 = Integer.MAX_VALUE;
		
		// case2
		int cnt2 = 0;
		for(int n=1; n<N-1;  n++) { // 0 -> N-3
			if(!lights2[n-1]) { // n-1번째가 다르면 n을 누름  
				lights2[n] = !lights2[n];
				lights2[n+1] = !lights2[n+1];
				cnt2++;
			}
		}
		

		if(!lights2[N-2]) {
			lights2[N-1] = !lights1[N-1];
			cnt2++;
		}
		
		if(lights2[N-1]) flag = true;
		else cnt2 = Integer.MAX_VALUE;
		
		if(flag) System.out.println(Math.min(cnt1, cnt2));
		else System.out.println(-1);
		br.close();
	}

}
