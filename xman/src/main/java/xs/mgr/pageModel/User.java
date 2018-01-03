package xs.mgr.pageModel;

import java.util.Date;

public class User implements java.io.Serializable{
    
    
    private String id;
    private String username;
    private String password;
    private Date createdatetime;
    private Date modifydatetime;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreatedatetime() {
        return createdatetime;
    }
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }
    public Date getModifydatetime() {
        return modifydatetime;
    }
    public void setModifydatetime(Date modifydatetime) {
        this.modifydatetime = modifydatetime;
    }

}
