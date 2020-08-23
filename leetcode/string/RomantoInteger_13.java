package string;

public class RomantoInteger_13 {
	 public int romanToInt(String s) {
	        return 0;
	    }

}


class Solution_13 {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0;i<s.length();i++){
            if(i+1 < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i+1)))
                res = res - getValue(s.charAt(i));
            else 
                res = res + getValue(s.charAt(i));
        }
        return res;
    }
    public int getValue(char c){
        switch(c){
                case 'I' : return 1;
                case 'V' : return 5;
                case 'X' : return 10;
                case 'L' : return 50;
                case 'C' : return 100;
                case 'D' : return 500;
                case 'M' : return 1000;
        }
        return 0;
    }
}