package CRM.IService;

import CRM.entity.Employee;
import CRM.enums.SkillLevel;

public interface IEmployeeCrudService extends ICoreCrudService<Employee> {
    void updateEmployee(Employee employee);
    void addNewSkill(long employeeId, long skillId);
}
