package xs.mgr.service;

import xs.mgr.pageModel.DataGrid;
import xs.mgr.pageModel.Employee;

public interface EmployeeServiceI {

    // データグリッドの取得
    public DataGrid dataGrid(Employee emp);
    
    // 従業員基本情報の取得
    public Employee getByID(String empCode);

    //　従業員の登録・更新
    public void saveOrUpdate(Employee emp) throws Throwable;

}
