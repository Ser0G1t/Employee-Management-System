package CRM.service;

import CRM.entity.Employee;
import CRM.entity.Skill;
import CRM.enums.SkillLevel;
import CRM.exceptionHandling.EntityNotFoundException;
import CRM.repository.EmployeeRepository;
import CRM.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCrudService extends CoreCrudService<Employee> {
    private final EmployeeRepository employeeRepository;
    private final SkillCrudService skillService;

    public EmployeeCrudService(EmployeeRepository employeeRepository, SkillCrudService skillService) {
        this.employeeRepository = employeeRepository;
        this.skillService = skillService;
    }

    public void updateEmployee(Employee employee) {
        employee.setName(employee.getName());
        employee.setLastName(employee.getLastName());
        employee.setAge(employee.getAge());
        employeeRepository.save(employee);
    }

    public void addNewSkill(long employeeId, long skillId) {
        var employee = findById(employeeId);
        var skill = skillService.findById(skillId);
        employee.addSkill(skill);
        //TODO : Check is it necessary
        employeeRepository.save(employee);
    }

    public void updateSkillLevel(long employeeId, long skillId, SkillLevel level) {
        Employee employee = findById(employeeId);
        Skill skill = employee.getSkill(skillId)
                .orElseThrow(() -> new EntityNotFoundException("Entity (Skill) with this ID can't be found in Employee skills set"));
        skill.setSkillLevel(level);
        employeeRepository.save(employee);
    }
}
