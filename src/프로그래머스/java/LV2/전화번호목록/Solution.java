package 프로그래머스.java.LV2.전화번호목록;

import java.util.Arrays;

public class Solution {
	
public boolean solution(String[] phone_book) {
	   
	   Arrays.sort(phone_book);
	   
	   for(int i=1; i<phone_book.length; i++) {
		   int a = phone_book[i].length();
		   int b = phone_book[i-1].length();
		   if(a>b && phone_book[i].substring(0, b).equals(phone_book[i-1]))  return false;
	   }
	   
	   return true;
   }
   
}