package learn_Arrya;

public class Reverse {
	 public void reverseString(char[] s) {
	        int len=s.length;
	        if(len==0)
	            return;
	        else
	            reverse(s,0,len-1);
	    }
	    
	    public void reverse(char[] s,int start,int end){
	        if(start>=end)
	            return;
	        else{
	            reverse(s,start+1,end-1);
	            
	        }
	        
	        char tmp;
	        tmp=s[start]; 
	        s[start]=s[end];
	        s[end]=tmp;
	    }

}
