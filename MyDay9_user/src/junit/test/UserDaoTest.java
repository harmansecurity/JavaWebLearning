package junit.test;

import java.util.Date;

import org.junit.Test;

import com.ecnu.dao.UserDao;
import com.ecnu.dao.impl.UserDaoImpl;
import com.ecnu.domain.User;

public class UserDaoTest {
	@Test
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("542351");
		user.setId("34");
		user.setNickname("xiaowang");
		user.setPassword("345");
		user.setUsername("gsdfgsd");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		dao.find("aaa","123143");
	}
}
