import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//personµƒ≤‚ ‘¿‡
public class Demo4 {
	//private Person p;
	@BeforeClass
	public static void beforeClass(){
		//p=new Person();
		System.out.println("beforeClass");
	}

	@Test
	public void testRun(){
		Person p=new Person();
		p.run();
	}
	
	@Test
	public void testEat(){
		Person p=new Person();
		p.eat();
	}
	
	@AfterClass
	public static void afterClass(){
		//p=null;
		System.out.println("afterClass");
	}
}
