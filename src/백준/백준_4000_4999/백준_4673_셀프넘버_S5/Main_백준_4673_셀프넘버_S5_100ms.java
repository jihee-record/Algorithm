package 백준.백준_4000_4999.백준_4673_셀프넘버_S5;

public class Main_백준_4673_셀프넘버_S5_100ms {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		boolean[] generated = new boolean[10001]; 
		
		for(int i=1; i<=10000; i++) {
			if(!generated[i]) sb.append(i).append("\n");
			
			int temp = i;
			int dn = i;
			while(temp > 0) {
				dn += temp % 10;
				temp /= 10;
			}
			
			if(dn <= 10000) generated[dn] = true;
		}
		
		System.out.println(sb.toString());
		
	}
}
