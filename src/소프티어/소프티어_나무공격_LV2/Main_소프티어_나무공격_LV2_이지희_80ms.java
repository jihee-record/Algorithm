package 소프티어.소프티어_나무공격_LV2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_소프티어_나무공격_LV2_이지희_80ms {
	static int N, M;
	static int[] destroyer;
	static void kill(int row1, int row2) {
		for(int r=row1; r<=row2; r++) {
			if(destroyer[r] > 0) destroyer[r]--;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		
		destroyer = new int[N]; // 행별 파괴자 수
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				if(st.nextToken().equals("1")) destroyer[n]++;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int row1 = Integer.parseInt(st.nextToken());
		int row2 = Integer.parseInt(st.nextToken());
		kill(row1-1, row2-1);
		
		st = new StringTokenizer(br.readLine());
		row1 = Integer.parseInt(st.nextToken());
		row2 = Integer.parseInt(st.nextToken());
		kill(row1-1, row2-1);
		int result = 0;
		for(int n=0; n<N; n++) {
			result += destroyer[n];
		}
		
		System.out.println(result);
		br.close();
	}

}
