package tree;

public class Verify_int {
	public  void setval( Integer i)
	{
	     i++;
	     System.out.println(i+",hashcode:"+i.hashCode());
	}
    public static void main(String[] args) {
    	//基本类型的包装类以及String的实例作为参数不是传引用，final关键字修饰，值被当作常量，能够赋值是因为编译器重新生成了新的Integer对象
    	Integer a = new Integer(5);
    	Verify_int verify_int=new Verify_int();
    	verify_int.setval(a);
    	System.out.print(a+",hashcode:"+a.hashCode());
		
	}
	

}
