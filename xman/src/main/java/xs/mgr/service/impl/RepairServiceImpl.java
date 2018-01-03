package xs.mgr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xs.mgr.dao.MenuDaoI;
import xs.mgr.dao.UserDaoI;
import xs.mgr.model.SysMenu;
import xs.mgr.model.SysUser;
import xs.mgr.service.RepairServiceI;
import xs.mgr.util.Encrypt;

@Service("repairService")
public class RepairServiceImpl implements RepairServiceI {

    @Autowired
    private MenuDaoI menuDao;

    @Autowired
    private UserDaoI userDao;

    @Override
    public void init() {

        initUser();

        initMenu();
    }

    private void initUser() {

        SysUser admin = new SysUser();
        admin.setId("root");
        admin.setUsername("admin");
        admin.setPassword(Encrypt.e("admin"));
        try {
            admin.setCreatedatetime(new SimpleDateFormat("yyyyMMdd").parse("20170729"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        admin.setModifydatetime(new Date());

        userDao.saveOrUpdate(admin);
    }

    private void initMenu() {
        List<SysMenu> listTmenu = new ArrayList<SysMenu>();

        SysMenu root = new SysMenu();
        root.setId("root");
        root.setText("ルート");
        root.setIconCls("");
        root.setUrl("");
        listTmenu.add(root);

        initMenuGroup1(listTmenu, root);

        initMenuGroup2(listTmenu, root);

        initMenuGroup3(listTmenu, root);

        for (SysMenu t : listTmenu) {
            menuDao.saveOrUpdate(t);
        }

    }

    private void initMenuGroup1(List<SysMenu> listTmenu, SysMenu root) {
        SysMenu menuGroup1 = new SysMenu();
        menuGroup1.setId("menuGroup1");
        menuGroup1.setText("従業員管理台帳");
        menuGroup1.setIconCls("");
        menuGroup1.setUrl("");
        menuGroup1.setSysMenu(root);
        listTmenu.add(menuGroup1);
        
        SysMenu mg1_link1 = new SysMenu();
        mg1_link1.setId("mg1_link1");
        mg1_link1.setText("従業員一覧");
        mg1_link1.setIconCls("");
        mg1_link1.setUrl("jsp/emp/employeeList.jsp");
        mg1_link1.setSysMenu(menuGroup1);
        listTmenu.add(mg1_link1);

        SysMenu mg1_link2 = new SysMenu();
        mg1_link2.setId("mg1_link2");
        mg1_link2.setText("基本情報");
        mg1_link2.setIconCls("");
        mg1_link2.setUrl("jsp/emp/basicInfo.jsp");
        mg1_link2.setSysMenu(menuGroup1);
        listTmenu.add(mg1_link2);

        SysMenu mg1_link3 = new SysMenu();
        mg1_link3.setId("mg1_link3");
        mg1_link3.setText("契約情報");
        mg1_link3.setIconCls("");
        mg1_link3.setUrl("jsp/emp/contractInfo.jsp");
        mg1_link3.setSysMenu(menuGroup1);
        listTmenu.add(mg1_link3);

        SysMenu mg1_link4 = new SysMenu();
        mg1_link4.setId("mg1_link4");
        mg1_link4.setText("勤務先情報");
        mg1_link4.setIconCls("");
        mg1_link4.setUrl("jsp/emp/workplaceInfo.jsp");
        mg1_link4.setSysMenu(menuGroup1);
        listTmenu.add(mg1_link4);

        SysMenu mg1_link5 = new SysMenu();
        mg1_link5.setId("mg1_link5");
        mg1_link5.setText("扶養者情報");
        mg1_link5.setIconCls("");
        mg1_link5.setUrl("jsp/emp/relativeInfo.jsp");
        mg1_link5.setSysMenu(menuGroup1);
        listTmenu.add(mg1_link5);

        SysMenu mg1_link6 = new SysMenu();
        mg1_link6.setId("mg1_link6");
        mg1_link6.setText("個人情報");
        mg1_link6.setIconCls("");
        mg1_link6.setUrl("jsp/emp/personalInfo.jsp");
        mg1_link6.setSysMenu(menuGroup1);
        listTmenu.add(mg1_link6);
    }

    private void initMenuGroup2(List<SysMenu> listTmenu, SysMenu root) {
        SysMenu menuGroup2 = new SysMenu();
        menuGroup2.setId("menuGroup2");
        menuGroup2.setText("給与管理台帳");
        menuGroup2.setIconCls("");
        menuGroup2.setUrl("");
        menuGroup2.setSysMenu(root);
        listTmenu.add(menuGroup2);

        SysMenu mg2_link1 = new SysMenu();
        mg2_link1.setId("mg2_link1");
        mg2_link1.setText("給与一括算出");
        mg2_link1.setIconCls("");
        mg2_link1.setUrl("");
        mg2_link1.setSysMenu(menuGroup2);
        listTmenu.add(mg2_link1);

        SysMenu mg2_link2 = new SysMenu();
        mg2_link2.setId("mg2_link2");
        mg2_link2.setText("給与調整確定");
        mg2_link2.setIconCls("");
        mg2_link2.setUrl("");
        mg2_link2.setSysMenu(menuGroup2);
        listTmenu.add(mg2_link2);

        SysMenu mg2_link3 = new SysMenu();
        mg2_link3.setId("mg2_link3");
        mg2_link3.setText("最終承認送信");
        mg2_link3.setIconCls("");
        mg2_link3.setUrl("");
        mg2_link3.setSysMenu(menuGroup2);
        listTmenu.add(mg2_link3);

        SysMenu mg2_link4 = new SysMenu();
        mg2_link4.setId("mg2_link4");
        mg2_link4.setText("給与一覧照会");
        mg2_link4.setIconCls("");
        mg2_link4.setUrl("");
        mg2_link4.setSysMenu(menuGroup2);
        listTmenu.add(mg2_link4);

        SysMenu mg2_link5 = new SysMenu();
        mg2_link5.setId("mg2_link5");
        mg2_link5.setText("月額表マスタ");
        mg2_link5.setIconCls("");
        mg2_link5.setUrl("");
        mg2_link5.setSysMenu(menuGroup2);
        listTmenu.add(mg2_link5);
    }

    private void initMenuGroup3(List<SysMenu> listTmenu, SysMenu root) {
        SysMenu menuGroup3 = new SysMenu();
        menuGroup3.setId("menuGroup3");
        menuGroup3.setText("機能拡張");
        menuGroup3.setIconCls("");
        menuGroup3.setUrl("");
        menuGroup3.setSysMenu(root);
        listTmenu.add(menuGroup3);

        SysMenu mg3_link1 = new SysMenu();
        mg3_link1.setId("mg3_link1");
        mg3_link1.setText("経費管理");
        mg3_link1.setIconCls("");
        mg3_link1.setUrl("");
        mg3_link1.setSysMenu(menuGroup3);
        listTmenu.add(mg3_link1);

        SysMenu mg3_link2 = new SysMenu();
        mg3_link2.setId("mg3_link2");
        mg3_link2.setText("その他");
        mg3_link2.setIconCls("");
        mg3_link2.setUrl("");
        mg3_link2.setSysMenu(menuGroup3);
        listTmenu.add(mg3_link2);
    }

}
