package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ReverseVowelsofaString_345 {
	
	 public String reverseVowels(String s) {
		 /**
		  * 鍙屾寚閽堬紝浠庝袱澶村悜涓棿閬嶅巻锛屾�濊矾绫讳技浜庡揩閫熸帓搴忎腑鐨勫弻鎸囬拡
		  */
		  if(s.length()==0) return "";
          if(s.length()==1) return s;
		  int low=0,high=s.length()-1;
		  Set<Character> characters=new HashSet<>(Arrays.asList('a','o','e','i','u','A','O','E','I','U'));
		  char[] chars=s.toCharArray();
		  
		  while(low<high){
//			  for(int i=low;i<high;i++) {
//				  if(characters.contains(s.charAt(i))) {
//					  low=i;
//					  break;
//				  }
//			  }
//			  for(int j=high;j>low;j--) {
//				  if(characters.contains(s.charAt(j))) {
//					  high=j;
//					  break;
//				  }
//			  }
			  while(low<high && !characters.contains(s.charAt(low))) low++;
			  while(low<high && !characters.contains(s.charAt(high))) high--;
			  char tmp=chars[low];
			  chars[low]=chars[high];
			  chars[high]=tmp;
			  low++;
			  high--;

		  }
		  return String.valueOf(chars);
	        
	    }

}


class Solution_345 {
    public String reverseVowels(String s) {
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for(char ch : "aeiouAEIOU".toCharArray()) set.add(ch);
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            while(i < j && !set.contains(s.charAt(i))) i++;
            while(i < j && !set.contains(s.charAt(j))) j--;
            
            //swap here
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
        return String.valueOf(chars);
    }
}