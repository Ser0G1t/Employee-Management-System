package CRM.service;

import CRM.entity.Employee;
import CRM.entity.Skill;
import CRM.enums.SkillLevel;
import CRM.exceptionHandling.EntityNotFoundException;
import CRM.repository.EmployeeRepository;
import CRM.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCrudService {
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    public EmployeeCrudService(EmployeeRepository employeeRepository, SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(Employee employee){
        employee.setName(employee.getName());
        employee.setLastName(employee.getLastName());
        employee.setAge(employee.getAge());
    }
    public Employee findById(long employeeId){
        return employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EntityNotFoundException("Entity (Employee) with this ID can't be found"));
    }
    public void addNewSkill(long employeeId, long skillId){
        Employee employee = findById(employeeId);
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(()-> new EntityNotFoundException("Entity (Employee) with this ID can't be found"));
        employee.addSkill(skill);
        //TODO : Check is it necessary
        employeeRepository.save(employee);
    }
    public void updateSkillLevel(long employeeId, long skillId, SkillLevel level){
        Employee employee = findById(employeeId);
        Skill skill = employee.getSkill(skillId)
                .orElseThrow(()-> new EntityNotFoundException("Entity (Skill) with this ID can't be found in Employee skills set"));
        skill.setSkillLevel(level);
        employeeRepository.save(employee);
    }
}
