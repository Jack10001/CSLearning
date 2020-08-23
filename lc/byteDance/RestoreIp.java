package byteDance;

import java.util.ArrayList;
import java.util.List;

public class RestoreIp {
	//动态规划 贪心算法
	    public List<String> restoreIpAddresses(String s) {
	        
	    }

}

class RestoreIPAddress {

    public static void main(String[] args) {
        List<String> strings = new RestoreIPAddress().restoreIpAddressesNew("25525511135");
    }

    private List<String> restoreIpAddressesNew(String s) {
        List<String> result = new ArrayList<>();
        restoreAddressNew(s, "", 0, 0, result);
        return result;
    }

    
    private void restoreAddressNew(String source, String currentStr, Integer currentLevel, Integer offset, List<String> res) {
        if (currentLevel == 3) {//.的个数
            if (isValidNew(source.substring(offset))) {
                res.add(currentStr + "." + source.substring(offset));

            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (offset > source.length() || (offset + i) > source.length()) {
                return;
            }
            String seg = source.substring(offset, offset + i);
            String oldStr = currentStr;
            if (currentStr.length() == 0) {
                currentStr = seg;
            } else {
                currentStr = currentStr + "." + seg;
            }
            if (isValidNew(seg)) {
                restoreAddressNew(source, currentStr, currentLevel + 1, offset + i, res);
                currentStr = oldStr;
            }
        }
    }

    private boolean isValidNew(String str) {
        if (str.length() == 0 || str.length() > 3 || Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255
                || (str.startsWith("0") && str.length() > 1)
                ) {
            return false;
        }
        return true;
    }
    
}

class Solution_93{
	// divide and check
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        restore(result, s, new StringBuilder(), 0, 0);
        return result;
    }
    
    private void restore(List<String> result, String s, StringBuilder sb, int start, int count) {
        if (count == 3) { // already fix 3 seg
            String seg = s.substring(start);
            if (isValidSeg(seg)) {
                sb.append(Integer.parseInt(seg));
                result.add(sb.toString());
            }
        } else {
            int sbLength = sb.length(); // to restore string builder
            for (int i = start + 1; i < start + 4 && i < s.length(); i ++) {
                String seg = s.substring(start, i);
                if (isValidSeg(seg)) {
                    sb.append(Integer.parseInt(seg));
                    sb.append('.');
                    restore(result, s, sb, i, count + 1);
                    sb.setLength(sbLength);
                }
            }
        }
    }
    
    private boolean isValidSeg(String seg) {
        if (seg.equals("") || seg.length() > 3) { // length constraint
            return false;
        }
        if (seg.length() > 1 && seg.charAt(0) == '0') { // "0" constraint
            return false;
        }
        int value = Integer.parseInt(seg);
        if (value < 0 || value > 255) { // value constraint
            return false;
        }
        return true;
    }
}
