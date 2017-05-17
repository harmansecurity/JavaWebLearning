import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//person µÄ²âÊÔÀà
public class Demo3 {
	private Person p;
	@Before
	public void before(){
		p=new Person();
		System.out.println("before");
	}

	@Test
	public void testRun(){
		//Person p=new Person();
		p.run();
	}
	
	@Test
	public void testEat(){
		//Person p=new Person();
		p.eat();
	}
	
	@After
	public void after(){
		p=null;
		System.out.println("after");
	}
}
