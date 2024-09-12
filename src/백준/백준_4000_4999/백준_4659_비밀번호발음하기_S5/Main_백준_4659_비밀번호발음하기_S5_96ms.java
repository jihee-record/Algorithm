package 백준.백준_4000_4999.백준_4659_비밀번호발음하기_S5;

import java.util.*;
public class Main_백준_4659_비밀번호발음하기_S5_96ms {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<String> set = new HashSet<>(5);
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");
		
		while(true) {
			String str = sc.next();
			if(str.equals("end")) {
				break;
			}
			
			//a자음 b모음 vowel 모음사용개수
			int fail = 0;//0성공 1실패
			int a = 0; 
			int b = 0;
			int vowel = 0;
			
			//직전 문자
			String last = "";
			String[] arr = str.split("");
			
			for(int i=0; i<arr.length; i++) {
				String now = arr[i];
				//지난 문자랑 같은데 e나 o가 아니야 > 실패
				if(last.equals(now) && !now.equals("e") & !now.equals("o")) {
					fail = 1;
					break;
				}
				
				//모음이야
				if(set.contains(now)) {
					//근데 이미 이전 모음 두개 씀
					if(b>=2) {
						fail = 1;
						break;
					}
					//두개 안씀 자음 0 모음 ++
					a=0;
					b++;
					vowel++;
					
					//자음이야
				}else {
					//자음 두번?
					if(a>=2) {
						fail = 1;
						break;
					}
					
					a++;
					b=0;
				}
				
				last = now;
			}
			
			if(fail==0 && vowel>0) {
				System.out.println("<"+str+"> is acceptable.");
			}else {
				System.out.println("<"+str+"> is not acceptable.");
			}
			
		}
		
		sc.close();
		
	}
}