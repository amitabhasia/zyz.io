package xs.mgr.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import xs.mgr.service.RepairServiceI;


@Action("repairAction")
public class RepairAction extends BaseAction {
    
    @Autowired
    private RepairServiceI repairService;
    
    public void repair() {
        // 最开始我写了个叫做repair的方法来初始化Menu
        // 但无论怎么尝试都无法存入数据
        // 后来才发现是事务的配置中 没有关于repair的织入点 默认为只读。。。
        repairService.init();
    }

}
