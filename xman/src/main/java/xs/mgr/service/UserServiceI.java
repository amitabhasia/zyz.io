package xs.mgr.service;

import java.io.Serializable;

import xs.mgr.model.SysUser;
import xs.mgr.pageModel.User;


public interface UserServiceI {
    
    public void test();
    
    public Serializable save(SysUser t);
    
    public Serializable save(User u);
    
    public void save(String username, String password);
    
    public User login(User u);

}
