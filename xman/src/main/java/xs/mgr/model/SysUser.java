package xs.mgr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user", schema = "xman", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class SysUser implements java.io.Serializable {

    private String id;
    private String username;
    private String password;
    private Date createdatetime;
    private Date modifydatetime;

    // Constructors

    /** default constructor */
    public SysUser() {
    }

    /** minimal constructor */
    public SysUser(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /** full constructor */
    public SysUser(String id, String username, String password, Date createdatetime, Date modifydatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdatetime = createdatetime;
        this.modifydatetime = modifydatetime;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "USERNAME", unique = true, nullable = false, length = 100)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD", nullable = false, length = 32)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDATETIME", length = 7)
    public Date getCreatedatetime() {
        return this.createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFYDATETIME", length = 7)
    public Date getModifydatetime() {
        return this.modifydatetime;
    }

    public void setModifydatetime(Date modifydatetime) {
        this.modifydatetime = modifydatetime;
    }

}