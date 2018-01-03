package xs.mgr.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import xs.mgr.pageModel.Employee;
import xs.mgr.pageModel.Json;
import xs.mgr.service.EmployeeServiceI;

import com.opensymphony.xwork2.ModelDriven;

@Action("employeeAction")
public class EmployeeAction extends BaseAction implements ModelDriven<Employee> {

    private Employee employee = new Employee();

    @Override
    public Employee getModel() {
        return employee;
    }

    @Autowired
    private EmployeeServiceI empBasicService;

    /**
     * 従業員の基本情報取得
     */
    public void dataGrid() {
        super.writeJson(empBasicService.dataGrid(employee));
    }

    /**
     * 従業員の基本情報取得
     */
    public void getByID() {
        String empCode = employee.getEmpCode();
        super.writeJson(empBasicService.getByID(empCode));
    }

    /**
     * 従業員の基本情報登録・更新
     */
    public void saveOrUpdate() {
        Json j = new Json();

        try {
            empBasicService.saveOrUpdate(employee);
            j.setSuccess(true);
            j.setMessage("従業員登録・更新成功");
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            j.setSuccess(false);
            j.setMessage(e.getMessage());
        }

        super.writeJson(j);
    }

}
