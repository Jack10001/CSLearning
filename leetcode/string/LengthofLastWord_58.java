package string;

public class LengthofLastWord_58 {
	 public int lengthOfLastWord(String s) {
		  if(s.length()<1 || s==null ) return 0;
		  String[] strs=s.split(" ");
		  if(strs.length<1) return 0;
		  int size=strs.length;
		  return strs[size-1].length();
		  
	        
	    }
	  public static void main(String[] args) {
		String string=null;
		//String[] strings=string.split(" ");
		System.out.println(string.length());
	}

}
