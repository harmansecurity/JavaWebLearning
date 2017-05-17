package junit.test;

import java.util.Date;

import org.junit.Test;

import com.ecnu.domain.User;
import com.ecnu.exception.UserExistException;
import com.ecnu.service.impl.BussinessServiceImpl;

public class ServiceTest {
	@Test
	public void testRegister(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("542351");
		user.setId("34");
		user.setNickname("xiaowang");
		user.setPassword("345");
		user.setUsername("lianghui");
		
		BussinessServiceImpl service = new BussinessServiceImpl();
		try {
			service.register(user);
			System.out.println("注册成功");
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			System.out.println("用户已存在");
		}
	}
	@Test
	public void testLogin(){
		BussinessServiceImpl service = new BussinessServiceImpl();
		User user = service.login("lianghui", "345");
		System.out.println(user);
	}
}
