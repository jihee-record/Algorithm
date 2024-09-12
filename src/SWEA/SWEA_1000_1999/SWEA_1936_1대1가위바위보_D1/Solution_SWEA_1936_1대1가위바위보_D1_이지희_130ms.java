package SWEA.SWEA_1000_1999.SWEA_1936_1대1가위바위보_D1;
import java.util.Scanner;

public class Solution_SWEA_1936_1대1가위바위보_D1_이지희_130ms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a == 1) {
            if(b == 2) System.out.println("B");
            else System.out.println("B");
        }else if(a == 2) {
            if(b == 1) System.out.println("A");
            else System.out.println("B");
        }else {
            if(b == 1) System.out.println("B");
            else System.out.println("A");
        }
        sc.close();
    }
}
