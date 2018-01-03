package xs.mgr.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import xs.mgr.model.SysUser;
import xs.mgr.pageModel.Json;
import xs.mgr.pageModel.User;
import xs.mgr.service.UserServiceI;

import com.opensymphony.xwork2.ModelDriven;

//@ParentPackage("basePackage")
//@Namespace("/")
@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

    private static final Logger logger = Logger.getLogger(UserAction.class);

    // @Autowired 既可以直接写在属性上 也可以写在属性的setter上
    // 如果写在属性上 ，则Spring自动将其变成公有public来使用
    // 如果写在setter上，则属性依然为类内部私有private
    @Autowired
    private UserServiceI userService;

    /**
     * Struts2 整合到Spring的test
     */
    public void test() {
        logger.info("welcome to my world");
        userService.test();

    }

    /**
     * Hibernate4 整合到Spring的test
     */
    public void addUser() {

        logger.info("adduser Start");

        SysUser user = new SysUser();

        // 36位不重复ID 几万年也不重复
        user.setId(UUID.randomUUID().toString());
        user.setUsername("userAction");
        user.setPassword("password");
        user.setCreatedatetime(new Date());
        user.setModifydatetime(new Date());

        userService.save(user);

        logger.info("adduser End");
    }

    /**
     * 用户注册 方式1
     * 
     * ServerletActionContext.getRequest().getParameter()的方式 获取前台传递过来的Form的值
     * 
     * 处理结果以json的形式返回给前台页面的ajax或者JQuery等JavaScript函数
     * 
     */
    public void registerByServletActionContextParameter() {

        String username = ServletActionContext.getRequest().getParameter("username");
        String password = ServletActionContext.getRequest().getParameter("password");

        // deal with Json using alibaba fastJson
        // String Json = null;
        Map<String, Object> json = new HashMap<String, Object>();

        try {
            // save方法上织入了事务管理 所以可以提交 但add上没有，所以用add无法成功保存数据到数据库
            userService.save(username, password);
            // Json = "{\"success\":true,\"msg\":\"register successfully\"}";
            json.put("success", true);
            json.put("message", "登録成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // Json = "{\"success\":false,\"msg\":\"failure to register\"}";
            json.put("success", false);
            json.put("message", e.getMessage());
        }

        super.writeJson(json);
    }

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户注册 方式2
     * 
     * 用 setter()的方式 来获取前台传递过来的表单FORM 并将Form中的值 设置到此Action实例的对应的属性上
     * 
     */
    public void registerBySetClassProperty() {

        Map<String, Object> json = new HashMap<String, Object>();

        try {
            userService.save(username, password);
            json.put("success", true);
            json.put("message", "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("success", false);
            json.put("message", e.getMessage());

        }

        super.writeJson(json);
    }

    // ModelDriven<User>的pageModel
    // 必须new一个实例 分配物理地址
    private User user = new User();

    // 上面实例化的user由此方法进行注入具体值
    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }

    /**
     * 用户注册 方式3
     * 
     * 用模型驱动ModelDriven的方式 来获取前台传递过来的表单FORM 并用getModel的方法 将Form中的值设置到user属性上
     * 
     */
    public void registerByModelDriven() {

        Map<String, Object> json = new HashMap<String, Object>();

        try {
            userService.save(user);
            json.put("success", true);
            json.put("message", "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("success", false);
            json.put("message", e.getMessage());

        }

        super.writeJson(json);
    }

    /**
     * 用户登录
     * 
     * 
     */
    public void login() {

        User u = userService.login(user);

        Json j = new Json();

        if (u != null) {
            j.setSuccess(true);
            j.setMessage("Login Successfully!");
        } else {
            j.setSuccess(false);
            j.setMessage("Failure to Login");
        }

        super.writeJson(j);
    }
}
