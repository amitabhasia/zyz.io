package serviceTest;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xs.mgr.model.SysUser;
import xs.mgr.service.UserServiceI;

public class UserServiceTest {

    //@Test
    public void test() {

        // 获得Spring的上下文（环境）
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:spring.xml",
                "classpath:spring-hibernate.xml" });
        
        UserServiceI userService = (UserServiceI)ac.getBean("userService");

        SysUser user = new SysUser();
        
        // 36位不重复ID 几万年也不重复 
        user.setId(UUID.randomUUID().toString());
        user.setUsername("ZhaoYZ");
        user.setPassword("password");
        user.setCreatedatetime(new Date());
        user.setModifydatetime(new Date());

        userService.save(user);
    }
}
