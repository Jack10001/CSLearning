package string;

public class Integer2Roman_12 {
	public String intToRoman(int num) {
	        
	    }
	private String getString(int num) {
		switch(num) {
		 case 1 : return "I";
         case 5 : return "V";
         case 10 : return "X";
         case 50 : return "L";
         case 100 : return "C";
         case 500 : return "D";
         case 1000 : return "M";
         case 4:return "IV";
         case 9:return "IX";
         case 40:return "XL";
         case 90:return "XC";
         case 400:return "CD";
         case 900:return "CM";
		
		}
		return null;
	}

}


class Solution{
	//̰���㷨
	 public String intToRoman(int num) {
	        // �Ѱ������������������ֿ��ܳ��ֵ���������Ͷ�Ӧ��ϵ����������������
	        // ���Ұ��հ��������ֵĴ�С�������У�����̰��ѡ��˼��
	        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	        StringBuilder stringBuilder = new StringBuilder();
	        int index = 0;
	        while (index < 13) {
	            // �ر�ע�⣺�����ǵȺ�
	            while (num >= nums[index]) {
	                // ע�⣺�����ǵ��ںţ���ʾ����ʹ�ô��"��ֵ"
	                stringBuilder.append(romans[index]);
	                num -= nums[index];
	            }
	            index++;
	        }
	        return stringBuilder.toString();
	    }
}
