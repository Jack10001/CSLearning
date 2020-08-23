package string;

public class RansomNote_383 {
	//字符创匹配，最好的做法是使用KMP进行匹配
	 public boolean canConstruct(String ransomNote, String magazine) {
	        
	    }

}
class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letter1 = new int[128];
        int[] letter2 = new int[128];
//第一次遍历，记录ransonNote中字母出现的次数；
        for (int i = 0; i < ransomNote.length(); i++){
            letter1[ransomNote.charAt(i)]++;
        }
//第二次遍历，记录magazine中字母出现的次数
        for (int i = 0; i < magazine.length(); i++){
            letter2[magazine.charAt(i)]++;
        }
//保证ransonNote中字母出现的次数 <= magazine中相应字母次数
        for (int i = 0; i < ransomNote.length(); i++){
            if (letter1[ransomNote.charAt(i)] > letter2[ransomNote.charAt(i)]){
                return false;
            }
        }
        return true;

    }
}

