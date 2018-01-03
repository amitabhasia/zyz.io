package xs.mgr.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {
    
    protected void writeJson(Object o) {
        
        try {
           
            //convert a object to json by fastJson 
            String json = JSON.toJSONStringWithDateFormat(o, "yyyy-MM-dd HH:mm:ss");
            
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            
            ServletActionContext.getResponse().getWriter().write(json);
            //将已经写入缓存的json内容 全部强制输出（给前台）
            ServletActionContext.getResponse().getWriter().flush();
            ServletActionContext.getResponse().getWriter().close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
