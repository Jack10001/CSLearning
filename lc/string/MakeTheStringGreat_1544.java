package string;

import java.util.Stack;

public class MakeTheStringGreat_1544{
    public String makeGood(String s) {
        if(s.length()==0) return s;
        if(s.length()==1) return s;
        int size=s.length();
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        boolean flag;
        while(i<size){
        	flag=false;
            if(i+1<size && ((sb.charAt(i)==sb.charAt(i+1)-32) || (sb.charAt(i)==sb.charAt(i+1)+32))){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                size=sb.length();
                flag=true;
                
            }
            if(flag) i=0;
            else i++;
        
        }
        return sb.toString();
        
    }

}

class Solution_1544 {
	//使用栈的思想解决配对问题
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        char res[] = new char[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return new String(res);
    }
}