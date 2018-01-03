package xs.mgr.dao.impl;

import org.springframework.stereotype.Repository;

import xs.mgr.dao.EmployeeDaoI;
import xs.mgr.model.EmpBasicInfo;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl<EmpBasicInfo> implements EmployeeDaoI {
}
