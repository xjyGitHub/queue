package queue;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.ICustomerService;
import service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class ServiceImplTest {
	@Resource
	private IUserService userService;
	@Resource
	private ICustomerService customerService;

	@Test
	public void test() {
		
		
	}

}
