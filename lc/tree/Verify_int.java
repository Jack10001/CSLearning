package tree;

public class Verify_int {
	public  void setval( Integer i)
	{
	     i++;
	     System.out.println(i+",hashcode:"+i.hashCode());
	}
    public static void main(String[] args) {
    	//�������͵İ�װ���Լ�String��ʵ����Ϊ�������Ǵ����ã�final�ؼ������Σ�ֵ�������������ܹ���ֵ����Ϊ�����������������µ�Integer����
    	Integer a = new Integer(5);
    	Verify_int verify_int=new Verify_int();
    	verify_int.setval(a);
    	System.out.print(a+",hashcode:"+a.hashCode());
		
	}
	

}
