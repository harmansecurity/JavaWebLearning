import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//person的测试类
public class Demo5 {

	@Test
	public void testRun(){
		Person p=new Person();
		//断言  判断测试的值和期望的值是否相等
		Assert.assertEquals("1", p.run());
		//p.run();
	}
	
	@Test
	public void testEat(){
		Person p=new Person();
		p.eat();
	}
}
