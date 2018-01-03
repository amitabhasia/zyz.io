package xs.mgr.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_menu", catalog = "xman")
public class SysMenu implements java.io.Serializable {

    // Fields

    private String id;
    private SysMenu sysMenu;
    private String text;
    private String iconCls;
    private String url;
    private Set<SysMenu> sysMenus = new HashSet<SysMenu>(0);

    // Constructors

    /** default constructor */
    public SysMenu() {
    }

    /** minimal constructor */
    public SysMenu(String id) {
        this.id = id;
    }

    /** full constructor */
    public SysMenu(String id, SysMenu sysMenu, String text, String iconCls, String url, Set<SysMenu> sysMenus) {
        this.id = id;
        this.sysMenu = sysMenu;
        this.text = text;
        this.iconCls = iconCls;
        this.url = url;
        this.sysMenus = sysMenus;
    }

    // Property accessors
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    public SysMenu getSysMenu() {
        return this.sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }

    @Column(name = "text", length = 100)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "iconCls", length = 50)
    public String getIconCls() {
        return this.iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Column(name = "url", length = 200)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysMenu")
    public Set<SysMenu> getSysMenus() {
        return this.sysMenus;
    }

    public void setSysMenus(Set<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }

}