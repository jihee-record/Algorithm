package 백준.백준_2000_2999.백준_2755_이번학기평점은몇점_B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2755_이번학기평점은몇점_B1_108ms {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		double score = 0;
		while(N --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			
			int time = Integer.parseInt(st.nextToken());
			String grade = st.nextToken();
			total += time;
			switch(grade) {
			case "A+":
				score += time * 4.3;
				break;
			case "A0":
				score += time * 4.0;
				break;
			case "A-":
				score += time * 3.7;
				break;
			case "B+":
				score += time * 3.3;
				break;
			case "B0":
				score += time * 3.0;
				break;
			case "B-":
				score += time * 2.7;
				break;
			case "C+":
				score += time * 2.3;
				break;
			case "C0":
				score += time * 2.0;
				break;
			case "C-":
				score += time * 1.7;
				break;
			case "D+":
				score += time * 1.3;
				break;
			case "D0":
				score += time * 1.0;
				break;
			case "D-":
				score += time * 0.7;
				break;
			case "F":
				break;
			}
		}
		
		double result = (double)Math.round(score / total * 100) / 100;
		System.out.printf("%.2f\n", result);
		br.close();
	}

}
