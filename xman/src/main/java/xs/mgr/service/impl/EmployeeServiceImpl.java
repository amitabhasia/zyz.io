package xs.mgr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xs.mgr.dao.EmployeeDaoI;
import xs.mgr.model.EmpBasicInfo;
import xs.mgr.pageModel.DataGrid;
import xs.mgr.pageModel.Employee;
import xs.mgr.service.EmployeeServiceI;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeServiceI {

    @Autowired
    private EmployeeDaoI employeeDao;

    @Override
    public DataGrid dataGrid(Employee emp) {

        DataGrid dg = new DataGrid();

        // hql的定义
        String hql = "from EmpBasicInfo t where 1=1 ";

        // params的定义
        Map<String, Object> params = new HashMap<String, Object>();

        if (emp.getEmpCode() != null && emp.getEmpCode().trim() != "") {
            hql += " and t.empCode like :empCode ";
            params.put("empCode", "%%" + emp.getEmpCode().trim() + "%%");
        }

        if (emp.getEmpName() != null && emp.getEmpName().trim() != "") {
            hql += " and ( t.empName like :empName ";
            hql += "    or t.empNameKata like :empName ";
            hql += "    or t.empNameRoma like :empName ) ";

            params.put("empName", "%%" + emp.getEmpName().trim() + "%%");
        }

        if (emp.getEmpPhone() != null && emp.getEmpPhone().trim() != "") {
            hql += " and t.empPhone like :empPhone ";
            params.put("empPhone", "%%" + emp.getEmpPhone().trim() + "%%");
        }

        if (emp.getEmpPost() != null && emp.getEmpPost().trim() != "") {
            hql += " and t.empPost like :empPost ";
            params.put("empPost", "%%" + emp.getEmpPost().trim() + "%%");
        }

        
        // Map<String, Object> params2 = new HashMap<String, Object>();
        // for (Field f : emp.getClass().getDeclaredFields()) {
        // String fieldName = f.getName();
        // String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        // try {
        // // 动态方法调用
        // // getClass 获取类
        // // getMethod(methodName,paraType) 获取名为methodName 参数类型为paraType的方法
        // // invoke(emp,paraValue)　インスタンスがempでパラメータがparaValueで呼び出す
        // Object obj = emp.getClass().getMethod(methodName, new Class[] {}).invoke(emp, new Object[] {});
        //
        // if (obj != null) {
        // if (obj instanceof String && ((String) obj).trim() != "") {
        // params2.put(fieldName, obj);
        // } else {
        // params2.put(fieldName, obj);
        // }
        // }
        // } catch (IllegalAccessException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IllegalArgumentException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (InvocationTargetException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (NoSuchMethodException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (SecurityException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }

        // 从数据库中获取DataGrid所需属性的total值
        Long total = employeeDao.count(hql, params);

        // 如果排序的属性值不为空 则拼接字符串进行排序
        if (emp.getSort() != null && emp.getOrder() != null) {
            hql = hql + " order by " + emp.getSort() + " " + emp.getOrder();
        }

        // 从数据库中获取DataGrid所需的第二个属性rows所需的值
        List<EmpBasicInfo> listE = employeeDao.find(hql, emp.getPage(), emp.getRows(), params);

        // 将从数据库中取得的数据进行编辑 并放入rows列表中
        List<Employee> rows = new ArrayList<Employee>();

        if (listE != null && listE.size() > 0) {
            for (EmpBasicInfo e : listE) {

                Employee r = new Employee();

                BeanUtils.copyProperties(e, r, new String[] { "empBirthdate" });

                if (null != e.getEmpBirthdate()) {
                    r.setEmpBirthdate(new SimpleDateFormat("yyyy/MM/dd").format(e.getEmpBirthdate()));
                }
                rows.add(r);
            }
        }

        // 设置DataGird所需属性
        dg.setTotal(total);
        dg.setRows(rows);

        return dg;
    }

    @Override
    public void saveOrUpdate(Employee emp) throws Throwable{

        EmpBasicInfo tgt = new EmpBasicInfo();

        BeanUtils.copyProperties(emp, tgt, new String[] { "empBirthdate" });

        if (null != emp.getEmpBirthdate()) {
            tgt.setEmpBirthdate(new SimpleDateFormat("yyyy/MM/dd").parse(emp.getEmpBirthdate()));
        }
        employeeDao.saveOrUpdate(tgt);
    }

    @Override
    public Employee getByID(String empCode) {

        // hql的定义
        String hql = "from EmpBasicInfo t where 1=1 ";

        // params的定义
        Map<String, Object> params = new HashMap<String, Object>();

        if (empCode != null && empCode.trim() != "") {
            hql += " and t.empCode = :empCode ";
            params.put("empCode", empCode);
        }

        EmpBasicInfo ebi = employeeDao.get(hql, params);
        Employee emp = new Employee();

        BeanUtils.copyProperties(ebi, emp, new String[] { "empBirthdate" });

        if (null != ebi.getEmpBirthdate()) {
            emp.setEmpBirthdate(new SimpleDateFormat("yyyy/MM/dd").format(ebi.getEmpBirthdate()));
        }

        return emp;
    }

}
