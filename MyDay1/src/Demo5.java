import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//person�Ĳ�����
public class Demo5 {

	@Test
	public void testRun(){
		Person p=new Person();
		//����  �жϲ��Ե�ֵ��������ֵ�Ƿ����
		Assert.assertEquals("1", p.run());
		//p.run();
	}
	
	@Test
	public void testEat(){
		Person p=new Person();
		p.eat();
	}
}
